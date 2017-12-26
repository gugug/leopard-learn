package com.duowan.beans.dao;

import com.duowan.beans.model.Seeded;
import com.duowan.leopard.data.api.IGet;

public interface SeededDao extends IGet<Seeded, Integer> {
	

	boolean add(Seeded seeded);
	
	

	Seeded get(Integer seededId);

	
	
	 
}
