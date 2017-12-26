package com.duowan.beans.dao.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.duowan.beans.dao.SeededDao;
import com.duowan.beans.model.Seeded;
import com.duowan.leopard.data.jdbc.Jdbc;
import com.duowan.leopard.data.jdbc.builder.InsertBuilder;

@Repository
public class SeededDaoMysqlImpl implements SeededDao {

	@Autowired
	private Jdbc jdbc;

	@Override
	public boolean add(Seeded seeded) {
		throw new NotImplementedException();
	}

	@Override
	public Seeded get(Integer seededId) {
		throw new NotImplementedException();
	}

}

