package com.crow.weixin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crow.weixin.domain.XinlangMapper;
import com.crow.weixin.model.Xinlang;

@Service
public class TitleService {
	@Autowired
	XinlangMapper xinlangMapper;
	public List<Xinlang> select(int number){
		return xinlangMapper.select(number);
	}
 
}
