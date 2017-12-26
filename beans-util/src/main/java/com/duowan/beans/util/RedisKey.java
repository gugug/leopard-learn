package com.duowan.beans.util;

import com.duowan.beans.util.datetime.DTFormat;

import java.util.Date;

/**
 * Redis key管理.
 * 
 * @author 阿海
 * 
 */
public class RedisKey {

	public static String getMonthSignin(Date date) {
		String shortDate = DTFormat.shortDate(date);
		return "z_signin_" + shortDate;
	}
}
