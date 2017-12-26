package com.duowan.beans.web.controller;

import java.util.Date;
import com.duowan.beans.service.GainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = GainController.DIR)
public class GainController {
	
	public static final String DIR = "/gain";
	
	@Autowired
	private GainService gainService;
	
}
