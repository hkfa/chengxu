package com.crow.weixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crow.weixin.model.Xinlang;
import com.crow.weixin.service.TitleService;


@RestController
public class XinlangController {
	@Autowired 
	TitleService titleService;
	@RequestMapping("/{id}")
	@ResponseBody
	public Xinlang select(@PathVariable int id){
		Xinlang xinlang=titleService.select(id);
		return xinlang;
	}
	

}
