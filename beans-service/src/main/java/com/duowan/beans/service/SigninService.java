package com.duowan.beans.service;



import com.duowan.beans.model.Signin;

import java.util.Date;

public interface SigninService {

	//新增（更新）
	public boolean add(Signin signin);

	//获取签到对象
	public Signin get(double signinId);

	//删除指定时间之前的对象
	public boolean deleteBefore(Date startTime);

}

