package com.duowan.beans.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duowan.beans.dao.GainDao;
import com.duowan.beans.model.Gain;
import com.duowan.beans.service.GainService;


@Service
public class GainServiceImpl implements GainService{
	
	@Autowired
	private GainDao gainDao;

	@Override
	public boolean add(Gain gain) {
		return gainDao.add(gain);
	}

	@Override
	public Gain get(double gainId) {
		return gainDao.get(gainId);		
	}

	
}

