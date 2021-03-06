package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.User;
import com.springboot.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	 @RequestMapping("/hello")  
     public String index() {  
          return"Hello World";  
     } 
	 
	 
	 @RequestMapping("/get")  
	 @ResponseBody
     public String get(User user) {  
		 User u=userService.getNameById(user);
		 
         return u.toString();    
     }

}
