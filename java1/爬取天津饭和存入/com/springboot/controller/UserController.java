package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.UserDao;
import com.springboot.model.User;
import com.springboot.service.UserService;
import com.springboot.webmagic.MyPipeline;
import com.springboot.webmagic.PageProcessors;

import us.codecraft.webmagic.Spider;

@RestController
public class UserController {
	
	@Autowired
	MyPipeline myPipeline;
	
	
	/* @RequestMapping("/hello")  
     public String index() {  
          return"Hello World";  
     } 
	 
	 */
	 
	 @GetMapping("/get")  

     public String get() {  
			Spider.create(new PageProcessors())
			.addUrl("http://blog.sina.com.cn/s/articlelist_1487828712_0_1.html")
			.addPipeline(myPipeline)
			.thread(1)
			.run();
			return "Pachong Start";
		       
     }

}
