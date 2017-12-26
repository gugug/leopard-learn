package com.duowan.beans.dao.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duowan.beans.dao.SeededDao;
import com.duowan.beans.model.Seeded;
import com.duowan.leopard.data.loader.CacheLoader;

@Repository
public class SeededDaoCacheImpl implements SeededDao {
	
	@Autowired
	private SeededDao seededDaoMysqlImpl;
	
	@Autowired
	private SeededDao seededDaoRedisImpl;

	@Override
	public boolean add(Seeded seeded) {
		return seededDaoMysqlImpl.add(seeded);
	}


	@Override
	public Seeded get(Integer seededId) {
		return CacheLoader.get(seededDaoRedisImpl, seededDaoMysqlImpl, seededId);
	}

	

}

