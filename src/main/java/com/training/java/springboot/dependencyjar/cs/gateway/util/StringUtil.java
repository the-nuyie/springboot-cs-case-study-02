package com.training.java.springboot.dependencyjar.cs.gateway.util;


import com.training.java.springboot.dependencyjar.cs.gateway.util.common.Const;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	private static DecimalFormat decimalFormat = new DecimalFormat(
			"###,###,##0.00");
	private static SimpleDateFormat ymdFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss", Locale.US);
	private static SimpleDateFormat ymdSlashFormat = new SimpleDateFormat(
			"yyyy/MM/dd", Locale.US);
	private static SimpleDateFormat ymdFormatUs = new SimpleDateFormat(
			"yyyyMMdd", Locale.US);
	private static SimpleDateFormat dmyFormat = new SimpleDateFormat(
			"dd/MM/yyyy", Locale.US);
	private static SimpleDateFormat dmyHhmmFormat = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm", Locale.US);
	private static SimpleDateFormat yyyymmddHhmmssFormat = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss", Locale.US);
	private static SimpleDateFormat dmyHhmmssFormat = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm:ss", Locale.US);
	private static SimpleDateFormat hhmmFormat = new SimpleDateFormat("HH:mm",
			Locale.US);
	private static SimpleDateFormat hhmmAmPmFormat = new SimpleDateFormat(
			"hh:mm a", Locale.US);
	static SimpleDateFormat EN = new SimpleDateFormat("d MMM yyyy, EEE K:mm a",
			Locale.US);
	static SimpleDateFormat monthTH = new SimpleDateFormat("MMMM", new Locale(
			"th", "th"));
	static SimpleDateFormat yearTH = new SimpleDateFormat("yyyy", new Locale(
			"th", "th"));
	static SimpleDateFormat dmyTH = new SimpleDateFormat("dd/MMMM/yyyy",
			new Locale("th", "th"));
	static SimpleDateFormat dmyThSpace = new SimpleDateFormat("dd MMMM yyyy",
			new Locale("th", "th"));
	static SimpleDateFormat yearEN = new SimpleDateFormat("yyyy", Locale.US);

	private static DateFormatSymbols meridiemSymbols = new DateFormatSymbols();
	
	final private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

	public static String[] cutSuggestion(String desc) {
		int i = 0;
		String[] str = desc.split("\\|");
		int len = str.length;

		if (len < 3) {
			len = 3;
		}
		String[] result = new String[len];
		for (String val : str) {
			result[i] = val;
			i++;
		}

		return result;
	}

	public static boolean isEmpty(String rcvData) {
		if (rcvData == null) {
			return true;

		} else if (rcvData.trim().length() == 0) {
			return true;

		} else {
			return false;
		}
	}

	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	public static String checkNull(String value) {
		if (value == null || value.equalsIgnoreCase("null")) {
			value = "";
		}
		return value;
	}

	public static String padLeft(String str, int maxLength, String strPad)
			throws Exception {
		String result = str;
		try {
			if (result != null) {
				for (int i = 0; i < maxLength; i++) {
					if (result.length() < maxLength) {
						result = strPad + result;
					} else {
						return result;
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	public static String padRight(String str, int maxLength, String strPad)
			throws Exception {
		String result = str;
		try {
			if (result != null) {
				for (int i = 0; i < maxLength; i++) {
					if (result.length() < maxLength) {
						result = result + strPad;
					} else {
						return result;
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	public static String replacePattern(String str, ArrayList param)
			throws Exception {
		String result = str;
		int n = 0;
		try {
			if (str.indexOf("${") > -1) {
				Pattern pattern = Pattern.compile("\\$\\{([^\\}]*)\\}");
				Matcher matcher = pattern.matcher(str);
				while (matcher.find()) {
					String strKey = (matcher.group(1));
					if (param.get(n) instanceof Date) {
						Format formatter = new SimpleDateFormat(strKey,
								Locale.US);
						result = result.replaceFirst("\\$\\{" + strKey + "\\}",
								formatter.format(new Date()));
					} else {
						result = result.replaceFirst("\\$\\{" + strKey + "\\}",
								param.get(n).toString());
					}
					n++;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	public static String replaceSqlParam(String str, String[] param) {
		str = System.getProperty("line.separator") + str;

		StringBuffer tmp = new StringBuffer(str);
		int pos = 0;
		for (int i = 0; i < param.length; i++) {
			pos = tmp.toString().indexOf("?", pos);
			pos = pos + 1;
			tmp.insert(pos, " /*" + param[i] + "*/");
		}
		return tmp.toString();
	}

	public static String replaceParam(String str, String strReplce,
			String[] param) {
		StringBuffer tmp = new StringBuffer(str);
		int pos = 0;
		for (int i = 0; i < param.length; i++) {
			pos = tmp.toString().indexOf(strReplce, pos);
			pos = pos + 1;
			tmp.insert(pos, param[i]);
		}
		return tmp.toString();
	}

	public static String encodeThai(String str)
			throws UnsupportedEncodingException {
		return (isNotEmpty(str) ? (new String(
				str.getBytes(Const.ENCODE_GETBYTE), Const.ENCODE)) : null);
	}

	public static String encodeThaiNotNull(String str)
			throws UnsupportedEncodingException {
		return (isNotEmpty(str) ? (new String(
				str.getBytes(Const.ENCODE_GETBYTE), Const.ENCODE)) : "");
	}

	public static String encode(String str, String strGetByte, String strEncode)
			throws UnsupportedEncodingException {
		return new String(str.getBytes(strGetByte), strEncode);
	}

	public static String encodeToDb(String str)
			throws UnsupportedEncodingException {
		// return (isNotEmpty(str)?Unicode2ASCII(new
		// String(str.getBytes("ISO-8859-1"),"UTF-8")):null);
		return (isNotEmpty(str) ? Unicode2ASCII(new String(
				str.getBytes(Const.ENCODE_GETBYTE), Const.ENCODE_UTF_8)) : null);

	}

	public static String Unicode2ASCII(String unicode) {
		unicode = ifEmpty(unicode, "");
		StringBuffer ascii = new StringBuffer(unicode);
		int code;
		for (int i = 0; i < unicode.length(); i++) {
			code = (int) unicode.charAt(i);
			if ((0xE01 <= code) && (code <= 0xE5B))
				ascii.setCharAt(i, (char) (code - 0xD60));
		}
		return ascii.toString();
	}

	public static String ASCII2Unicode(String ascii) {
		StringBuffer unicode = new StringBuffer(ascii);
		int code;
		for (int i = 0; i < ascii.length(); i++) {
			code = (int) ascii.charAt(i);
			if ((0xA1 <= code) && (code <= 0xFB))
				unicode.setCharAt(i, (char) (code + 0xD60));
		}
		return unicode.toString();
	}

	public static String getRunIPServer() {
		String ipServer = "";
		try {
			InetAddress address = InetAddress.getLocalHost();
			ipServer = address.getHostAddress();

		} catch (Exception ex) {
			ipServer = "";
		}
		return ipServer;
	}

    public static String byteToBase64(byte[] b) throws Exception {
        return Base64.getEncoder().encodeToString(b);
    }

    public static byte[] base64ToByte(String str) throws Exception {
        return Base64.getDecoder().decode(str);
    }

    public static String stringToBase64(String str) throws Exception {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    public static String base64ToString(String str) throws Exception {
        return new String(Base64.getDecoder().decode(str));
    }

	public static String ifNull(String rcvText, String replaceNull) {
		String rtnText = "";

		if (rcvText == null) {
			rtnText = replaceNull;
		} else {
			rtnText = rcvText;
		}

		return rtnText;
	}

	public static String ifEmpty(String rcvText, String replaceNull) {
		String rtnText = "";

		if (isEmpty(rcvText)) {
			rtnText = replaceNull;
		} else {
			rtnText = rcvText;
		}

		return rtnText;
	}

	public static String toCurrency(Object d) throws Exception {
		if (d == null) {
			return null;
		}
		return decimalFormat.format(Double.parseDouble(d.toString()));
	}

	public static String replaceNull(String str, String strReplace)
			throws Exception {
		String result = str;
		if (result == null || result.equals("null")) {
			result = strReplace;
		}
		return result;
	}

	public static String hideTelno(String telNo) throws Exception {
		String result = telNo;
		if (result != null && !result.equals("")) {
			String s1 = "";
			String s2 = "";
			String s3 = "";

			if (result.length() == 10) {
				s1 = result.substring(0, 3);
				s2 = result.substring(3, 6);
				s3 = "XXXX";
			} else if (result.length() == 9) {
				s1 = result.substring(0, 2);
				s2 = result.substring(2, 5);
				s3 = "XXXX";
			}

			result = s1 + "-" + s2 + "-" + s3;
		}

		return result;
	}

	public static String hideNIdno(String nIdNo) throws Exception {
		String result = nIdNo;
		if (result != null && !result.equals("")) {
			String s1 = "";
			String s2 = "";

			if (result.length() == 13) {
				s1 = "XXXXXXXXX";
				s2 = result.substring(9);

			}

			result = s1 + s2;
		}

		return result;
	}

	public static String ymdToDmyHhmm(String d) throws Exception {
		return dmyHhmmFormat.format(ymdFormat.parse(d));
	}

	public static String ymdToDmyHhmmss(String d) throws Exception {
		return dmyHhmmssFormat.format(ymdFormat.parse(d));
	}

	public static String ymdToDmy(String d) throws Exception {
		if (d == null) {
			return "";
		} else {
			return dmyFormat.format(ymdFormat.parse(d));
		}
	}

	public static String ymdToHhmm(String d) throws Exception {
		return hhmmFormat.format(ymdFormat.parse(d));
	}

	public static String dmyToDmyHhmm(String d) throws Exception {
		return dmyHhmmFormat.format(dmyHhmmFormat.parse(d));
	}

	public static String dmyHHmmToHhmm(String d) throws Exception {
		return hhmmFormat.format(dmyHhmmFormat.parse(d));
	}

	public static String dmyToDmy(String d) throws Exception {
		return dmyFormat.format(dmyHhmmFormat.parse(d));
	}

	public static String dmyToYmd(String d) throws Exception {
		return ymdSlashFormat.format(dmyFormat.parse(d));
	}

	public static String ymdSlashToDmy(String d) throws Exception {
		return dmyFormat.format(ymdSlashFormat.parse(d));
	}
	
	public static String ymdFormatToDmySlashFormat(String d) throws Exception {
		return dateFormatter.format(ymdFormatUs.parse(d));
	}
	
	public static String ymdFormat(String d) throws Exception {
		return ymdFormatUs.format(ymdFormatUs.parse(d));
	}

	public static String dmyHHmmToHhmmAmPm(String d) throws Exception {

		meridiemSymbols.setAmPmStrings(new String[] { "am", "pm" });
		hhmmAmPmFormat.setDateFormatSymbols(meridiemSymbols);

		return hhmmAmPmFormat.format(dmyHhmmFormat.parse(d));
	}

	/************ dmyHhmmFormat to dmyHhmmTH *********************/
	public static String dmyHhmmToDay(String str) throws Exception {
		if (str == null || str.equals("")) {
			return "";
		} else {
			return new SimpleDateFormat("dd", new Locale("th", "th"))
					.format(ymdSlashFormat.parse(str));
		}
	}

	public static String dmyHhmmToMonthTH(String str) throws Exception {
		if (str == null || str.equals("")) {
			return "";
		} else {
			return monthTH.format(ymdSlashFormat.parse(str));
		}
	}


	
	public static String dmbHhmmToYear(String str) throws Exception {
		if (str == null || str.equals("")) {
			return "";
		} else {
			if (Integer.parseInt("25"+str.substring(0, 2)) < 2500) {
				return yearTH.format(ymdSlashFormat.parse(str));
			} else {
				return yearEN.format(ymdSlashFormat.parse(str));
			}
		}
	}

	public static String dmyHhmmToDmyTH(String str) throws Exception {
		if (str == null || str.equals("")) {
			return "";
		} else {
			return dmyTH.format(dmyHhmmFormat.parse(str));
		}
	}

	/************ dmyHhmmFormat to dmyHhmmTH *********************/
	public static String yyyymmddHhmmssToDay(String str) throws Exception {
		if (str == null || str.equals("")) {
			return "";
		} else {
			return new SimpleDateFormat("dd", new Locale("th", "th"))
					.format(yyyymmddHhmmssFormat.parse(str));
		}
	}

	public static String yyyymmddHhmmssToMonthTH(String str) throws Exception {
		if (str == null || str.equals("")) {
			return "";
		} else {
			return monthTH.format(yyyymmddHhmmssFormat.parse(str));
		}
	}

	public static String yyyymmddHhmmssToYearTH(String str) throws Exception {
		if (str == null || str.equals("")) {
			return "";
		} else {
			if (Integer.parseInt(str.substring(0, 4)) < 2500) {
				return yearTH.format(yyyymmddHhmmssFormat.parse(str));
			} else {
				return str;
			}
		}
	}
	
	

	public static String yyyymmddHhmmssToDmyTH(String str) throws Exception {
		if (str == null || str.equals("")) {
			return "";
		} else {
			return dmyTH.format(yyyymmddHhmmssFormat.parse(str));
		}
	}

	
	public static String BBMMDDthToSlashddmmyyyyyEn(String bbmmdd) throws Exception {
    
		if (bbmmdd == null || bbmmdd.equals("")) {
			return "";
		} else {
		
		String ddmmyyyySlasd =  bbmmdd.substring(4 ,6) +"/"+ bbmmdd.substring(2, 4) +"/"+Integer.toString((Integer.parseInt("25"+bbmmdd.substring(0, 2)) - 543)) ;
		
		return ddmmyyyySlasd;
		
		}
		
	}
	


	/************ dmyFormat to dmyHhmmTH *********************/
	public static String dmyToDay(String str) throws Exception {
		if (str == null || str.equals("")) {
			return "";
		} else {
			return new SimpleDateFormat("dd", new Locale("th", "th"))
					.format(ymdSlashFormat.parse(str));
		}
	}

	public static String dmyToMonthTH(String str) throws Exception {
		if (str == null || str.equals("")) {
			return "";
		} else {
			return monthTH.format(ymdSlashFormat.parse(str));
		}
	}

	public static String dmyToYearTH(String str) throws Exception {
		if (str == null || str.equals("")) {
			return "";
		} else {
			if (Integer.parseInt(str.substring(0, 4)) < 2500) {
				return yearTH.format(ymdSlashFormat.parse(str));
			} else {
				return str;
			}
		}
	}

	public static String dmyToDmyTH(String str) throws Exception {
		if (str == null || str.equals("")) {
			return "";
		} else {
			return dmyThSpace.format(ymdSlashFormat.parse(str));
		}
	}

	public static String YmdTodmy(String d) throws Exception {
		if (d == null || d.equals("")) {
			return "";
		} else {
			return dmyFormat.format(ymdSlashFormat.parse(d));
		}
	}

	public static String joinStringArray(String[] str) throws Exception {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < str.length; i++) {
			result.append(str[i]);
		}
		return result.toString();
	}

	public static String fill(String inStr, String addStr, int strSize,
			boolean prefix) throws Exception {

		String tmpStr;

		if (inStr == null) {
			inStr = "";
		}
		if ((addStr == null) || (addStr.length() == 0))
			throw new NullPointerException("Add String is null");
		else if (inStr.length() > strSize) {
			return inStr.substring(0, strSize);
		}
		if (strSize < 0)
			throw new Exception("Size of string must more than 0.");
		if (strSize == 0)
			return "";
		int addStrSize = strSize - inStr.length();
		int round = (addStrSize / addStr.length());
		tmpStr = "";
		for (int i = 0; i < round; i++) {
			tmpStr += addStr;
		}
		return (prefix ? tmpStr + inStr : inStr + tmpStr);
	}

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static String[] split(String str, String expr) throws Exception {
		String[] result = null;
		boolean flag = false;
		try {
			int chkLastPos = str.lastIndexOf(expr);

			if (str.length() - 1 == chkLastPos) {
				str = str + "$";
				flag = true;
			}
			if (expr != null || expr.equals("|")) {
				expr = "\\|";
			}

			result = str.split(expr);

			if (flag) {
				result[result.length - 1] = "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public static String chkAndConvertDmyToYmd(String date) throws Exception {
		String result = date;
		// if(date.indexOf("/")!=0){
		if (date != null && !date.equals("")) {
			if (date.indexOf("/") == 2) {
				if (date.indexOf(":") >= 0) {
					String[] v = date.split(" ");
					result = StringUtil.dmyToYmd(v[0]) + " " + v[1];
				} else {
					result = StringUtil.dmyToYmd(date);
				}

			}
		}

		return result;
	}

	public static String chkAndConvertYmdToDmy(String date) throws Exception {
		String result = date;
		// if(date.indexOf("/")!=0){
		if (date != null && !date.equals("")) {
			if (date.indexOf("/") == 4) {
				if (date.indexOf(":") >= 0) {
					String[] v = date.split(" ");
					result = StringUtil.ymdSlashToDmy(v[0]) + " " + v[1];
				} else {
					result = StringUtil.ymdSlashToDmy(date);
				}

			}
		}

		return result;
	}

	public static String convertYearTHToEN(String dmy) throws Exception {
		String result = dmy;
		if (Integer.parseInt(dmy.substring(6, 10)) > 2500) {
			result = dmy.substring(0, 6)
					+ (Integer.parseInt(dmy.substring(6, 10)) - 543);
		}
		return result;
	}

	public static int randomNumber(int min, int max) throws Exception {
		Random ran = new Random();
		int range = max - min + 1;
		int result = ran.nextInt(range) + min;
		ran = null;
		return result;
	}
	public static String replaceParam(String str, String[] param){
		str = System.getProperty("line.separator") + str;
		
		StringBuffer tmp = new StringBuffer(str);
		int pos = 0;
		for(int i=0; i<param.length; i++){
			pos = tmp.toString().indexOf("?", pos);
			pos = pos + 1;
			tmp.insert(pos, " /*" + param[i] + "*/");
		}
		return tmp.toString();
	}
	public static String dateToString(String strDate){
		try{
			if(isNotEmpty(strDate)){
				StringBuffer s = new StringBuffer();
				s.append(strDate.substring(0,10));
				return s.toString();
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
	}



	public static String[] getStrArray(String str, String delimiter) {
		StringTokenizer strTokenizer =
				new StringTokenizer(str, delimiter, true);
		String[] tmpArry = null;
		String[] retArry = null;
		int i = 0;
		int arryCount = 0;
		String token = "";
		if (strTokenizer.countTokens() > 0) {
			tmpArry = new String[strTokenizer.countTokens()];
			while (strTokenizer.hasMoreTokens()) {
				token = strTokenizer.nextToken();
				if (token.equals(delimiter)) {
					arryCount++;
				}
				tmpArry[i++] = token;
			}
		}
		if ((arryCount > 0) || (tmpArry != null)) {
			retArry = new String[arryCount + 1];
		}
		if (retArry != null) {
			token = "";
			i = 0;
			int k = 0;
			for (int j = 0; j < tmpArry.length; j++) {
				token = tmpArry[j];
				k++;
				if (token.equals(delimiter)) {
					if (k % 2 == 1) {
						retArry[i++] = "";
						k++;
					}
				} else {
					retArry[i++] = token;
				}
			}
			if (retArry[arryCount] == null) {
				retArry[arryCount] = "";
			}
		}
		return retArry;
	}


	public static void main(String[] args) throws Exception {
		try {
			// SimpleDateFormat spdFormatDMY = new
			// SimpleDateFormat("dd/MM/yyyy", Locale.US);
			// SimpleDateFormat spdFormatYMD = new SimpleDateFormat("yyyyMMdd",
			// Locale.US);
			//
			// Date today = new Date();
			// Date dt = spdFormatDMY.parse("21/03/1983");
			//
			// String dDob = spdFormatYMD.format(dt);
			// String dToday = spdFormatYMD.format(today);
			//
			// String cal = (Integer.parseInt(dToday) -
			// Integer.parseInt(dDob))+"";
			//
			// System.out.println(cal.substring(0,2));

			System.out
					.println(convertYearTHToEN(chkAndConvertYmdToDmy("2526/03/21")));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static Date dateFormat(String strDate){
		try{
			if(isNotEmpty(strDate)){
				Date date = dateFormatter.parse(strDate);
				return date;
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
	}
	

	

}
