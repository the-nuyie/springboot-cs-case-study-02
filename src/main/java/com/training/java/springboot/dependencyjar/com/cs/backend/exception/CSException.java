package com.training.java.springboot.dependencyjar.com.cs.backend.exception;


/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CSException extends Exception {

    public static final String OFFLINE_SYSTEM_TYPE_ID = "103";
    public static final String OFFLINE_SYSTEM_TYPE_ERR_MSG = "OfflineSystemTypeException";

    public static final String GENLOGID_ERR_ID = "110";
    public static final String GENLOGID_ERR_MSG = "GenLogIdException";

    public static final String INFADDRESSNOTFOUND_ERR_ID = "111";
    public static final String INFADDRESSNOTFOUND_ERR_MSG =
            "InterfaceAddressNotFoundException";

    public static final String CONTENTNOTFOUND_ERR_ID = "112";
    public static final String CONTENTNOTFOUND_ERR_MSG =
            "ContentNotFoundException";

    public static final String PARSINGINPUT_ERR_ID = "113";
    public static final String PARSINGINPUT_ERR_MSG = "ParsingInputException";

    public static final String LOOKUPSERVICE_ERR_ID = "114";
    public static final String LOOKUPSERVICE_ERR_MSG = "LookupServiceException";

    public static final String DATABASEOPR_ERR_ID = "115";
    public static final String DATABASEOPR_ERR_MSG =
            "DatabaseOperationException";

    public static final String CALLSERVICE_ERR_ID = "116";
    public static final String CALLSERVICE_ERR_MSG = "CallServiceException";

    public static final String INSERTLOG_ERR_ID = "117";
    public static final String INSERTLOG_ERR_MSG = "InsertLogException";

    public static final String UPDATELOG_ERR_ID = "118";
    public static final String UPDATELOG_ERR_MSG = "UpdateLogException";

    public static final String INSERTTRX_ERR_ID = "119";
    public static final String INSERTTRX_ERR_MSG = "InsertTransactionException";

    public static final String UPDATETRX_ERR_ID = "120";
    public static final String UPDATETRX_ERR_MSG = "UpdateTransactionException";

    public static final String INVALIDTRXSTATE_ERR_ID = "121";
    public static final String INVALIDTRXSTATE_ERR_MSG =
            "InvalidTransactionStateException";

    public static final String DATABASECONN_ERR_ID = "122";
    public static final String DATABASECONN_ERR_MSG =
            "DatabaseConnectionException";

    public static final String STRINGLENGTH_ERR_ID = "123";
    public static final String STRINGLENGTH_ERR_MSG = "StringLengthException";

    public static final String MINAMOUNT_ERR_ID = "124";
    public static final String MINAMOUNT_ERR_MSG = "MinAmountException";

    public static final String MAXAMOUNT_ERR_ID = "125";
    public static final String MAXAMOUNT_ERR_MSG = "MaxAmountException";

    public static final String CALLCHKDIGITSERVICE_ERR_ID = "126";
    public static final String CALLCHKDIGITSERVICE_ERR_MSG =
            "CallCheckDigitServiceException";

    public static final String PARSINGINPUTCHKDIGITRET_ERR_ID = "127";
    public static final String PARSINGINPUTCHKDIGITRET_ERR_MSG =
            "ParsingCheckDigitReturnException";

    public static final String SEQNOFORMAT_ERR_ID = "128";
    public static final String SEQNOFORMAT_ERR_MSG =
            "SequenceNoFormatException";

    public static final String INPUTAMOUNTFORMAT_ERR_ID = "129";
    public static final String INPUTAMOUNTFORMAT_ERR_MSG =
            "InputAmountFormatException";

    public static final String BUILDCHKDIGITCONF_ERR_ID = "130";
    public static final String BUILDCHKDIGITCONF_ERR_MSG =
            "BuildChkDigitConfException";

    public static final String DUPREF_ERR_ID = "131";
    public static final String DUPREF_ERR_MSG = "DuplicateReferenceException";

    public static final String DUPCOMPLETEREF_ERR_ID = "311";
    public static final String DUPCOMPLETEREF_ERR_MSG = "DuplicateCompleteReferenceException";

    public static final String PREFIXREF_ERR_ID = "132";
    public static final String PREFIXREF_ERR_MSG = "PrefixReferenceException";

    public static final String DUPTRX_ERR_ID = "133";
    public static final String DUPTRX_ERR_MSG = "DuplicateTransactionException";

    public static final String DUPLIMITTRX_ERR_ID = "253";
    public static final String DUPLIMITTRX_ERR_MSG = "DuplicateLimitReferenceException";

    public static final String REPEATOR_ERR_ID = "134";
    public static final String REPEATOR_ERR_MSG = "RepeatOrException";

    public static final String ORTIMEOUT_ERR_ID = "135";
    public static final String ORTIMEOUT_ERR_MSG = "OrTimeoutException";

    public static final String OREXECUTED_ERR_ID = "136";
    public static final String OREXECUTED_ERR_MSG = "OrExecutedException";

    public static final String ORNOTFOUND_ERR_ID = "137";
    public static final String ORNOTFOUND_ERR_MSG = "OrNotFoundException";

    public static final String VENDORCHKDIGIT_ERR_ID = "138";
    public static final String VENDORCHKDIGIT_ERR_MSG =
            "VendorCheckDigitException";

    public static final String VENDORCALLSRV_ERR_ID = "139";
    public static final String VENDORCALLSRV_ERR_MSG =
            "VendorCallServiceException";

    public static final String LOOKUPCONFIRMSRV_ERR_ID = "140";
    public static final String LOOKUPCONFIRMSRV_ERR_MSG =
            "LookupConfirmServiceException";

    public static final String CALLCONFIRMSRV_ERR_ID = "141";
    public static final String CALLCONFIRMSRV_ERR_MSG =
            "CallConfirmServiceException";

    public static final String PARSINGCONFIRM_ERR_ID = "142";
    public static final String PARSINGCONFIRM_ERR_MSG =
            "ParsingConfirmReturnException";

    public static final String LOOKUPORCONFIRMSRV_ERR_ID = "143";
    public static final String LOOKUPORCONFIRMSRV_ERR_MSG =
            "LookupOrConfirmServiceException";

    public static final String CALLORCONFIRMSRV_ERR_ID = "144";
    public static final String CALLORCONFIRMSRV_ERR_MSG =
            "CallOrConfirmServiceException";

    public static final String PARSINGORCONFIRM_ERR_ID = "145";
    public static final String PARSINGORCONFIRM_ERR_MSG =
            "ParsingOrConfirmReturnException";

    public static final String NULLUSER_ERR_ID = "146";
    public static final String NULLUSER_ERR_MSG = "NullUserIdException";

    public static final String TRXNOTFOUND_ERR_ID = "147";
    public static final String TRXNOTFOUND_ERR_MSG =
            "TransactionNotFoundException";

    public static final String GENREFMAP_ERR_ID = "148";
    public static final String GENREFMAP_ERR_MSG = "GenRefMapException";

    public static final String FLDNOTFOUND_ERR_ID = "149";
    public static final String FLDNOTFOUND_ERR_MSG = "FieldNotFoundException";

    public static final String UPDATEREF_ERR_ID = "150";
    public static final String UPDATEREF_ERR_MSG = "UpdateRefException";

    public static final String NOTINPRO_ERR_ID = "151";
    public static final String NOTINPRO_ERR_MSG = "NotInPromotionException";

    public static final String OUTOFPRO_ERR_ID = "152";
    public static final String OUTOFPRO_ERR_MSG = "OutOfPromotionException";

    public static final String TRXALREADYPAID_ERR_ID = "153";
    public static final String TRXALREADYPAID_ERR_MSG =
            "TransactionAlreadyPaidException";

    public static final String LOOKUPCHKAMTSRV_ERR_ID = "154";
    public static final String LOOKUPCHKAMTSRV_ERR_MSG =
            "LookupCheckAmountServiceException";

    public static final String CALLCHKAMTSRV_ERR_ID = "155";
    public static final String CALLCHKAMTSRV_ERR_MSG =
            "CallCheckAmountServiceException";

    public static final String PARSINGCHKAMT_ERR_ID = "156";
    public static final String PARSINGCHKAMT_ERR_MSG =
            "ParsingCheckAmountReturnException";

    public static final String CALCVAT_ERR_ID = "157";
    public static final String CALCVAT_ERR_MSG = "CalculateVatException";

    public static final String INIILOG_ERR_ID = "158";
    public static final String INIILOG_ERR_MSG = "InitLogFileException";

    public static final String FUNCNOTALLOWED_ERR_ID = "159";
    public static final String FUNCNOTALLOWED_ERR_MSG =
            "FunctionNotAllowedException";

    public static final String UNCLASSIFIED_ERR_ID = "999";
    public static final String UNCLASSIFIED_ERR_MSG = "UnclassifiedException";

    public static final String NO_AMOUNT_DUE_ERR_ID = "160";
    public static final String NO_AMOUNT_DUE_ERR_MSG = "NoAmountDueException";

    public static final String CLOSED_SERVICE_ERR_ID = "161";
    public static final String CLOSED_SERVICE_ERR_MSG =
            "ClosedServiceException";

    public static final String NO_FULL_FORM_OVERDAY_ERR_ID = "162";
    public static final String NO_FULL_FORM_OVERDAY_ERR_MSG =
            "NoFullFormOverDayException";

    public static final String OR_DATA_NOT_FULL_SET_ERR_ID = "163";
    public static final String OR_DATA_NOT_FULL_SET_ERR_MSG =
            "OrDataNotFullSetException";

    public static final String NO_RECORD_RETURN_ERR_ID = "164";
    public static final String NO_RECORD_RETURN_ERR_MSG =
            "NoRecordReturnException";

    public static final String RECORD_NUM_NOT_MATCHED_ERR_ID = "165";
    public static final String RECORD_NUM_NOT_MATCHED_ERR_MSG =
            "RecordNumNotMatchedException";

    public static final String UNKNOWN_METHOD_ERR_ID = "166";
    public static final String UNKNOWN_METHOD_ERR_MSG =
            "UnknownMethodException";

    public static final String TRX_NUM_NOT_MATCHED_ERR_ID = "167";
    public static final String TRX_NUM_NOT_MATCHED_ERR_MSG =
            "TrxNumNotMatchedException";

    public static final String TRX_ERR_ID = "168";
    public static final String TRX_ERR_MSG = "TransactionException";

    public static final String SRV_ADDRESS_NOT_FOUND_ERR_ID = "169";
    public static final String SRV_ADDRESS_NOT_FOUND_ERR_MSG =
            "ServiceAddressNotFoundException";

    public static final String NO_TRX_PROVIDE_ERR_ID = "170";
    public static final String NO_TRX_PROVIDE_ERR_MSG = "NoTrxProvideException";

    public static final String NULL_SRV_ADDR_ERR_ID = "171";
    public static final String NULL_SRV_ADDR_ERR_MSG =
            "NullServiceAddressException";

    public static final String NULL_SRV_CONF_ERR_ID = "172";
    public static final String NULL_SRV_CONF_ERR_MSG =
            "NullServiceConfigurationException";

    public static final String NULL_TRX_INFO_ERR_ID = "173";
    public static final String NULL_TRX_INFO_ERR_MSG =
            "NullTransactionInfoException";

    public static final String CHK_FUNCTION_ERR_ID = "174";
    public static final String CHK_FUNCTION_ERR_MSG = "CheckFunctionException";

    public static final String OR_OVERDAY_ERR_ID = "175";
    public static final String OR_OVERDAY_ERR_MSG = "OrOverDayException";

    public static final String FUNCTION_INFO_NOTFOUND_ERR_ID = "178";
    public static final String FUNCTION_INFO_NOTFOUND_ERR_MSG = "FunctionInfoNotFound";

    public static final String STEP_AMOUNT_ERR_ID = "179";
    public static final String STEP_AMOUNT_ERR_MSG = "StepAmountException";


    public static final String BLOCKED_VDR_ERR_ID = "180";
    public static final String BLOCKED_VDR_ERR_MSG = "BlockedVendorException";

    public static final String CALL_VDR_ERR_ID = "9000181";
    public static final String CALL_VDR_ERR_MSG = "CallVendorException";

    public static final String CHK_OR_OVERLIMIT_ERR_ID = "182";
    public static final String CHK_OR_OVERLIMIT_ERR_MSG = "NotAllowOROverLimit";

    public static final String CHK_TX_COMPLETE_ERR_ID = "183";
    public static final String CHK_TX_COMPLETE_ERR_MSG = "TxNotCompleteOROverLimit";

    public static final String CHK_WSCD_ERR_ID = "185";
    public static final String CALL_WSCD_ERR_MSG = "CallServerException";

    // Create By OutSource 08/04/2008
    // Error Case Bus_Date & System Date not Matched
    public static final String DATE_DIFF_ERR_ID = "186";
    public static final String DATE_DIFF_ERR_MSG = "DateDifferenceException";
    // End Create By OutSource 08/04/2008

    //----------TrueMoney and Franchisy------------------------
    public static final String FRAN_PER_ERR_ID = "187";
    public static final String FRAN_PER_ERR_MSG = "FranchisyPermissionException";
    //-----------TrueMoney and Franchisy-----------------------

    //	--------------Edit for samart (wip) by Narathip-------------
    public static final String WIP_STEP_AMOUNT_ERR_ID = "188";
    public static final String WIP_STEP_AMOUNT_ERR_MSG = "WIPStepAmountException";


    public static final String GENDERCHECK_ERR_ID = "189";
    public static final String GENDERCHECK_ERR_MSG = "GenderCheckdigitException";

    public static final String OLDCHECK_ERR_ID = "190";
    public static final String OLDCHECK_ERR_MSG = "OldCheckdigitException";

    public static final String NUMBERCHECK_ERR_ID = "191";
    public static final String NUMBERCHECK_ERR_MSG = "NumberCheckdigitException";

    //-----------------------Coupon Dtac by Narathip-----------------------------
    public static final String DISCOUNT_ERR_ID = "192";
    public static final String DISCOUNT_ERR_MSG = "DiscountCheckdigitException";
    public static final String COUPONNOTFOUND_ERR_ID = "193";
    public static final String COUPONNOTFOUND_ERR_MSG = "CouponNotFoundException";
    public static final String COUPONUSED_ERR_ID = "194";
    public static final String COUPONUSED_ERR_MSG = "CouponUsedException";
    //---------------------------------------------------------------------------
    public static final String CHK_HQ_ERR_ID = "001";
    public static final String CALL_HQ_ERR_MSG = "CallHqException";

    //-----------------------For MWA,MEA by Darong(JOE)---------------------------
    public static final String DeadlinePassed_ERR_ID = "195";
    public static final String DeadlinePassed_ERR_MSG = "DeadlinePassedException";
    public static final String InvoiceAmount_ERR_ID = "196";
    public static final String InvoiceAmount_ERR_MSG = "InvoiceAmountException";
    //---------------------------------------------------------------------------

    //	-----------------------For FullForm by Tawatchai ---------------------------
    public static final String VENDORNOTALLOWFULLFORM_ERR_ID = "197";
    public static final String VENDORNOTALLOWFULLFORM_ERR_MSG = "VendorNotAllowFullFormException";
    public static final String FULLFORMDATAEXCHANGETIMEOUT_ERR_ID = "198";
    public static final String FULLFORMDATAEXCHANGETIMEOUT_ERR_MSG = "FullFormDataExchangeTimeOutException";
    public static final String INVALIDFULLFORMTRANSACTIONSTATE_ERR_ID = "199";
    public static final String INVALIDFULLFORMTRANSACTIONSTATE_ERR_MSG = "InvalidFullFormTransactionStateException";
    public static final String NORMALTRANSACTIONNOTFOUND_ERR_ID = "203";
    public static final String NORMALTRANSACTIONNOTFOUND_ERR_MSG = "NormalTransactionNotFound";
    //---------------------------------------------------------------------------

    public static final String DEADLINE_PASSED_EXCEPTION_ERR_ID = "202";
    public static final String DEADLINE_PASSED_EXCEPTION_ERR_MSG = "DeadlinePassedException";

    //	-----------------------For FullForm by Nuttawut Wung ---------------------------
    public static final String OR_INVALID_INVOICE_ERR_ID = "201";
    public static final String OR_INVALID_INVOICE_ERR__MSG = "ORInvalidInvoiceException";
    //-------------------------------------------------------------------------------
    public static final String Quantities_ERR_ID = "204";
    public static final String Quantities_ERR_MSG = "QuantitiesException";

    public static final String NoneService_ERR_ID = "205";
    public static final String NoneService_ERR_MSG = "NoneServiceException";

    public static final String BranchNotAllowPaid_ERR_ID = "206";
    public static final String BranchNotAllowPaid_ERR_MSG = "BranchNotAllowPaid";

    public static final String NotAllowOROverTime_ERR_ID = "207";
    public static final String NotAllowOROverTime_ERR_MSG = "NotAllowOROverTime";

    //---------------------- TG Online -----------------------------------
    public static final String NOTALLOW_REPRINT_ERR_ID = "208";
    public static final String NOTALLOW_REPRINT_ERR_MSG = "NotAllowReprint";

    public static final String TX_NOT_COMPLETE_CANNOT_REPRINT_ID = "209";
    public static final String TX_NOT_COMPLETE_CANNOT_REPRINT_MSG = "TxNotCompleteCanNotReprint";

    public static final String POS_NOTSENT_TXID_CANNOT_REPRINT_ID = "210";
    public static final String POS_NOTSENT_TXID_CANNOT_REPRINT_MSG = "POSNotSendTx_IDCanNotReprint";

    public static final String REPRINT_TRANSACTION_NOTFOUND_EXCEPTION_ID = "211";
    public static final String REPRINT_TRANSACTION_NOTFOUND_EXCEPTION_MSG = "ReprintTransactionNotFoundException";

    public static final String REPRINT_TIMEOUT_EXCEPTION_ID = "212";
    public static final String REPRINT_TIMEOUT_EXCEPTION_MSG = "ReprintTimeoutException";
    //	---------------------- TG Online -----------------------------------

    public static final String CALCULATECHARGE_ERR_ID = "213";
    public static final String CALCULATECHARGE_ERR_MSG = "CalculateChargeException";

    public static final String BLOCK_OUTLET_ERR_ID = "214";
    public static final String BLOCK_OUTLET_ERR_MSG = "BlockedOutletException";

    public static final String VERSION_NOT_UPDATE_ERR_ID = "215";
    public static final String VERSION_NOT_UPDATE_MSG = "VersionNotUpdateException";

    public static final String OR_NOT_ALLOW_ERR_ID = "216";
    public static final String OR_NOT_ALLOW_ERR_MSG = "OrNotAllowException";

    public static final String TICKET_OVER_LIMIT_EXCEPTION_ERR_ID = "217";
    public static final String TICKET_OVER_LIMIT_EXCEPTION_ERR_MSG = "TicketOverLimitException";

    public static final String TICKET_PRICE_NOT_MATCH_EXCEPTION_ERR_ID = "218";
    public static final String TICKET_PRICE_NOT_MATCH_EXCEPTION_ERR_MSG = "TicketPriceNotMatchException";

    public static final String TICKET_EMPTY_EXCEPTION_ERR_ID = "219";
    public static final String TICKET_EMPTY_EXCEPTION_ERR_MSG = "TicketEmptyException";

    public static final String TICKET_MATCH_DATE_EXCEPTION_ERR_ID = "220";
    public static final String TICKET_MATCH_DATE_EXCEPTION_ERR_MSG = "TicketMatchByDateNotFoundException";

    public static final String TICKET_MATCH_STADIUM_EXCEPTION_ERR_ID = "221";
    public static final String TICKET_MATCH_STADIUM_EXCEPTION_ERR_MSG = "TicketMatchStadiumNotFoundException";

    public static final String TICKET_MATCH_TEAM_EXCEPTION_ERR_ID = "222";
    public static final String TICKET_MATCH_TEAM_EXCEPTION_ERR_MSG = "TicketMatchTeamNotFoundException";

    public static final String TICKET_QUANTITY_EXCEPTION_ERR_ID = "223";
    public static final String TICKET_QUANTITY_EXCEPTION_ERR_MSG = "TicketQuantityException";

    public static final String VENDOR_ID_NOT_MATCH_EXCEPTION_ERR_ID = "224";
    public static final String VENDOR_ID_NOT_MATCH_EXCEPTION_ERR_MSG = "VendorIdNotMatchException";

    public static final String CALLVENDOR_NOT_RETURN_REFERENCE1_ERR_ID = "225";
    public static final String CALLVENDOR_NOT_RETURN_REFERENCE1_ERR_MSG = "CallVendorNotReturnReference1Exception";

    public static final String CALLVENDOR_NOT_RETURN_REFERENCE2_ERR_ID = "226";
    public static final String CALLVENDOR_NOT_RETURN_REFERENCE2_ERR_MSG = "CallVendorNotReturnReference2Exception";

    public static final String CALLVENDOR_NOT_RETURN_REFERENCE3_ERR_ID = "227";
    public static final String CALLVENDOR_NOT_RETURN_REFERENCE3_ERR_MSG = "CallVendorNotReturnReference3Exception";

    public static final String CALLVENDOR_NOT_RETURN_REFERENCE4_ERR_ID = "228";
    public static final String CALLVENDOR_NOT_RETURN_REFERENCE4_ERR_MSG = "CallVendorNotReturnReference4Exception";

    public static final String CALLVENDOR_NOT_RETURN_AMOUNTRECEIEVED_ERR_ID = "229";
    public static final String CALLVENDOR_NOT_RETURN_AMOUNTRECEIEVED_ERR_MSG = "CallVendorNotReturnAmountReceievedException";

    public static final String SERVICE_GENERATE_TAXSERIAL_ERR_ID = "230";
    public static final String SERVICE_GENERATE_TAXSERIAL_ERR_MSG = "ServiceGenerateTaxSerialException";

    public static final String MODIFY_DISCOUNT_XMLRETURN_ERR_ID = "231";
    public static final String MODIFY_DISCOUNT_XMLRETURN_ERR_MSG = "ModifyDiscountXmlReturnException";

    public static final String SERVICE_GENERATE_TAXSERIAL_LENGTH_ERR_ID = "232";
    public static final String SERVICE_GENERATE_TAXSERIAL_LENGTH_ERR_MSG = "ServiceGenerateTaxSerialLengthException";

    public static final String REPRINT_SLIP_OVER_LIMIT_EXCEPTION_ERR_ID = "233";
    public static final String REPRINT_SLIP_OVER_LIMIT_EXCEPTION_ERR_MSG = "ReprintSlipOverLimitException";

    //	---------------------- CPAC -----------------------------------
    public static final String ACTIVE_SYSTEM_ERR_ID = "234";
    public static final String ACTIVE_SYSTEM_ERR_MSG = "ActiveSystemException";

    public static final String NOT_ALLOW_BRANCH_ERR_ID = "235";
    public static final String NOT_ALLOW_BRANCH_ERR_MSG = "NotAllowBranchException";

    public static final String BALANCE_AMOUNT_ERR_ID = "236";
    public static final String BALANCE_AMOUNT_ERR_MSG = "BalanceAmountException";

    public static final String CS_BALANCE_AMT_NOT_FOUND_ERR_ID = "237";
    public static final String CS_BALANCE_AMT_NOT_FOUND_ERR_MSG = "CSBalanceAmtNotFoundException";

    public static final String CS_AMOUNT_NOT_FOUND_ERR_ID = "238";
    public static final String CS_AMOUNT_NOT_FOUND_ERR_MSG = "CSAmountNotFoundException";

    public static final String CS_ADVANCE_BALANCE_ERR_ID = "239";
    public static final String CS_ADVANCE_BALANCE_ERR_MSG = "CSAdvanceBalanceException";

    public static final String CS_ONLINE_BALANCE_ERR_ID = "240";
    public static final String CS_ONLINE_BALANCE_ERR_MSG = "CSOnlineBalanceException";

    public static final String UPDATE_STATUS_UNLOCK_ERR_ID = "243";
    public static final String UPDATE_STATUS_UNLOCK_ERR_MSG = "UnableToUndateUnlockFinancialStatusException";

    public static final String NOT_ALLOW_REDUCE_BALANCE_ERR_ID = "244";
    public static final String NOT_ALLOW_REDUCE_BALANCE_ERR_MSG = "NotAllowedToReduceBalanceException";

    public static final String ACCOUNT_LIMIT_BALANCE_ERR_ID = "252";
    public static final String ACCOUNT_LIMIT_BALANCE_ERR_MSG = "AccountLimitBalanceException";

    public static final String BRANCH_LIMIT_BALANCE_ERR_ID = "254";
    public static final String BRANCH_LIMIT_BALANCE_ERR_MSG = "BranchLimitBalanceException";

    public static final String SYSTEM_DATE_REF_NOT_FOUND_ERR_ID = "255";
    public static final String SYSTEM_DATE_REF_NOT_FOUND_ERR_MSG = "SystemDateRefNotFoundException";
    //	---------------------- CPAC -----------------------------------


    public static final String INSERT_PRINTSLIP_ERR_ID = "241";
    public static final String INSERT_PRINTSLIP_ERR_MSG = "InsertMessagePrintSlipException";

    public static final String TXID_PRINTSLIP_NOT_FOUND_ERR_ID = "242";
    public static final String TXID_PRINTSLIP_NOT_FOUND_ERR_MSG = "TxIdPrintSlipNotFoundException";

    public static final String AMOUNT_RECEIEVED_NOT_MATCHED_VAT_AMOUNT_ERR_ID = "245";
    public static final String AMOUNT_RECEIEVED_NOT_MATCHED_VAT_AMOUNT_ERR_MSG = "VendorReturnAmountReceievedNotMatchVatAmountException";

    public static final String MODIFY_PRINTSLIP_POPINFO_ERR_ID = "246";
    public static final String MODIFY_PRINTSLIP_POPINFO_ERR_MSG = "ModifyPrintSlipPopInfoException";

    //add exception ticket
    public static final String TICKET_SEAT_ZONE_EXCEPTION_ERR_ID = "248";
    public static final String TICKET_SEAT_ZONE_EXCEPTION_ERR_MSG = "TicketSeatZoneException";

    public static final String VENDOR_CPAC_ERR_ID = "247";
    public static final String VENDOR_CPAC_ERR_MSG = "VendorCPACException";

    public static final String TICKET_PRICE_NOTMATCH_ZONE_EXCEPTION_ERR_ID = "249";
    public static final String TICKET_PRICE_NOTMATCH_ZONE_EXCEPTION_ERR_MSG = "TicketPriceNotMatchZoneException";

    public static final String TICKET_NOT_SUPPORT_VERSION_EXCEPTION_ERR_ID = "250";
    public static final String TICKET_NOT_SUPPORT_VERSION_EXCEPTION_ERR_MSG = "TicketNotSupportVersionException";

    public static final String SERVICE_ID_NOT_MATCHED_ERR_ID = "251";
    public static final String SERVICE_ID_NOT_MATCHED_ERR_MSG = "ServiceIdNotMatchedException";

    public static final String AUTOFIX_BF_ERR_ID = "998";
    public static final String AUTOFIX_BF_ERR_MSG = "AutoFixBf1";

    public static final String KEY_MESSAGE_ERR_ID = "256";
    public static final String KEY_MESSAGE_ERR_MSG = "KeyMessageException";

    public static final String PAYMENT_CHANNEL_RECEIEVED_ERR_ID = "257";
    public static final String PAYMENT_CHANNEL_RECEIEVED_ERR_MSG = "PaymentChannelReceievedException";

    public static final String VAT_RATE_ERR_ID = "258";
    public static final String VAT_RATE_ERR_MSG = "VatRateException";

    public static final String VENDORSERVICE_XMLRETURN_ERR_ID = "259";
    public static final String VENDORSERVICE_XMLRETURN_ERR_MSG = "VendorServiceXMLReturnException";

//	public static final String MTI_RECORD_NOT_FOUND_ID = "9436002";
//	public static final String MTI_RECORD_NOT_FOUND_ERR_MSG = "MTIRecordNotFoundException";

    public static final String WRONG_FORMAT_AMOUNT_INPUT_ID = "279";
    public static final String WRONG_FORMAT_AMOUNT_INPUT_ERR_MSG = "WrongFormatAmountInputException";

    public static final String SMS_URL_NOT_FOUND_ID = "262";
    public static final String SMS_URL_NOT_FOUND_ERR_MSG = "SMSUrlNotFoundException";

    public static final String CHECKDIGIT_CLASS_NOT_FOUND_ID = "286";
    public static final String CHECKDIGIT_CLASS_NOT_FOUND_MSG = "CheckDigitClassNotFoundException";

    public static final String DATA_EXCHANGE_DATA_NOT_FOUND_ID = "9000182";
    public static final String DATA_EXCHANGE_DATA_NOT_FOUND_ERR_MSG = "ReceiveDataExchangeNotFoundException";

    public static final String DATA_EXCHANGE_CONFIRM_DATA_NOT_FOUND_ID = "9000183";
    public static final String DATA_EXCHANGE_CONFIRM_DATA_NOT_FOUND_ERR_MSG = "ReceiveDataExchangeConfirmNotFoundException";

    public static final String DATA_ENCRYPTED_NOT_FOUND_ID = "9000184";
    public static final String DATA_ENCRYPTED_NOT_FOUND_ERR_MSG = "EncryptedDataNotFoundException";

    public static final String  DATACALCULATEEXCEPTION_ID = "264";
    public static final String  DATACALCULATEEXCEPTION_MSG = "DataCalculateException";

    public static final String  DATA_ACT_DUPLICATE_EEXCEPTION_ID = "9436001";
    public static final String  DATA_ACT_DUPLICATE_EEXCEPTION_MSG = "DataActDuplicateException";

    public static final String MTI_RECORD_NOT_FOUND_ID = "9436002";
    public static final String MTI_RECORD_NOT_FOUND_ERR_MSG = "MTIRecordNotFoundException";

    public static final String MWA_NOT_RETURN_METHOD_ID = "9004801";
    public static final String MWA_NOT_RETURN_METHOD_ERR_MSG = "MWANotReturnMethodException";

    public static final String MWA_NOT_RETURN_CODE_ID = "9004802";
    public static final String MWA_NOT_RETURN_CODE_ERR_MSG = "MWANotReturnCodeException";

    public static final String MWA_NOT_RETURN_VENDOR_ID = "9004803";
    public static final String MWA_NOT_RETURN_VENDOR_ERR_MSG = "MWANotReturnVendorIdException";

    public static final String MWA_NOT_RETURN_SERVICE_ID = "9004804";
    public static final String MWA_NOT_RETURN_SERVICE_ERR_MSG = "MWANotReturnServiceIdException";

    public static final String MWA_NOT_RETURN_AMOUNT_ID = "9004805";
    public static final String MWA_NOT_RETURN_AMOUNT_ERR_MSG = "MWANotReturnAmountException";

    public static final String MWA_NOT_RETURN_VAT_ID = "9004806";
    public static final String MWA_NOT_RETURN_VAT_ERR_MSG = "MWANotReturnVatException";

    public static final String MWA_NOT_RETURN_TX_ID = "9004807";
    public static final String MWA_NOT_RETURN_TX_ERR_MSG = "MWANotReturnTxIdException";

    public static final String MWA_RETURN_INCORRECT_XML_ID = "9004808";
    public static final String MWA_RETURN_INCORRECT_XML_ERR_MSG = "MWAReturnIncorrectXMLException";

    public static final String MWA_NOT_RETURN_REFERENCE1_ID = "9004809";
    public static final String MWA_NOT_RETURN_REFERENCE1_ERR_MSG = "MWANotReturnReference1Exception";

    public static final String MWA_NOT_RETURN_REFERENCE2_ID = "9004810";
    public static final String MWA_NOT_RETURN_REFERENCE2_ERR_MSG = "MWANotReturnReference2Exception";

    public static final String MWA_NOT_RETURN_REFERENCE3_ID = "9004811";
    public static final String MWA_NOT_RETURN_REFERENCE3_ERR_MSG = "MWANotReturnReference3Exception";

    public static final String MWA_NOT_RETURN_REFERENCE4_ID = "9004812";
    public static final String MWA_NOT_RETURN_REFERENCE4_ERR_MSG = "MWANotReturnReference4Exception";
    //------------- Online Check Data Vendor Return
    public static final String X_BKA_ReturnAmount_ID = "X445001";
    public static final String X_BKA_ReturnAmount_ERR_MSG = "VendorReturnAmontException";

    public static final String GEO_NOT_MATCH_SERVICE_ID = "9087801";
    public static final String GEO_NOT_MATCH_SERVICE_ERR_MSG = "GEONotMatchServiceException";

    public static final String GEO_DATA_NOT_FOUND_ID = "9087802";
    public static final String GEO_DATA_NOT_FOUND_ERR_MSG = "GEODataNotFoundException";

    public static final String GEO_DIRECT_DATA_NOT_FOUND_ID = "9087803";
    public static final String GEO_DIRECT_DATA_NOT_FOUND_ERR_MSG = "GEODirectDataNotFoundException";

    public static final String GEO_DUPLICATE_DATA_NOT_FOUND_ID = "9087001";
    public static final String GEO_DUPLICATE_DATA_NOT_FOUND_ERR_MSG = "GEODuplicateException";

    public static final String GEO_ZONE_NOT_FOUND_ID = "9087806";
    public static final String GEO_ZONE_NOT_FOUND_MSG = "GEOZoneNotMatchException";

    public static final String GEO_SERVICE_RETURN_NOT_MATCH_ID = "9087804";
    public static final String GEO_SERVICE_RETURN_NOT_MATCH_ERR_MSG = "GEOServiceReturnNotMatchException";

    public static final String GEO_CONFIRM_OVERDAY_MAKECOMPLETE_ID = "9087807";
    public static final String GEO_CONFIRM_OVERDAY_MAKECOMPLETE_ERR_MSG = "GEOConfirmOverDayMakeCompleteException";

    public static final String GEO_TXN_STATUS_COMPLETE_ID = "9087808";
    public static final String GEO_TXN_STATUS_COMPLETE_ERR_MSG = "GEOTxnStatusCompleteException";

    public static final String GEO_MAKE_COMPLETE_ERROR_ID = "9087808";
    public static final String GEO_MAKE_COMPLETE_ERROR_MSG = "GEOMakeCompleteErrorException";

    public static final String BRANCH_ALLOW_ERR_ID = "502";
    public static final String BRANCH_ALLOW_ERR_MSG = "BranchAllowException";

    public static final String ZONE_IS_NULL_ERR_ID = "503";
    public static final String ZONE_IS_NULL_ERR_MSG = "ZoneIsNullException";

    public static final String LXM_SERIAL_NO_IS_NULL_ID = "98499001";
    public static final String LXM_SERIAL_NO_IS_NULL_ERR_MSG = "LXMSerialNoIsNullException";

    public static final String LXM_TOPUP_PIN_IS_NULL_ID = "98499002";
    public static final String LXM_TOPUP_PIN_IS_NULL_ERR_MSG = "LXMTopupPinIsNullException";

    public static final String JIN_SERIAL_NO_IS_NULL_ID = "98506001";
    public static final String JIN_SERIAL_NO_IS_NULL_ERR_MSG = "LXMSerialNoIsNullException";

    public static final String JIN_TOPUP_PIN_IS_NULL_ID = "98506001";
    public static final String JIN_TOPUP_PIN_IS_NULL_ERR_MSG = "LXMTopupPinIsNullException";

    public static final String CFG_DATA_NOT_FOUND_ID = "9271802";
    public static final String CFG_DATA_NOT_FOUND_ERR_MSG = "CFGDataNotFoundException";

    public static final String CFG_DIRECT_DATA_NOT_FOUND_ID = "9271803";
    public static final String CFG_DIRECT_DATA_NOT_FOUND_ERR_MSG = "CFGDirectDataNotFoundException";

    public static final String CFG_NOT_MATCH_SERVICE_ID = "9271801";
    public static final String CFG_NOT_MATCH_SERVICE_ERR_MSG = "CFGNotMatchServiceException";

    public static final String CFG_SERVICE_RETURN_NOT_MATCH_ID = "9271804";
    public static final String CFG_SERVICE_RETURN_NOT_MATCH_ERR_MSG = "CFGServiceReturnNotMatchException";

    public static final String CFG_PAYCODE_NOT_FOUND_ID = "9271805";
    public static final String CFG_PAYCODE_NOT_FOUND_ERR_MSG = "CFGPaycodeNotFoundException";

    /*					Expired Code  by top            */

    public static final String CCM_PAYCODE_EXPPIRED_ID = "9316012";
    public static final String CCM_PAYCODE_EXPPIRED_ERR_MSG = "CCMPaycodeExpiredException";

    public static final String PSN_PAYCODE_EXPPIRED_ID = "9446012";
    public static final String PSN_PAYCODE_EXPPIRED_ERR_MSG = "PSNPaycodeExpiredException";

    public static final String SKW_PAYCODE_EXPPIRED_ID = "9450012";
    public static final String SKW_PAYCODE_EXPPIRED_ERR_MSG = "SKWPaycodeExpiredException";

    public static final String SHT_PAYCODE_EXPPIRED_ID = "9449012";
    public static final String SHT_PAYCODE_EXPPIRED_ERR_MSG = "SHTPaycodeExpiredException";

    public static final String SFT_PAYCODE_EXPPIRED_ID = "9438012";
    public static final String SFT_PAYCODE_EXPPIRED_ERR_MSG = "SFTPaycodeExpiredException";

    public static final String INVALID_DATETIME_FORMAT_ID = "274";
    public static final String INVALID_DATETIME_FORMAT_ERR_MSG = "InvalidDateTimeFormatFromVendorException";

    public static final String REQUIRE_DATETIME_FORMAT_ID = "275";
    public static final String REQUIRE_DATETIME_FORMAT_ERR_MSG = "RequireDateTimeFormatFromVendorException";

    public static final String INVALID_DATETIME_FORMAT_POS_ID = "276";
    public static final String INVALID_DATETIME_FORMAT_POS_ERR_MSG = "InvalidDateTimeFormatFromPosException";

    public static final String POS_SYSTEM_DATE_TIME_ID = "9405803";
    public static final String POS_SYSTEM_DATE_TIME_ERR_MSG = "PosSystemDateTimeException";

    public static final String MAKE_COMPLETE_SUCCESS_ID = "9405801";
    public static final String MAKE_COMPLETE_SUCCESS_ERR_MSG = "MakeCompleteSuccessException";

    public static final String MAKE_COMPLETE_ERROR_ID = "9405802";
    public static final String MAKE_COMPLETE_ERROR_ERR_MSG = "MakeCompleteErrorException";

    public static final String PAYCODE_EXPIRED_TIMEOUT_ID = "9000250";
    public static final String PAYCODE_EXPIRED_TIMEOUT_ERR_MSG = "PayCodeExpiredTimeOutException";

    public static final String INVALID_BUS_DATE_FROM_POS_ID = "9405805";
    public static final String INVALID_BUS_DATE_FROM_POS_ERR_MSG = "InvalidBusDateFromPosException";

    public static final String NOT_MATCH_DATE_FOR_SEND_ID = "9405804";
    public static final String NOT_MATCH_DATE_FOR_SEND_ERR_MSG = "NotMatchDateForSendException";

    public static final String PHONE_NUMBER_FORMAT_ID = "9515802";
    public static final String PHONE_NUMBER_FORMAT_ERR_MSG = "PhoneNumberFormatException";

    public static final String TLT_SUBFIX_REF_ID = "9148801";
    public static final String TLT_SUBFIX_REF_MSG = "SubfixReferenceException";

    public static final String TLT_NOTPASS_SERVICE_RETURN_ID = "9148802";
    public static final String TLT_NOTPASS_SERVICE_RETURN_MSG = "TLTNotPassServiceReturnException";

    public static final String TLT_NOTMATCH_SERVICE_RETURN_ID = "9148803";
    public static final String TLT_NOTMATCH_SERVICE_RETURN_MSG = "TLTNotMatchServiceException";

    public static final String PARSING_NUMBER_ERROR_ID = "276";
    public static final String PARSING_NUMBER_ERROR_MSG = "ParsingNumberException";

    public static final String CNP_NOT_FOUND_PACKAGE_ERROR_ID = "9524801";
    public static final String CNP_NOT_FOUND_PACKAGE_ERROR_MSG = "CNPNotFoundPackageException";

    public static final String PTT_DATA_NOT_FOUND_ID = "9513801";
    public static final String PTT_DATA_NOT_FOUND_MSG = "PTTDataNotFoundException";

    public static final String PTT_NOT_MATCH_SERVICE_ID = "9513802";
    public static final String PTT_NOT_MATCH_SERVICE_MSG = "PTTNotMatchServiceException";

    public static final String WRONG_FORMAT_TELEPHONE_NUMBER_ID = "277";
    public static final String WRONG_FORMAT_TELEPHONE_NUMBER_MSG = "WrongFormatTelNoException";

    public static final String CANNOT_REFILL_OVER_LIMIT_ID = "9406002";
    public static final String CANNOT_REFILL_OVER_LIMIT_ERR_MSG = "CannotRefillOverLimitException";

    public static final String ITOUCH_CONFIRM_NOT_FOUND_ID = "9808801";
    public static final String ITOUCH_CONFIRM_NOT_FOUND_ERR_MSG = "ITOUCHConfirmNotFoundException";

    public static final String SGB_ALREADY_PAID_EXCEPTION_MSG = "SGBAlreadyPaidException";
    public static final String SGB_ALREADY_PAID_EXCEPTION_ID = "9575801";

    public static final String SGB_DATA_NOT_FOUND_EXCEPTION_MSG = "SGBDataNotFoundException";
    public static final String SGB_DATA_NOT_FOUND_EXCEPTION_ID = "9575802";

    public static final String SGB_INVALID_STATUS_EXCEPTION_MSG = "SGBInvalidStatusException";
    public static final String SGB_INVALID_STATUS_EXCEPTION_ID = "9575803";

    public static final String TVS_INVALID_BILL_TYPE_ERR_ID = "90068009";
    public static final String TVS_INVALID_BILL_TYPE_ERR_MSG = "TVSInvalidBillTypeException";

    public static final String DUE_DATE_EXPIRE_ERR_ID = "282";
    public static final String DUE_DATE_EXPIRE_ERR_MSG = "DuedateExpireException";

    public static final String TVS_CUSTOMERTAXID_NOT_FOUND_ERR_ID = "9049801";
    public static final String TVS_CUSTOMERTAXID_NOT_FOUND_ERR_MSG = "TVSCustomerTaxIdNotFoundException";

    public static final String TVS_CUSTOMER_BRANCH_CODE_NOT_FOUND_ERR_ID = "9049802";
    public static final String TVS_CUSTOMER_BRANCH_CODE_NOT_FOUND_ERR_MSG = "TVSCustomerBranchCodeNotFoundException";

    public static final String TVS_CUSTOMER_BRANCH_NAME_NOT_FOUND_ERR_ID = "9049803";
    public static final String TVS_CUSTOMER_BRANCH_NAME_NOT_FOUND_ERR_MSG = "TVSCustomerBranchNameNotFoundException";

    public static final String TVS_REFERENCE3_EMPTY_ERR_ID = "9049804";
    public static final String TVS_REFERENCE3_EMPTY_ERR_MSG = "TVSReference3EmptyException";

    public static final String AGE_NOT_CONVER_RANGE_ERR_ID = "404";
    public static final String AGE_NOT_CONVER_RANGE_ERR_MSG = "AgeNotInCoverRangeException";

    public static final String KNK_DUPLICATE_DATA_NOT_FOUND_ID = "403";
    public static final String KNK_DUPLICATE_DATA_NOT_FOUND_ERR_MSG = "KNKDuplicateException";

    public static final String PAXCOUNT_ZERO_ERR_ID = "9804001";
    public static final String PAXCOUNT_ZERO_ERR_MSG = "PaxcountZeroException";

    public static final String PAXCOUNT_NOT_MATCH_ERR_ID = "9804002";
    public static final String PAXCOUNT_NOT_MATCH_ERR_MSG = "PaxcountNotMatchException";

    public static final String CSA_INSERT_DATA_EXCEPTION_ERR_ID = "9804003";
    public static final String CSA_INSERT_DATA_EXCEPTION_ERR_MSG = "CSAInsertDataException";

    public static final String CSA_INVALID_DATA_EXCEPTION_ERR_ID = "9804006";
    public static final String CSA_INVALID_DATA_EXCEPTION_ERR_MSG = "CSAInvalidDataException";


    protected String errId = "";
    protected String errMsg = "";
    protected String ret1 = "";
    protected String ret2 = "";
    protected String ret3 = "";

    public CSException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }

    public CSException(String errMsg, String errId) {
        super(errMsg);
        this.errMsg = errMsg;
        this.errId = errId;
    }

    public CSException(String errMsg, String errId,
                       String ret1, String ret2, String ret3) {
        super(errMsg);
        this.errMsg = errMsg;
        this.errId = errId;
        this.ret1 = ret1;
        this.ret2 = ret2;
        this.ret3 = ret3;
    }

    /**
     * @return
     */
    public String getErrId() {
        return errId;
    }

    /**
     * @return
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * @param string
     */
    public void setErrMsg(String string) {
        errMsg = string;
    }

    /**
     * @return
     */
    public String getRet1() {
        return ret1;
    }

    /**
     * @return
     */
    public String getRet2() {
        return ret2;
    }

    /**
     * @return
     */
    public String getRet3() {
        return ret3;
    }

    /**
     * @param string
     */
    public void setRet1(String string) {
        ret1 = string;
    }

    /**
     * @param string
     */
    public void setRet2(String string) {
        ret2 = string;
    }

    /**
     * @param string
     */
    public void setRet3(String string) {
        ret3 = string;
    }
}
