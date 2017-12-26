package com.duowan.beans.dao.redis;

import javax.annotation.Resource;

import com.duowan.beans.dao.SigninDao;
import com.duowan.beans.util.RedisKey;
import com.duowan.beans.util.Signin.SigninUtil;
import com.duowan.leopard.commons.utility.NumberUtil;
import com.duowan.leopard.commons.utility.SetUtil;
import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import com.duowan.beans.model.Signin;
import com.duowan.leopard.data.redis.Redis;
import com.duowan.leopard.json.Json;
import redis.clients.jedis.Tuple;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public class SigninDaoRedisImpl implements SigninDao {

    //引入redis数据源，这里的数据源来自spring配置文件定义的bean
    @Resource(name = "redis")
    private Redis redis;

    @Override
    public boolean add(Signin signin) {
        //getMonthSignin定义了存储签到数据的key,形如：z_signin_20140607
        Date now = new Date();
        String key = RedisKey.getMonthSignin(now);
        String member = String.valueOf(signin.getYyuid());
        //getScore 用当前时间的前面表示日期，乘以1000得到的数字的后三位表示连续签到天数。
        long score = SigninUtil.getScore(signin.getPostTime(), signin.getDays());
        Long num = this.redis.zadd(key, score, member);
        return NumberUtil.isNotNull(num);
    }


    @Override
    public Signin get(Double yyuid) {
        Date now = new Date();
        String key = RedisKey.getMonthSignin(now);
        String member = yyuid.toString();
        Double score = this.redis.zscore(key, member);
        return SigninUtil.toSignin(yyuid, score);

    }

    @Override
    public List<Signin> list(Date date) {
        String key = RedisKey.getMonthSignin(date);
        //获取一天的所有签到数据
        Set<Tuple> set = this.redis.zrangeWithScores(key, 0, -1);
        set = SetUtil.defaultSet(set);
        return SigninUtil.tupleToSigninList(set);
    }

    @Override
    public boolean deleteBefore(Date startTime) {
        String key = RedisKey.getMonthSignin(startTime);
        // 当天24点启动定时器时，获取连续签到天数为零的，进行删除。
        long score = SigninUtil.getScore(startTime, 0);
        long num = this.redis.zremrangeByScore(key, 0, score);
        return NumberUtil.toBool(num);
    }

}

