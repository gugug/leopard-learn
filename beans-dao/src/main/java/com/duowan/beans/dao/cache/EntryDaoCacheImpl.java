package com.duowan.beans.dao.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duowan.beans.dao.EntryDao;
import com.duowan.beans.model.Entry;
import com.duowan.leopard.data.loader.CacheLoader;

@Repository
public class EntryDaoCacheImpl implements EntryDao {
	
	@Autowired
	private EntryDao entryDaoMysqlImpl;
	
	@Autowired
	private EntryDao entryDaoRedisImpl;

	@Override
	public boolean add(Entry entry) {
		return entryDaoMysqlImpl.add(entry);
	}


	@Override
	public Entry get(Integer entryId) {
		return CacheLoader.get(entryDaoRedisImpl, entryDaoMysqlImpl, entryId);
	}

	

}

