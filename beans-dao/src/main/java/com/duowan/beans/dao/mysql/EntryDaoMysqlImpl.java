package com.duowan.beans.dao.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.duowan.beans.dao.EntryDao;
import com.duowan.beans.model.Entry;
import com.duowan.leopard.data.jdbc.Jdbc;
import com.duowan.leopard.data.jdbc.builder.InsertBuilder;

@Repository
public class EntryDaoMysqlImpl implements EntryDao {

	@Autowired
	private Jdbc jdbc;

	@Override
	public boolean add(Entry entry) {
		throw new NotImplementedException();
	}

	@Override
	public Entry get(Integer entryId) {
		throw new NotImplementedException();
	}

}

