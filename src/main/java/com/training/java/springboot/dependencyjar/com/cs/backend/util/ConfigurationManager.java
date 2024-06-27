package com.training.java.springboot.dependencyjar.com.cs.backend.util;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ConfigurationManager {
    //Constant
    public static final String PATH_SEP = System.getProperty("file.separator");
    private static final String DEFAULTPROPS_FILENAME = "reportpdf.properties";
    //	private static final String DEFAULTPROPS_FILENAME = "loadtestcsonline.properties";
    private static final String DEFAULT_LOG_DIR = "logs";
    private static final String DEFAULT_CONFIG_DIR = "reportpdf";
    private static final String DEFAULT_PATH = "/wasapp/config";
    private static final String DEFAULT_PATH_LOCAL = "C:\\Program Files\\IBM\\SDP\\config";
    private static ConfigurationManager instance = null;
    private static String ConfigDir = null;
    private Properties props = null;

    private ConfigurationManager() {
        if (ConfigDir == null) {
            //ConfigDir = System.getProperty("user.dir");
            ConfigDir = DEFAULT_PATH;
        }
        loadPros();
    }

    static synchronized public ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    private void loadPros() {
        try {
            props = new Properties();
            props.load(
                    new FileInputStream(
                            ConfigDir
                                    + ConfigurationManager.PATH_SEP
                                    + DEFAULT_CONFIG_DIR
                                    + ConfigurationManager.PATH_SEP
                                    + ConfigurationManager.DEFAULTPROPS_FILENAME));
        } catch (Exception ex) {
            System.err.println("Error initializing ConfigurationManager Process Try Again");
            try {
                ConfigDir = DEFAULT_PATH_LOCAL;
                props = new Properties();
                props.load(
                        new FileInputStream(
                                ConfigDir
                                        + ConfigurationManager.PATH_SEP
                                        + DEFAULT_CONFIG_DIR
                                        + ConfigurationManager.PATH_SEP
                                        + ConfigurationManager.DEFAULTPROPS_FILENAME));

            } catch (Exception ex2) {
                System.err.println("Error initializing ConfigurationManager");
                ex2.printStackTrace();
            }

        }
    }

    public String getProperty(String key) {
        return this.props.getProperty(key);
    }

    /**
     * @param string
     */
    public static void setConfigDir(String string) {
        ConfigDir = string;
    }

    public String getDefaultLogDir() {
        String defaultLogDir =
                ConfigDir
                        + ConfigurationManager.PATH_SEP
                        + ConfigurationManager.DEFAULT_LOG_DIR;

        File file = new File(defaultLogDir);
        if (!file.exists()) {
            file.mkdir();
        }
        return file.getAbsolutePath();
    }
}