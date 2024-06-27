package com.training.java.springboot.dependencyjar.cs.gateway.util;


import com.training.java.springboot.dependencyjar.cs.gateway.util.common.Const;
import org.apache.log4j.*;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LogUtil {
	//private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy", Locale.US);
	private String logPath = null;
	private String prefix = null;
	private String logname = null;
	private String subFolder = null;
	private Appender newAppender = null;
	private Logger logger = null;	
	private String FILE_SEP = System.getProperty("file.separator");
	private String FILE_SIZE = "2MB";
	private int BACKUP_FILE = 5;
	private Level logLevel = Level.INFO;
	private String lvl = null;
	
	public LogUtil(String subFolder, String prefix, String logName){
		setLogLevel(subFolder, logName);
		this.FILE_SIZE = PropConfig.getProperty("LOGAPP.FILESIZE");
		this.BACKUP_FILE = Integer.parseInt(PropConfig.getProperty("LOGAPP.BACKUPFILE"));
		String logPath = PropConfig.getProperty("LOGAPP.PATH");
		if(logName!=null && logName.lastIndexOf(".")>=0){
			logName = logName.substring(logName.lastIndexOf(".")+1);
		}		
		if(prefix==null){
			prefix = "";
		}		
		this.logPath = logPath;
		this.prefix = prefix;
		this.logname = logName;
		this.subFolder = subFolder;
		//PropertyConfigurator.configure(logConfig);
	}
	
	public Logger getLogger(){	
		try {
			if(this.prefix.indexOf(".")<0 && !this.prefix.equals("")){
				this.prefix = this.prefix + ".";
			}
//			if(this.subFolder.indexOf("\\")<0 && !this.subFolder.equals("")){
//				this.subFolder = this.subFolder + "\\";
//			}
			
			logger = Logger.getLogger(this.prefix + this.logname); 			
			Layout pattern = new PatternLayout("%d %5p (%F:%L) - %m%n");
			//String logFile = this.logPath +FILE_SEP+ dateFormat.format(new Date()) + FILE_SEP+ this.subFolder + this.prefix + this.logname + ".log";
			
			this.logPath  = this.logPath.trim();
			if (!this.logPath.endsWith(FILE_SEP)) {
				logPath = logPath + FILE_SEP;
			}
			
			checkDir(this.logPath + FILE_SEP + dateFormat.format(new Date()) );
			checkDir(this.logPath + FILE_SEP + dateFormat.format(new Date())+FILE_SEP + this.subFolder );
			
			
			String logFileFullPath = this.logPath + FILE_SEP + dateFormat.format(new Date())+FILE_SEP + this.subFolder+FILE_SEP + getFileName();
			
			if(!lvl.equalsIgnoreCase("OFF")){
				newAppender = new RollingFileAppender(pattern, logFileFullPath, true);
				newAppender.setName(this.subFolder);
				((RollingFileAppender) newAppender).setMaxFileSize(this.FILE_SIZE);
				((RollingFileAppender) newAppender).setMaxBackupIndex(this.BACKUP_FILE);
				//((RollingFileAppender) newAppender).setEncoding("UTF-8");
				
				logger.setAdditivity(false);
				//logger.setLevel(Level.DEBUG);
				logger.setLevel(logLevel);
				logger.addAppender(newAppender); 
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return logger;
	}
	
	public void closeLogger(Logger logger){
		if(logger!=null) {
			logger.removeAllAppenders();
			logger=null;
			logLevel = null;
		}
		if(newAppender!=null){
			newAppender.close();
			newAppender = null;
		}
	}
	
	private void checkDir(String dirName) {
		File file = new File( dirName);
		if (!file.exists()) {
			file.mkdirs();
		}
	}
	
	private String getFileName() {
		return this.prefix + this.logname + ".log";
	}
	
	private void setLogLevel(String subFolder, String logName){
		
		if(subFolder.equals(Const.IMPORT_CSPAYGW_FOLDER_NAME)){
			lvl = PropConfig.getProperty("LOG_GET_CSPAYGW.LEVEL");	
		} else if(subFolder.equals(Const.LOG_TEXT_PAYMENT)){
			lvl = PropConfig.getProperty("LOG_GET_CSPAYGW.LEVEL");	
		} else if(subFolder.equals(Const.SCHEDULE_FOLDER_NAME)){
			if(logName!=null && !logName.equals("")){
				lvl = PropConfig.getProperty("LOG_"+logName.toUpperCase()+".LEVEL");
			} else {
				lvl = PropConfig.getProperty("LOGAPP.LEVEL");
			}
		} else if(subFolder.equals(Const.IMPORT_CSPAYGW_F1MOBILE_FOLDER_NAME)){
			lvl = PropConfig.getProperty("LOG_GET_CSPAYGW.LEVEL");	
		}
		
		if(subFolder==null || subFolder.equals("")) {
			lvl = PropConfig.getProperty("LOGAPP.LEVEL");	
		}
		
		if(lvl==null){
			lvl = "INFO";
			logLevel = Level.INFO;
		} else if(lvl.equalsIgnoreCase("info")) {
			logLevel = Level.INFO;
		} else if(lvl.equalsIgnoreCase("debug")) {
			logLevel = Level.DEBUG;
		} else if(lvl.equalsIgnoreCase("error")) {
			logLevel = Level.ERROR;
		} else if(lvl.equalsIgnoreCase("fatal")) {
			logLevel = Level.FATAL;
		} else if(lvl.equalsIgnoreCase("off")) {
			logLevel = Level.OFF;
		} else if(lvl.equalsIgnoreCase("all")) {
			logLevel = Level.ALL;
		} else {
			logLevel = Level.INFO;
		}
	}
	
	public static String printStackTrace(Exception ex){
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		return "\n"+sw.toString() ;
	}
}
