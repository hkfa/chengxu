package com.springboot.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


import com.springboot.model.Xinlang;



	@Mapper
	public interface UserDao {
		@Insert ("insert  into xinlang(title) value(#{title})")
		public  void insert(Xinlang xinlang) ;
			
			
		
		
	}


