package com.duowan.beans.web.controller;

import java.util.Date;
import com.duowan.beans.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = EntryController.DIR)
public class EntryController {
	
	public static final String DIR = "/entry";
	
	@Autowired
	private EntryService entryService;
	
}
