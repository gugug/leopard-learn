package com.duowan.beans.dao;

import com.duowan.beans.model.Signin;
import com.duowan.leopard.data.api.IGet;

import java.util.Date;
import java.util.List;

public interface SigninDao extends IGet<Signin, Double> {

    //签到
    boolean add(Signin signin);

    //获取签到，用于验证今天是否已签到。一天只能签到一次。
    Signin get(Double signinId);

    //查询签到列表
    List<Signin> list(Date date);

    //删除指定时间之前的签到对象
    boolean deleteBefore(Date startTime);

}
