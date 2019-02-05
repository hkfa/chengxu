package com.crow.weixin.domain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.crow.weixin.model.Xinlang;


@Mapper
public interface XinlangMapper {
				
		@Select({"select title from xinlang where id=#{id}"})
		@Results({@Result(column="title",property="title",id=true)})
		public  Xinlang select(int id);
		

}
