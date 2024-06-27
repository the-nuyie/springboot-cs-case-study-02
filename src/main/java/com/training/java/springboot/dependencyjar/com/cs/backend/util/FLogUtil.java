package com.training.java.springboot.dependencyjar.com.cs.backend.util;


import com.training.java.springboot.dependencyjar.com.cs.backend.exception.CSException;

public class FLogUtil {

    private static String log_conf ;
    private static String log_id ;
    private static String log_prefix;
    private static String log_suffix;




    /*
    public static  FileLogger initCreateLogFile() throws CSException {



        FileLogger fLogger = null;
        try{
            fLogger = FileLoggerManager.getInstance().getLogger(ReportPDFConstant.log_conf, ReportPDFConstant.log_id1);

            fLogger.setPrefix(ReportPDFConstant.log_prefix);//prefix of log
            fLogger.setSuffix(ReportPDFConstant.log_suffix);//FileName of log

            if(fLogger == null) {
                throw new CSException(CSException.INIILOG_ERR_ID, CSException.INIILOG_ERR_MSG);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new CSException(CSException.INIILOG_ERR_ID, CSException.INIILOG_ERR_MSG);
        }
        return fLogger;
    }
    */

    public static  FileLogger initCreateLogFile(String log_conf , String log_id , String log_prefix , String log_suffix) throws CSException {


        FileLogger fLogger = null;
        try{
            fLogger = FileLoggerManager.getInstance().getLogger(log_conf, log_id);
            fLogger.setPrefix(log_prefix);
            fLogger.setSuffix(log_suffix);


            if(fLogger == null) {
                throw new CSException(CSException.INIILOG_ERR_ID, CSException.INIILOG_ERR_MSG);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new CSException(CSException.INIILOG_ERR_ID, CSException.INIILOG_ERR_MSG);
        }
        return fLogger;
    }

}
