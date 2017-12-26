package com.duowan.beans.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duowan.beans.dao.EntryDao;
import com.duowan.beans.model.Entry;
import com.duowan.beans.service.EntryService;


@Service
public class EntryServiceImpl implements EntryService{
	
	@Autowired
	private EntryDao entryDao;

	@Override
	public boolean add(Entry entry) {
		return entryDao.add(entry);
	}

	@Override
	public Entry get(int entryId) {	
		return entryDao.get(entryId);		
	}

	
}

