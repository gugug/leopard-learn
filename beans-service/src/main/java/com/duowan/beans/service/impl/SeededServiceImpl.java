package com.duowan.beans.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duowan.beans.dao.SeededDao;
import com.duowan.beans.model.Seeded;
import com.duowan.beans.service.SeededService;


@Service
public class SeededServiceImpl implements SeededService{
	
	@Autowired
	private SeededDao seededDao;

	@Override
	public boolean add(Seeded seeded) {
		return seededDao.add(seeded);
	}

	@Override
	public Seeded get(int seededId) {	
		return seededDao.get(seededId);		
	}

	
}

