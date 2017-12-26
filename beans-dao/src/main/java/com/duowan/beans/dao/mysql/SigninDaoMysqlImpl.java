package com.duowan.beans.dao.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.duowan.beans.dao.SigninDao;
import com.duowan.beans.model.Signin;
import com.duowan.leopard.data.jdbc.Jdbc;
import com.duowan.leopard.data.jdbc.builder.InsertBuilder;

import java.util.Date;
import java.util.List;

@Repository
public class SigninDaoMysqlImpl implements SigninDao {

	@Autowired
	private Jdbc jdbc;

	@Override
	public boolean add(Signin signin) {
		throw new NotImplementedException();
	}

	@Override
	public Signin get(Double signinId) {
		throw new NotImplementedException();
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

