package com.crow.weixin.domain;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.crow.weixin.model.TitleWord;

@Mapper
public interface TitleWordMapper {
	@Insert("insert into xinlangword(word) value (#{word})")
	
	public void insert(TitleWord titleWord);
	

}
