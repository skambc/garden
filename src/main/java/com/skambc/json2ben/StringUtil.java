package com.skambc.json2ben;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.text.SimpleDateFormat;

public final class StringUtil {

    private StringUtil() {
        super();
    }

    public static boolean isDigital(String s) {
        return isDigital(s.toCharArray());
    }

    public static boolean isDigital(char[] ca) {
        for (int i = 0; i < ca.length; i++) {
            if (!Character.isDigit(ca[i]))
                return false;
        }
        return true;
    }

    public static String capital(char[] ca) {
        if (null == ca)
            return null;
        ca[0] = Character.toUpperCase(ca[0]);
        for (int i = 1; i < ca.length; i++) {
            ca[i] = Character.toLowerCase(ca[i]);
        }
        return new String(ca);
    }

    public static String capital(String s) {
        if (null == s)
            return null;
        return capital(s.toCharArray());
    }

    public static String[] splitWithSpaces(String s) {
        String[] sa = s.split("\\s+|\\t+");
        return sa;
    }

    public static int countOf(String s, char c) {
        int count = 0;
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] == c) {
                count++;
            }
        }
        return count;
    }

    // public static void replace(String s, String m, String n, int index) {
    // s = s.substring(0, index) + n + s.substring(index + m.length());
    // }

    public static int indexOf(String s, String t, int num) {
        int index = s.indexOf(t);
        if (0 > index || 1 == num) {
            return index;
        }
        for (int i = 1; i < num; i++) {
            index += t.length();
            index = s.indexOf(t, index);
            if (0 > index) {
                break;
            }
        }
        return index;
    }

    public static String formatstrDate(String strdate) {
        if (strdate != null && strdate.length() >= 10) {
            strdate = strdate.substring(0, 4) + "-" + strdate.substring(5, 7) + "-" + strdate.substring(8, 10);
        } else if (strdate != null && strdate.length() == 8) {
            strdate = strdate.substring(0, 4) + "-" + strdate.substring(4, 6) + "-" + strdate.substring(6, 8);
        } else
            strdate = "";
        return strdate;
    }

    public static boolean isDate(String strdate) {

        String regexp = "\\d{4}(.|-|/)\\d{2}(.|-|/)\\d{2}";
        Pattern pattern = Pattern.compile(regexp);
        Matcher m = pattern.matcher(strdate);
        return m.find();
    }


    /*
     * Timestamp转锟斤拷2006-12-14 19:45:09.9003 -12:00
     */
    public static String formatTimestamp(String strdate) {
        if (strdate != null && (strdate.length() < 25 || strdate.split("\\ ").length < 3 )) {
            strdate = "";
        }
        return strdate;
    }

    public static int countOf(String s, String t) {
        int fromIndex = 0;
        int count = 0;
        do {
            fromIndex = s.indexOf(t, fromIndex);
            if (-1 < fromIndex) {
                count++;
                fromIndex += t.length();
            }
        } while (0 < fromIndex && fromIndex < t.length());
        return count;
    }

    /*
     * 锟叫讹拷锟街凤拷锟角凤拷锟斤拷锟斤拷
     */
    public static boolean isNumber(String str) {
        {
            Pattern pattern = Pattern.compile("[0-9,.,-]*");
            Matcher isNum = pattern.matcher(str);
            if (!isNum.matches()) {
                return false;
            }
            return true;
        }

    }

    /**
     * 锟矫碉拷锟斤拷锟饺ｏ拷小锟斤拷锟斤拷锟轿伙拷锟�
     * @param scale
     * @return
     */
    public static String getScale(int scale) {
        StringBuffer bf = new StringBuffer();
        bf.append(".");
        for (int i = 0; i < scale; i++) {
            bf.append("0");
        }
        if (bf.toString().length() == 1)
            return ".0";
        else
            return bf.toString();
    }

    public static boolean isValid(Double d, int precision) {
        boolean flag = false;
        // 锟斤拷证锟斤拷锟斤拷欠锟絥ull
        if (d != null) {
            BigDecimal big = new BigDecimal(d.valueOf(d));
            int cc = big.toString().indexOf(".");
            // System.out.println(big.toString());
            if (cc == -1)
                return true;
            int count = big.toString().substring(cc + 1).length();
            if (count <= precision)
                flag = true;
        }
        return flag;
    }

    public static boolean isValid(String d, int precision) {
        boolean flag = false;
        // 锟斤拷证锟斤拷锟斤拷欠锟絥ull
        if (d != null) {
            int cc = d.indexOf(".");
            if (cc == -1)
                return true;
            int count = d.substring(cc + 1).length();
            if (count <= precision)
                flag = true;
        }
        return flag;
    }

    public static String getLineSeparator() {
        String lineSeparator = null;
        char lineSepCh[] = {(char) 13, (char) 10 };
        lineSeparator = new String(lineSepCh);
        return lineSeparator;
    }

    public static String replaceStr(String inputStr, String oldStr, String newStr) {
        String retutnstr = "";
        int first = inputStr.indexOf(oldStr);
        int last = inputStr.lastIndexOf(oldStr);
        // 锟斤�?锟斤拷^
        if (first != last) {
            retutnstr = inputStr.substring(0, first) + newStr + inputStr.substring(first + 1, last) + newStr;
            if (last < inputStr.length()) {
                retutnstr = retutnstr + inputStr.substring(last + 1);
            }
        } else {// 只锟斤拷�?��斤拷^
            retutnstr = inputStr;
        }
        return retutnstr;
    }

    public static String trim(String str) {
        if (str == null || str.length() == 0)
            return "";
        else {
            return str.trim();
        }
    }

//    public static void main(String[] args) throws Exception {
//        System.err.println("锟斤拷锟斤拷=^te^st^");
//        System.err.println("锟斤拷锟�? + StringUtil.replaceStr("^te^st^", "^", ""));
//        // System.err.println("2006-12-14 19:45:09 12:00="+StringUtil.IsTimestamp("2006-12-14 19:45:09.243 -11:11"));
//    }

    public static String firstCharUpperCase(String str) {
        return str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toUpperCase());
    }

    public static String formatLongNumDate(long utcTime, String fmt) {
        SimpleDateFormat fmter = new SimpleDateFormat(fmt);
        return fmter.format(new Date(utcTime));
    }

    public static String getNowDate() {
        String fmt = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat fmter = new SimpleDateFormat(fmt);
        return fmter.format(new Date());
    }
    public static void main(String[] args) {
    	String fmt = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat fmter = new SimpleDateFormat(fmt);
        System.out.println(fmter.format(new Date(1445331900000l)));
	}
}