package com.duowan.beans.dao;

import com.duowan.beans.model.Entry;
import com.duowan.leopard.data.api.IGet;

public interface EntryDao extends IGet<Entry, Integer> {
	

	boolean add(Entry entry);
	
	

	Entry get(Integer entryId);

	
	
	 
}
