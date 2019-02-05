package com.crow.weixin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crow.weixin.model.Xinlang;
import com.crow.weixin.service.TitleService;
import com.crow.weixin.service.XinlangWordService;


@RestController
public class XinlangController {
	@Autowired 
	TitleService titleService;
	@Autowired
	XinlangWordService xinlangWordService;
	@RequestMapping("/hello")
	@ResponseBody
	public List<Xinlang> select(){
		List<Xinlang >result=titleService.select(3);
		return result;
		
	}
	@RequestMapping("/get")
	@ResponseBody
	public List<String> get(){
		return xinlangWordService.insertAllWords();
	}

}
