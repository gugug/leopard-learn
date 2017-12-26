package com.duowan.beans.util.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhuangjiaxin@yy.com created on 2015-01-10
 */
public class DTFormat {

    private static final String DATETIME = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE = "yyyy-MM-dd";
    private static final String SHORT_DATE = "yyyyMMdd";
    private static final String TIME = "HH:mm:ss";

    /////datetime

    public static String datetime(Date date) {
        return new SimpleDateFormat(DATETIME).format(date);
    }

    public static String currentDatetime() {
        return datetime(new Date());
    }

    /////date

    public static String date(Date date) {
        return new SimpleDateFormat(DATE).format(date);
    }

    public static String currentDate() {
        return date(new Date());
    }

    /////short date

    public static String shortDate(Date date) {
        return new SimpleDateFormat(SHORT_DATE).format(date);
    }

    public static String currentShortDate() {
        return shortDate(new Date());
    }

    ////time

    public static String time(Date date) {
        return new SimpleDateFormat(TIME).format(date);
    }

    public static String currentTime() {
        return time(new Date());
    }

}
