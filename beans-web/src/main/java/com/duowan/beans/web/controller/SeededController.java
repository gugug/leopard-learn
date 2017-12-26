package com.duowan.beans.web.controller;

import java.util.Date;
import com.duowan.beans.service.SeededService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = SeededController.DIR)
public class SeededController {
	
	public static final String DIR = "/seeded";
	
	@Autowired
	private SeededService seededService;
	
}
