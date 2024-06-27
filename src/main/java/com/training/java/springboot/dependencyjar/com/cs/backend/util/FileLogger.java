package com.training.java.springboot.dependencyjar.com.cs.backend.util;


import com.training.java.springboot.dependencyjar.cs.gateway.util.StringUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FileLogger {
    /* Message Levels */
    private static final String MLV_INFO = "[INFO]";
    private static final String MLV_DEBUG = "[DEBUG]";
    private static final String MLV_WARN = "[WARN]";
    private static final String MLV_ERROR = "[ERROR]";
    private static final String MLV_FATAL = "[FATAL]";
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final String NEW_LINE = System.getProperty("line.separator");
//	@SuppressWarnings("unused")
//	private static final String JOB_NAME_AUTOFIX="AutoFixTxJob";
//	public static final SimpleDateFormat DateFormatter =
//		new SimpleDateFormat("yyyy_MM_dd", Locale.US);

    public static final SimpleDateFormat DateFormatter =
            new SimpleDateFormat("ddMMyyyy", Locale.US);
    private static final SimpleDateFormat DateTimeFormatter =
            new SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.US);
    private static final SimpleDateFormat TimeFormatter =
            new SimpleDateFormat("HHmmss", Locale.US);
    private static final SimpleDateFormat HourFormatter =
            new SimpleDateFormat("HH", Locale.US);

    private String logId;
    private String logPath = "";
    private String prefix = "";
    private String suffix = "";
    private String logFileFullPath = "";
    private long singleConfigSize = -1;
    private boolean chkCondition = false;
    private String programVersion = "";
    private String ciVersion = "";
    private String lastModifyDate = "";
    private String lastmodifyBy = "";

    public FileLogger(FileLoggerConfig config) throws Exception {
        init(config);
    }

    /**
     * @param configID	id used to identify log property
     * @throws IOException
     */
    private void init(FileLoggerConfig config) throws IOException {

        logPath = config.getPath().trim();
        if (!config.getPath().endsWith(FILE_SEP)) {
            logPath = logPath + FILE_SEP;
        }

    }

    private void checkDir(String dirName) {
        String strPathName = "";
        strPathName = (logPath.indexOf(dirName) > 0)? logPath : logPath + dirName;

        File file = new File(strPathName);

        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public  void setSingleConfigSize(String strConfig){
        String singleConfig = SingleConfig.getInstance().getConfig(strConfig);
        if(singleConfig != null && singleConfig.length() >  0 ){
            singleConfigSize = Integer.parseInt(singleConfig)*1024*1024;
        }
    }

    private void log(String msgLevel, String msg, Throwable thrw) {
        String logDirPreDate = getDirNamePreviousDate();
        String logDirDate = getDirNameDate();
        String logDirTime = getDirNameTime();

//		logDirDate = (compareCurrentDirNameDate(logDirPreDate, logDirDate)? logDirDate: logDirPreDate);
//		logPath = "C://Program Files//IBM//SDP//logs//06052014//11//online//";
//		System.out.println("online logPath bf replace : "+logPath);

        logPath = logPath.replace("$date", logDirDate);
        logPath = logPath.replace("$hour", logDirTime);

//		System.out.println("online logPath af replace : "+logPath);

//		System.out.println("online bf chk logDirDate");
//		System.out.println("online logDirPreDate: "+logDirPreDate);
//		System.out.println("online logDirDate: "+logDirDate);

        logPath = logPath.replace("//", FILE_SEP); // for test on local ex C://Program Files//IBM//SDP//logs//05052014//19//online//

        if((logPath.indexOf(logDirPreDate) > 0)) {
//			System.out.println("online blChkDir bf replace : "+logPath);
            String strHour = logPath.substring(logPath.indexOf(logDirPreDate)+8, logPath.indexOf(logDirPreDate)+11);

            logPath = logPath.replace(logDirPreDate+strHour, logDirDate+FILE_SEP+logDirTime);
//			System.out.println("online blChkDir af replace : "+logPath);
        } else {

            if(logPath.indexOf(logDirDate) > 0) {
                String strHour = logPath.substring(logPath.indexOf(logDirDate)+8, logPath.indexOf(logDirDate)+11);
                logPath = logPath.replace(strHour, FILE_SEP+logDirTime);
            }else {

//				if(logPath.indexOf(logDirDate) > 0) {
//					String strHour = logPath.substring(logPath.indexOf(logDirDate)+8, logPath.indexOf(logDirDate)+11);
//					logPath = logPath.replace(strHour, FILE_SEP+logDirTime);
//					//System.out.println("else logDirDate>0: "+logPath);
//				}else{
                if(logPath.indexOf(logDirDate.substring(4))>0){
                    String strDate = logPath.substring((logPath.indexOf(logDirDate.substring(4))-4),(logPath.indexOf(logDirDate.substring(4))+4));
                    //	System.out.println("strDate "+strDate);
                    logPath = logPath.replace(strDate, logDirDate);
                    //	System.out.println("logPath "+logPath);


                    //	System.out.println("####" + logDirDate );
                    String strHour = logPath.substring(logPath.indexOf(logDirDate)+8, logPath.indexOf(logDirDate)+11);
                    //System.out.println("String Hour :"+strHour);
                    logPath = logPath.replace(strHour, FILE_SEP+logDirTime);
                    //	System.out.println("replace Time :"+logPath);
                    //}
                }

            }
        }

//		System.out.println("online bf chk logDirDate  : "+logDirDate);

        checkDir(logDirDate);

        logFileFullPath = (logPath.indexOf(logDirDate) > 0) ? logPath + getFileName(logDirDate) : logPath + logDirDate + FILE_SEP + getFileName(logDirDate);

        PrintWriter pw = null;
        if(!chkCondition){
            //old version
            try {
                if(singleConfigSize != -1){
                    long size = new File(getCurrentLogFilePath()).length();
                    if(size >= singleConfigSize){
                        renameFile();
                    }
                }

                pw = new PrintWriter(new FileWriter(logFileFullPath, true), true);
                StringBuffer strBuf =
                        new StringBuffer(DateTimeFormatter.format(new Date()));
                strBuf.append(msgLevel);
                strBuf.append("[version:"+programVersion+"]");
                strBuf.append("[CI:"+ciVersion+"]");
                strBuf.append("[LastModifyDate:"+lastModifyDate+"]");
                strBuf.append("::");
                strBuf.append(msg);
                strBuf.append(NEW_LINE);
                pw.print(strBuf.toString());
                if (thrw != null) {
                    thrw.printStackTrace(pw);
                }
            } catch (Exception ex) {
                System.err.println("Error while logging");
                ex.printStackTrace();
            } finally {
                if (pw != null) {
                    pw.close();
                }
            }
        } else {
            //New Version Check BLOCKED_WRITE_LOGS in Single  Config file
            try {
                if(singleConfigSize != -1){
                    long size = new File(getCurrentLogFilePath()).length();
                    if(size >= singleConfigSize){
                        renameFile();
                    }
                }
                boolean blockedLog = false;
                String strBlockedLogs = SingleConfig.getInstance().getConfig("BLOCKED_WRITE_LOGS");
                String[] blockedLogsArry = StringUtil.getStrArray(strBlockedLogs.trim(), "|");

                if(blockedLogsArry != null && logId != null){
                    for (int i = 0; i < blockedLogsArry.length; i++) {
                        String blockedVendor = blockedLogsArry[i];
                        if (blockedVendor
                                .trim()
                                .equals(logId)) {
                            blockedLog = true;
                            break;
                        }
                    }
                }
                if(!blockedLog){
                    //Write Log File
                    pw = new PrintWriter(new FileWriter(logFileFullPath, true), true);
                    StringBuffer strBuf =
                            new StringBuffer(DateTimeFormatter.format(new Date()));
                    strBuf.append(msgLevel);
                    strBuf.append("[version:"+programVersion+"]");
                    strBuf.append("[CI:"+ciVersion+"]");

                    //strBuf.append("[LastModifyBy:"+lastmodifyBy+"]");
                    strBuf.append("[LastModifyDate:"+lastModifyDate+"]");
                    strBuf.append("::");
                    strBuf.append(msg);
                    strBuf.append(NEW_LINE);
                    pw.print(strBuf.toString());
                    if (thrw != null) {
                        thrw.printStackTrace(pw);
                    }
                }
            } catch (Exception ex) {
                //System.err.println("Error while logging");
                ex.printStackTrace();
            } finally {
                if (pw != null) {
                    pw.close();
                }
            }
        }
    }

//	private void logFlag(String msgLevel, String msg, Throwable thrw) {
//		String logDir = getDirName();
//		checkDir(logDir);
//		logFileFullPath = logPath + logDir + FILE_SEP + getFileName(logDir);
//		PrintWriter pw = null;
//
//	}

    @SuppressWarnings("unused")
    private void logFlag(String msgLevel, String msg, Throwable thrw) {
        String logDir = getDirName();
        checkDir(logDir);
        logFileFullPath = logPath + logDir + FILE_SEP + getFileName(logDir);
        PrintWriter pw = null;

    }

    public void renameFile(){
        File oldFile = new File(getCurrentLogFilePath());
        oldFile.renameTo(new File(getCurrentLogFilePath()+"_"+TimeFormatter.format(new Date())));
    }

//	public String getCurrentLogFilePath() {
//		String logDir="";
//		logDir = getDirNameDate();
//		checkDir(logDir);
//		return logPath + logDir + FILE_SEP + getFileName(logDir);
//	}

    public String getCurrentLogFilePath() {
        String logDir="";
        logDir = getDirNameDate();
        checkDir(logDir);
        //		System.out.println("online getCurrentLogFilePath");
        //		System.out.println("logDir: "+logDir);
        String strLogPath = (logPath.indexOf(logDir) > 0)? logPath : logPath + logDir + FILE_SEP;

        //		System.out.println("logDir: "+strLogPath+getFileName(logDir));

        return strLogPath + getFileName(logDir);
    }

    private boolean checkDebugMode() {
        boolean blockedLog = false;
        String strBlockedLogs = SingleConfig.getInstance().getConfig("WRITE_DEBUG_LOGS");

        if(strBlockedLogs.equalsIgnoreCase("Y")){
            blockedLog = true;

        } else {
            blockedLog = false;
        }

        return blockedLog ;
    }

    public void debug(String msg) {
        if(checkDebugMode()){
            log(MLV_DEBUG, msg, null);
        }
    }

    public void debug(String msg, Throwable thrw) {
        if(checkDebugMode()){
            log(MLV_DEBUG, msg, thrw);
        }
    }

    public void info(String msg) {
        log(MLV_INFO, msg, null);
    }

    public void info(String msg, Throwable thrw) {
        log(MLV_INFO, msg, thrw);
    }
    public void warn(String msg) {
        log(MLV_WARN, msg, null);
    }

    public void warn(String msg, Throwable thrw) {
        log(MLV_WARN, msg, thrw);
    }

    public void error(String msg) {
        log(MLV_ERROR, msg, null);
    }

    public void error(String msg, Throwable thrw) {
        log(MLV_ERROR, msg, thrw);
    }

    public void fatal(String msg) {
        log(MLV_FATAL, msg, null);
    }

    public void fatal(String msg, Throwable thrw) {
        log(MLV_FATAL, msg, thrw);
    }

//	private String getDirName() {
//		return DateFormatter.format(new Date());
//	}

    private String getDirNamePreviousDate() {
        Calendar cal = null;
        cal = Calendar.getInstance(Locale.US);
        cal.setTime(new Date());

        cal.add(Calendar.DATE, -1);

        return DateFormatter.format(cal.getTime());

    }

    private String getDirName() {
        return DateFormatter.format(new Date());
    }

    private String getDirNameDate() {
        return DateFormatter.format(new Date());
    }

    private String getDirNameTime() {
        return HourFormatter.format(new Date());
    }

    private String getFileName(String logDir) {
        return prefix + "." + logDir + "." + suffix + ".log";
    }
    /**
     * @param string
     */
    public void setPrefix(String string) {
        try {
            String serverName = ServerUtils.getServerName();
            prefix = serverName+"."+string;
        } catch (Exception e) {
            prefix = string;
        }
    }

    /**
     * @param string
     */
    public void setSuffix(String string) {
        suffix = string;
    }

    /**
     * @return
     */
    public String getLogFileFullPath() {
        return logFileFullPath;
    }

    /**
     * @return
     */
    public String getLogPath() {
        return logPath;
    }

    /**
     * @return
     */
    public String getLogId() {
        return logId;
    }

    /**
     * @return
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * @param string
     */
    public void setLogId(String string) {
        logId = string;
    }

    /**
     * @return
     */
    public String getSuffix() {
        return suffix;
    }


    /**
     * @return
     */
    public boolean isChkCondition() {
        return chkCondition;
    }

    /**
     * @param b
     */
    public void setChkCondition(boolean b) {
        chkCondition = b;
    }

    /**
     * @return
     */
    public String getCiVersion() {
        return ciVersion;
    }

    /**
     * @return
     */
    public String getLastModifyDate() {
        return lastModifyDate;
    }

    /**
     * @return
     */
    public String getProgramVersion() {
        return programVersion;
    }

    /**
     * @param string
     */
    public void setCiVersion(String string) {
        ciVersion = string;
    }

    /**
     * @param string
     */
    public void setLastModifyDate(String string) {
        lastModifyDate = string;
    }

    /**
     * @param string
     */
    public void setProgramVersion(String string) {
        programVersion = string;
    }

    /**
     * @return
     */
    public String getLastmodifyBy() {
        return lastmodifyBy;
    }

    /**
     * @param string
     */
    public void setLastmodifyBy(String string) {
        lastmodifyBy = string;
    }

}
