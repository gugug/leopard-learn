package com.duowan.beans.dao.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duowan.beans.dao.GainDao;
import com.duowan.beans.model.Gain;
import com.duowan.leopard.data.loader.CacheLoader;

@Repository
public class GainDaoCacheImpl implements GainDao {

    @Autowired
    private GainDao gainDaoMysqlImpl;

    @Autowired
    private GainDao gainDaoRedisImpl;

    @Override
    public boolean add(Gain gain) {
        return gainDaoMysqlImpl.add(gain);
    }
    
    @Override
    public Gain get(Double gainId) {
        return CacheLoader.get(gainDaoRedisImpl, gainDaoMysqlImpl, gainId);
    }

}

