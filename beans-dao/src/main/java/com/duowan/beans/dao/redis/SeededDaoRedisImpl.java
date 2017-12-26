package com.duowan.beans.dao.redis;

import javax.annotation.Resource;

import com.duowan.beans.dao.SeededDao;
import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import com.duowan.beans.model.Seeded;
import com.duowan.leopard.data.redis.Redis;
import com.duowan.leopard.json.Json;

@Repository
public class SeededDaoRedisImpl implements SeededDao {

	@Resource(name = "redis")
	private Redis redis;

	@Override
	public boolean add(Seeded Seeded) {			
		throw new NotImplementedException();
	}

	@Override
	public Seeded get(Integer SeededId) {		
		throw new NotImplementedException();
	}
	
}

