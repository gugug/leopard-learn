package com.duowan.beans.util.Signin;

import com.duowan.beans.model.Signin;
import com.duowan.beans.util.datetime.DTUtil;
import com.duowan.leopard.commons.utility.DateUtil;
import com.duowan.leopard.commons.utility.NumberUtil;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by gucailiang on 2017/12/26.
 */
public class SigninUtil {
    private static long MULTIPLY_1000 = 1000L;

    //拼接日期和连续签到天数，得到score值
    public static long getScore(Date date, int days) {
        long score = DateUtil.getSecond(date);
        return score * MULTIPLY_1000 + days;
    }

    //由score值得到连续签到天数
    public static int getDays(Double score) {
        int days = (int) (score % MULTIPLY_1000);
        return days;
    }

    //由score值得到最后一次签到的日期
    public static Date getLmodify(Double score) {
        long seconds = (long) (score / MULTIPLY_1000);
        return DateUtil.toDate(seconds * MULTIPLY_1000);
    }

    //封装成Signin对象
    public static Signin toSignin(double yyuid, Double score) {
        score = score == null ? 0 : score;
        Signin signin = new Signin();
        signin.setYyuid(yyuid);
        int days = getDays(score);
        signin.setDays(days);
        Date lmodify = getLmodify(score);
        lmodify = DateUtil.defaultDate(lmodify, 0);
        signin.setPostTime(lmodify);
        return signin;
    }

    public static List<Signin> tupleToSigninList(Set<Tuple> set) {
        List<Signin> list = new ArrayList<Signin>();
        for (Tuple tuple : set) {
            long yyuid = NumberUtil.toLong(Long.parseLong(tuple.getElement()));
            double score = tuple.getScore();
            Signin signin = toSignin(yyuid, score);
            list.add(signin);
        }
        return list;
    }

    //从上次签到日期开始推算, 到当月月初的最大连续签到天数
    public static int getLastContinuesDays(int lastSigninDate, int[] days) {
        int length = days.length;
        if (length <= 0) {
            return 0;
        }
        if (days[length - 1] != lastSigninDate) {
            return 0;
        }
        int count = 1;
        for (int i = length - 2; i >= 0; i--) {
            if ((days[i] + 1) == days[i + 1]) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    //判断今天是否签到
    public static boolean isSigned(Signin signin) {
        Date today = new Date();
        Date todayStartTime = DTUtil.getStartOfDay(today);
        return DateUtil.before(todayStartTime, signin.getPostTime());
    }




}
