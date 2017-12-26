package com.duowan.beans.util.datetime;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by gucailiang on 2017/12/26.
 */
public class DTUtil {
    public static Date getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 0, 0, 0);
        return calendar.getTime();
    }

    public static Date getEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 23, 59, 59);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        Date today = new Date();
        System.out.println(today);
        Date startOfDay = DTUtil.getStartOfDay(today);
        System.out.println(startOfDay);
    }
}
