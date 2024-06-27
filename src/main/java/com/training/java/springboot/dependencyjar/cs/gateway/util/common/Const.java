package com.training.java.springboot.dependencyjar.cs.gateway.util.common;

public class Const {

    public static final String FWD_ERROR = "error";
    public static final String FWD_SUCCESS = "success";
    public static final String FWD_FAIL = "fail";

    public static final String SUCCESS = "true";
    public static final String FAILED = "false";
    public static final String SUCCESS_CODE = "100";
    public static final String ERROR_CODE = "999";
    public static final String SUCCESS_DESCRIPTION = "success";
    public static final String FAILED_DESCRIPTION = "failed";

    /* STATUS */
    public static final String STATUS_YES = "Y";
    public static final String STATUS_NO = "N";

    public static final String STATUS_TRUE = "T";
    public static final String STATUS_FALSE = "F";

    public static final String ACTION_TYPE_REQUEST = "Request";
    public static final String ACTION_TYPE_RESPONSE = "Response";

    /* DATA SOURCE */
    public static final String DATASOURCE_NAME = "PAYGWHISTDB";
    public static final String DATASOURCE_NAME_PAYGWDB = "PAYGWPRDDS";
    public static final String DATASOURCE_NAME_PAYHISTDB = "PAYGWHISDS";
    public static final String DATASOURCE_NAME_PAYRPTDB = "PAYGWRPTDS";
    public static final String BILLING_DB = "BILLINGDB_SERVER";


    public static final String SCHEMA_NAME_PAYHISTDB = "PAYGW.";
    public static final String DB_SCHEMA_HISTPRD = "CS_HIST.";



    public static final String UTIL_SUB_FOLDER_NAME = "Common";
    //public static final String UTIL_HQ_SUB_FOLDER_NAME = "HQCommon";



    public static final String ENCODE_GETBYTE = "ISO8859-1";
    public static final String ENCODE = "TIS-620";
    public static final String ENCODE_UTF_8 = "UTF-8";
    public static final String ENCODE_WIN_874 = "windows-874";
    public static final String ENCODE_ISO = "ISO-8859-1";



    public static final String CATEGORY_01 = "CATE001";


    public static final String SCHEDULE_FOLDER_NAME = "schedule";
    public static final String IMPORT_CSPAYGW_FOLDER_NAME = "importcspay";
    public static final String LOG_TEXT_PAYMENT = "textPayment";

    public static final String IMPORT_CSPAYGWMDR_FOLDER_NAME = "importcspaymdr";
    public static final String IMPORT_CSPAYGW_F1MOBILE_FOLDER_NAME = "importf1mobile";

    final static public String LOG_ID = "JOBPROCESS.PATH";
    public static final String LOG_PAYATORDERONLINE = "importpayatorder";
    public static final String LOG_POINTPARTNER = "importpointqrpayment";

    public static final String backendgateway_JOB01_NEXTTIME = "1440";
    public static final String backendgateway_JOB02_NEXTTIME = "1440";
    public static final String backendgateway_JOB03_NEXTTIME = "1440";

    //Set name import crd by payment channel
    public static final String CRD_HEADER_PREFIX_MOBILE = "CRD_HEADER_PREFIX_MOBILE";
    public static final String CRD_HEADER_DESC_MOBILE = "CRD_HEADER_DESC_MOBILE";
    public static final String CRD_DETAIL_PREFIX_MOBILE = "CRD_DETAIL_PREFIX_MOBILE";
    public static final String CRD_DETAIL_DESC_MOBILE = "CRD_DETAIL_DESC_MOBILE";
    public static final String CRD_FILE_NAME_ADDDAYS_MOBILE = "CRD_FILE_NAME_ADDDAYS_MOBILE";
    public static final String CRD_FILE_NAME_FORMAT_MOBILE = "CRD_FILE_NAME_FORMAT_MOBILE";
    public static final String CRD_PATH_BACKUP_FILE_MOBILE = "CRD_PATH_BACKUP_FILE_MOBILE";
    public static final String CRD_PATH_IMPORT_FILE_MOBILE = "CRD_PATH_IMPORT_FILE_MOBILE";
    public static final String CRD_PAYMENT_CHANNEL_MOBILE = "CRD_PAYMENT_CHANNEL_MOBILE";
    public static final String CRD_MOBILE_RUNTIME = "CRD_MOBILE_RUNTIME";
    public static final String CRD_MOBILE_LASTRUN = "CRD_MOBILE_LASTRUN";;
    public static final String CRD_MOBILE_RECONCILE_WS = "CRD_MOBILE_RECONCILE_WS";
    public static final String CRD_MOBILE_TIMEOUT_REECONCILE_WS = "CRD_MOBILE_TIMEOUT_REECONCILE_WS";
    public static final String CRD_MOBILE_CATE = "CATE028";
    public static final String CRD_INTER = "INTER_DATA_PREFIX";

    public static final String STA_FILE_NAME_FORMAT_MOBILE = "STA_FILE_NAME_FORMAT_MOBILE";
    public static final String STA_PATH_BACKUP_FILE_MOBILE = "STA_PATH_BACKUP_FILE_MOBILE";
    public static final String STA_PATH_IMPORT_FILE_MOBILE = "STA_PATH_IMPORT_FILE_MOBILE";
    public static final String STA_PAYMENT_CHANNEL_MOBILE = "STA_PAYMENT_CHANNEL_MOBILE";
    public static final String STA_MAIL_GROUP_MOBILE = "STA_MAIL_GROUP_MOBILE";
    public static final String STA_EXCEPTION_MOBILE = "STA_EXCEPTION_MOBILE";
    public static final String STA_MOBILE_RUNTIME = "STA_MOBILE_RUNTIME";
    public static final String STA_MOBILE_LASTRUN = "STA_MOBILE_LASTRUN";;
    public static final String STA_MOBILE_CATE = "CATE029";
    public static final String STA_PAY_TYPE_7CA = "7CA";
    public static final String STA_PAY_TYPE_GSW = "GSW";

    public static final String JOB_IS_PROCESS = "P";
    public static final String JOB_IS_SUCCESS = "Y";

    public static final String PAYMENT_TYPE_PAYONLINE = "payonline";
    public static final String PAYMENT_CHANNEL = "7eleven";

    public static final String PAYMENT_TYPE_PPN = "pointpay";

}
