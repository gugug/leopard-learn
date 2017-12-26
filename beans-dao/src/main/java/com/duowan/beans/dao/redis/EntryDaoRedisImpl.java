package com.duowan.beans.dao.redis;

import com.duowan.beans.dao.EntryDao;
import com.duowan.beans.model.Entry;
import com.duowan.leopard.data.redis.Redis;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class EntryDaoRedisImpl implements EntryDao {

	@Resource(name = "redis")
	private Redis redis;

	@Override
	public boolean add(Entry Entry) {			
		throw new NotImplementedException();
	}

	@Override
	public Entry get(Integer EntryId) {		
		throw new NotImplementedException();
	}
	
}

