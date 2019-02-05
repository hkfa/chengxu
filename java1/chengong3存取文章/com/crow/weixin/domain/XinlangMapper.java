package com.crow.weixin.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.crow.weixin.model.Xinlang;


@Mapper
public interface XinlangMapper {
				
		@Select({"select * from xinlang order by id desc limit #{number}"})
		@Results({@Result(column="title",property="title",id=true)})
		public  List<Xinlang> select(int number);
		

}
