package com.risk.common.utils;

import org.apache.commons.lang.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间工具类
 *
 */
public class DateTimeHelper {

    /**
     * 缺省的日期时间显示格式：yyyy-MM-dd HH:mm:ss
     */
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss:SSS";

    /**
     * 日期转换格式：yyyy-MM-dd
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * Date格式化为String 类型"yyyy-MM-dd"
     *
     * @return
     */
    public static String getDateToString(Date date) {
        return DateFormatUtils.format(date, DATE_FORMAT);
    }

    /**
     * 获取当前日期时间
     *
     * @return
     */
    public static String getCurrentDateTime() {
        return DateFormatUtils.format(new Date(), DEFAULT_DATETIME_FORMAT);
    }

    /**
     * 将yyyy-MM-dd类型的字符串格式化为时间
     *
     * @param dateString
     * @return
     */
    public static Date parseDate(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date time = null;
        try {
            time = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 获取redis过期时间
     * <p>指定过期时间为当天的23:59:59<p/>
     *
     * @return
     */
    public static Date getRedisExpireTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        //获取当天的日期，不包含时间
        String dateStr = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
        try {
            time = sdf.parse(dateStr + " 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 获取当前unix时间戳
     *
     * @return
     */
    public static int getCurrentUnixTimeStamp() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static int getZhiDingUnixTimeStamp(Date date) {
        return (int) (date.getTime() / 1000);
    }

    public static int getEndTime(String end) {
        if ("-1".equals(end)) {
            return Integer.parseInt(end);
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(parseDate(end));
            return getZhiDingUnixTimeStamp(cal.getTime()) + 24 * 3600 - 1;
        }
    }

    public static int getStartTime(String start) {
        if ("-1".equals(start)) {
            return Integer.parseInt(start);
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(parseDate(start));
            return getZhiDingUnixTimeStamp(cal.getTime());
        }
    }

    /**
     * 获取当前日期前一天
     * */
    public static String getBeforeDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();

        return getDateToString(date);
    }
    /**
     * 10位时间转为8时间
     * @param str
     * @return
     */
    public static String getDate10to8(String str) {
        String y = str.substring(0, 4);
        String m = str.substring(5, 7);
        String d = str.substring(8, 10);
        return y + m + d;
    }
    /**
     * 日期转化为字符串
     * @param date 时间
     * @return yyyy-MM-dd HH:mm:ss 格式化的时间字符串
     */
    public static String dateToString(Date date) {
        if (date == null)
            return "";
        return FormatDate(date, "yyyy-MM-dd HH:mm:ss");
    }
    /**
     * 对日期进行格式化
     * @param date 日期
     * @param sf 日期格式
     * @return 字符串
     */
    public static String FormatDate(Date date, String sf) {
        if (date == null)
            return "";
        SimpleDateFormat dateformat = new SimpleDateFormat(sf);
        return dateformat.format(date);
    }

    public static void  main(String args[]){
        System.out.println(DateTimeHelper.getZhiDingUnixTimeStamp(new Date(2015,06,26)));
    }

}
