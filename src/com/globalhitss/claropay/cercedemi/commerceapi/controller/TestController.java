package com.globalhitss.claropay.cercedemi.commerceapi.controller;


import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalhitss.claropay.cercedemi.commerceapi.model.Test;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/test")
public class TestController
{

	@GetMapping("/all-data")
	public List<Test> consultar()
	{	
		List<Test> rows = new LinkedList<Test>();
		
		rows.add(new Test("Hola mundo"));
		rows.add(new Test("Hola mundo 2"));
		
	    return rows;
	}
}