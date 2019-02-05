package com.springboot.dao;


import org.apache.ibatis.annotations.Mapper;

import com.springboot.model.User;


	@Mapper
	public interface UserDao {
		
		public User getNameById(User user);
		
	}


