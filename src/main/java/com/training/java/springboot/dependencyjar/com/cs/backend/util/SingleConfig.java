package com.training.java.springboot.dependencyjar.com.cs.backend.util;


import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Properties;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SingleConfig {
    private static final String LOG_CONFIG_ID = "SingleConfig";
    private static final String LOG_ID = "SingleConfig";

    /* Formatters */
    private static final SimpleDateFormat DateTimeFormatter =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    private static SingleConfig instance = null;
    private FileLogger fLogger = null;
    private Properties singleProps = null;
    private Hashtable <String, Object> configs = new Hashtable <String, Object> ();
    public static boolean ManualLoadConfig = false;

    /* For use in checking single.properties file update */
    private String singlePropsFilePath;
    private long lastModified;
    private long latestLastModified;

    private SingleConfig() {
        init();
        if (!ManualLoadConfig) {
            singlePropsFilePath =
                    ConfigurationManager.getInstance().getProperty(
                            "single.propertie.file");
            loadConfig();
        }
    }

    public static SingleConfig getInstance() {
        if (instance == null) {
            instance = new SingleConfig();
        }
        return instance;
    }

    private void init() {
        fLogger =
                FileLoggerManager.getInstance().getLogger(LOG_CONFIG_ID, LOG_ID);
        fLogger.setPrefix("util");
        fLogger.setSuffix(LOG_ID);
        fLogger.setLogId(LOG_ID);
    }

    public synchronized void loadConfigFromFile(String filePath) {
        singlePropsFilePath = filePath;
        loadConfig();
    }

    private void loadConfig() {
        try {
            if (singleProps == null) {
                singleProps = new Properties();
            } else {
                singleProps.clear();
            }
            singleProps.load(new FileInputStream(singlePropsFilePath));
        } catch (Exception ex) {
            fLogger.error(
                    "Can't read the single properties file: " + singlePropsFilePath,
                    ex);
            return;
        }
        loadProps();
    }

    @SuppressWarnings("rawtypes")
    private void loadProps() {
        updateLastModified();
        Enumeration propNames = singleProps.propertyNames();
        while (propNames.hasMoreElements()) {
            String config = (String) propNames.nextElement();
            if (!configs.containsKey(config)) {
                configs.put(config, singleProps.getProperty(config));
            } else {
                fLogger.error("Config " + config + " duplicated");
            }
        }
    }

    private void updateLastModified() {
        File singlePropsFile = new File(singlePropsFilePath);
        lastModified = singlePropsFile.lastModified();
    }

    private boolean isUpdated() {
        File singlePropsFile = new File(singlePropsFilePath);
        latestLastModified = singlePropsFile.lastModified();
        if (latestLastModified != lastModified) {
            return true;
        } else {
            return false;
        }
    }

    private void checkSinglePropsFileForUpdate() {
        if (isUpdated()) {
            //fLogger.info(
            //	"single.properties was updated on "
            //		+ DateTimeFormatter.format(new Date(latestLastModified)));
            try {
                singleProps.clear();
                singleProps.load(new FileInputStream(singlePropsFilePath));
            } catch (Exception ex) {
                fLogger.error(
                        "Can't read the single properties file: "
                                + singlePropsFilePath,
                        ex);
                return;
            }
            configs.clear();
            loadProps();
            //fLogger.info("Reloaded single properties");
        }
    }

    public String getConfig(String config) {
        /* Check single.properties for update */
        checkSinglePropsFileForUpdate();

        if (configs.containsKey(config)) {
            return (String) configs.get(config);
        } else {
            return "";
        }
    }
}