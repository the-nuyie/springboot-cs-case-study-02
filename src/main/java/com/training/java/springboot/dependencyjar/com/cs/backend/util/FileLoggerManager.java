package com.training.java.springboot.dependencyjar.com.cs.backend.util;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Properties;
import java.util.Enumeration;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FileLoggerManager {
    private static final String LOG_CONFIG_ID = "FileLoggerManager";
    private static final String LOG_ID = "FileLoggerManager";

    /* Formatters */
    private static final SimpleDateFormat DateTimeFormatter =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    private static FileLoggerManager loggerMgr = null;
    private static FileLogger fLogger = null;
    private Properties logProps = null;
    @SuppressWarnings("rawtypes")
    private static Hashtable loggers = new Hashtable();
    @SuppressWarnings("rawtypes")
    private static Hashtable configs = new Hashtable();
    @SuppressWarnings("rawtypes")
    private Hashtable psfixCache = null;
    public static boolean ManualLoadConfig = false;

    /* For use in checking log.properties file update */
    private String logPropsFilePath;
    private long lastModified;
    private long latestLastModified;

    private FileLoggerManager() {
        try {
            if (!ManualLoadConfig) {
                logPropsFilePath =/*C:\Program Files\IBM\SDP\config\log.properties*/
                        ConfigurationManager.getInstance().getProperty(
                                "log.propertie.file");
                loadConfig();
            } else {
                System.out.println("ManualLoadConfig == true");
            }

        } catch (Exception e) {
            //System.err.println("FileLoggerManager");
            e.printStackTrace();
        }
    }

    public static synchronized FileLoggerManager getInstance() {
        if (loggerMgr == null) {
            loggerMgr = new FileLoggerManager();
        }
        return loggerMgr;
    }

    public synchronized void loadConfigFromFile(String filePath) {
        logPropsFilePath = filePath;
        if (configs != null) {
            configs.clear();
        }
        if (loggers != null) {
            loggers.clear();
        }
        loadConfig();
    }

    private void loadConfig() {
        try {
            if (logProps == null) {
                logProps = new Properties();
            } else {
                logProps.clear();
            }
            logProps.load(new FileInputStream(logPropsFilePath));
        } catch (Exception ex) {
            System.err.println(
                    "Can't read the log properties file: " + logPropsFilePath);
            ex.printStackTrace();
            return;
        }
        loadProps();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void loadProps() {
        try {
            updateLastModified();
            Enumeration propNames = logProps.propertyNames();
            while (propNames.hasMoreElements()) {
                String line = (String) propNames.nextElement();
                if (line.endsWith(".Path")) {
                    String logConfigId = line.substring(0, line.lastIndexOf("."));
                    if (!configs.containsKey(logConfigId)) {
                        String path = logProps.getProperty(logConfigId + ".Path");
                        String property =
                                logProps.getProperty(logConfigId + ".Property");
                        FileLoggerConfig config = new FileLoggerConfig();
                        config.setPath(path);
                        config.setProperty(property);
                        configs.put(logConfigId, config);
                    } else {
                        Exception ex =
                                new Exception("Log " + logConfigId + " duplicated");
                        ex.printStackTrace();
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("loadProps");
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    private static synchronized void initLog(boolean force) {
        try {
            if ((force) || (!(force) && (fLogger == null))) {
                FileLoggerConfig config =
                        (FileLoggerConfig) configs.get(LOG_CONFIG_ID);
                try {
                    fLogger = new FileLogger(config);
                    fLogger.setPrefix("util");
                    fLogger.setSuffix(LOG_ID);
                    fLogger.setLogId(LOG_ID);
                    loggers.put(LOG_ID, fLogger);
                    fLogger.info("{ROOT}Initialized log " + LOG_ID);
                    fLogger.info("{ROOT}Checked out log " + LOG_ID);
                } catch (Exception ex) {
                    System.err.println(
                            "Error initializing FileLogger of FileLoggerManager");
                    ex.printStackTrace();
                }
            }
        } catch (Exception ex) {
            System.err.println(
                    "Final Exception Error initializing FileLogger of FileLoggerManager");
            ex.printStackTrace();
        }

    }

    private void updateLastModified() {
        File logPropsFile = new File(logPropsFilePath);
        lastModified = logPropsFile.lastModified();
    }

    private boolean isUpdated() {
        try {
            File logPropsFile = new File(logPropsFilePath);
            latestLastModified = logPropsFile.lastModified();
            if (latestLastModified != lastModified) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            if (fLogger != null) {
                fLogger.error("Error checkig log properties for update");
                fLogger.error("logPropsFilePath = " + logPropsFilePath);
                fLogger.error("", ex);
            } else {
                System.err.println("Error checkig log properties for update");
                System.err.println("logPropsFilePath = " + logPropsFilePath);
                ex.printStackTrace();
            }
            return false;
        }
    }

    private void checkLogPropsFileForUpdate() {
        try {
            if (isUpdated()) {
                fLogger.info(
                        "log.properties was updated on "
                                + DateTimeFormatter.format(new Date(latestLastModified)));
                try {
                    logProps.clear();
                    logProps.load(new FileInputStream(logPropsFilePath));
                } catch (Exception ex) {
                    fLogger.error(
                            "Can't read the log properties file: " + logPropsFilePath,
                            ex);
                    return;
                }
                configs.clear();
                showAvailableLogs();
                clearLoggers();
                loadProps();
                initLog(true);
            }

        } catch (Exception ex) {
            fLogger.error(
                    "Final Exception Can't read the log properties file: " + logPropsFilePath,ex);
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public synchronized FileLogger getLogger(String logConfigId, String logId) {
        try {
            initLog(false);
            /* Check log.properties for update */
            checkLogPropsFileForUpdate();

            if (loggers.containsKey(logId)) {
                fLogger.info("{CACHE}Checked out log " + logId);
                return (FileLogger) loggers.get(logId);
            } else {
                if (configs.containsKey(logConfigId)) {
                    try {
                        FileLoggerConfig config =
                                (FileLoggerConfig) configs.get(logConfigId);
                        FileLogger fileLogger = new FileLogger(config);
                        if (psfixCache != null) {
                            PrefixSuffix ps = (PrefixSuffix) psfixCache.get(logId);
                            if (ps != null) {
                                fileLogger.setPrefix(ps.getPrefix());
                                fileLogger.setSuffix(ps.getSuffix());
                            }
                        }
                        fileLogger.setLogId(logId);
                        loggers.put(logId, fileLogger);
                        fLogger.info("{NEW}Initialized log " + logId);
                        fLogger.info("{NEW}Checked out log " + logId);
                        return fileLogger;

                    } catch (Exception ex) {
                        if (fLogger != null) {
                            fLogger.error("Error initializing FileLogger", ex);
                        } else {
                            //System.err.println("Error initializing FileLogger");
                            ex.printStackTrace();
                        }
                        return null;
                    }
                } else {
                    System.err.println("logPropsFilePath = " + logPropsFilePath);
                    System.err.println("Log config not found: " + logConfigId);
                    fLogger.error("Log config not found: " + logConfigId);
                    return null;
                }
            }

        } catch (Exception e) {
            System.err.println("Final Exception Error initializing FileLogger");
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void clearLoggers() throws Exception {
        //Enumeration enum = loggers.keys();
        Enumeration enu = loggers.keys();
        String logId;
        if (psfixCache == null) {
            psfixCache = new Hashtable();
        } else {
            psfixCache.clear();
        }
        while (enu.hasMoreElements()) {
            logId = (String) enu.nextElement();
            FileLogger fileLogger = (FileLogger) loggers.get(logId);
            PrefixSuffix ps = new PrefixSuffix();
            ps.setPrefix(fileLogger.getPrefix());
            ps.setSuffix(fileLogger.getSuffix());
            psfixCache.put(logId, ps);
            loggers.remove(logId);
            fLogger.info("Cleared log " + logId);
        }
    }

    @SuppressWarnings("unused")
    public void clearLogger(String logId) {
        if (!loggers.containsKey(logId)) {
            fLogger.error("Log not found: " + logId);
            return;
        }
        if (loggers.containsKey(logId)) {
            FileLogger fileLogger = (FileLogger) loggers.get(logId);
            loggers.remove(logId);
            fLogger.info("Cleared log " + logId);
        }
    }

    @SuppressWarnings("rawtypes")
    public void showAvailableLogs() throws Exception {
        if (loggers.size() > 0) {
            fLogger.info("Available logs: ");
            //Enumeration enum = loggers.keys();
            Enumeration enu = loggers.keys();
            String logId;
            while (enu.hasMoreElements()) {
                logId = (String) enu.nextElement();
                fLogger.info("Log: " + logId);
            }
        } else {
            fLogger.info("No logs available");
        }
    }
}
