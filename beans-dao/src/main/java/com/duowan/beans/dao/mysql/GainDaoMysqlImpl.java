package com.duowan.beans.dao.mysql;

import com.duowan.beans.dao.GainDao;
import com.duowan.beans.model.Gain;
import com.duowan.leopard.data.jdbc.Jdbc;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GainDaoMysqlImpl implements GainDao {

	@Autowired
	private Jdbc jdbc;

	@Override
	public boolean add(Gain gain) {
		throw new NotImplementedException();
	}

	@Override
	public Gain get(Double gainId) {
		throw new NotImplementedException();
	}

}

