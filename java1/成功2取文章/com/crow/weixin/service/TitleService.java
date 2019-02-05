package com.crow.weixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crow.weixin.domain.XinlangMapper;
import com.crow.weixin.model.Xinlang;

@Service
public class TitleService {
	@Autowired
	XinlangMapper xinlangMapper;
	public Xinlang select(int id){
		return xinlangMapper.select(id);
	}
 
}
