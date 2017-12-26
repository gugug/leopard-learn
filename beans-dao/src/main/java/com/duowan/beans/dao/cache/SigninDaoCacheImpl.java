package com.duowan.beans.dao.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duowan.beans.dao.SigninDao;
import com.duowan.beans.model.Signin;
import com.duowan.leopard.data.loader.CacheLoader;

import java.util.Date;
import java.util.List;

@Repository
public class SigninDaoCacheImpl implements SigninDao {
	
	@Autowired
	private SigninDao signinDaoMysqlImpl;
	
	@Autowired
	private SigninDao signinDaoRedisImpl;

	@Override
	public boolean add(Signin signin) {
		return signinDaoMysqlImpl.add(signin);
	}


	@Override
	public Signin get(Double signinId) {
		return CacheLoader.get(signinDaoRedisImpl, signinDaoMysqlImpl, signinId);
	}

	@Override
	public List<Signin> list(Date date) {
		return null;
	}

	@Override
	public boolean deleteBefore(Date startTime) {
		return false;
	}


}

