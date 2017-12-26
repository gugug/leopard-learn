package com.duowan.beans.dao.redis;

import javax.annotation.Resource;

import com.duowan.beans.dao.GainDao;
import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import com.duowan.beans.model.Gain;
import com.duowan.leopard.data.redis.Redis;
import com.duowan.leopard.json.Json;

@Repository
	public class GainDaoRedisImpl implements GainDao {

	@Resource(name = "redis")
	private Redis redis;

	@Override
	public boolean add(Gain Gain) {			
		throw new NotImplementedException();
	}

	@Override
	public Gain get(Double GainId) {
		throw new NotImplementedException();
	}
	
}

