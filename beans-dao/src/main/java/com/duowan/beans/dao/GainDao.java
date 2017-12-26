package com.duowan.beans.dao;

import com.duowan.beans.model.Gain;
import com.duowan.leopard.data.api.IGet;

public interface GainDao extends IGet<Gain, Double> {
	

	boolean add(Gain gain);
	
	

	Gain get(Double gainId);

	
	
	 
}
