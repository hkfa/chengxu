package com.crow.weixin.service;


import java.util.ArrayList;
import java.util.List;

import org.ansj.splitWord.analysis.ToAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crow.weixin.domain.TitleWordMapper;
import com.crow.weixin.domain.XinlangMapper;
import com.crow.weixin.model.TitleWord;
import com.crow.weixin.model.Xinlang;
@Service
public class XinlangWordService {
	@Autowired 
	XinlangMapper xinlangmapper;
	@Autowired
	TitleWordMapper titleWordMapper;

	public List<String> insertAllWords(){
		List<Xinlang>results=xinlangmapper.select(4);
		List<String> a=new ArrayList<String>();
		for(Xinlang xinlang:results){
			String content = xinlang.getTitle().replaceAll( "[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]" , ""); 
			String[]strings = ToAnalysis.parse(content).toString().split(",");//分词的结果是用","分隔的
			for(String word:strings){
				TitleWord ti=new TitleWord();
				ti.setWord(word);
				a.add(word);
				titleWordMapper.insert(ti);
			}
		}
		return a;


	}
	/*	public List<TitleWord> getAllWords (Integer selectLimitNum) {
		List<TitleWord> commentWords = titleWordMapper.selectd(selectLimitNum);
		List<TitleWord> titleWordList = new ArrayList<>();
		for(TitleWord tWord: commentWords) {
			if(tWord.getWord().matches("[\\u4e00-\\u9fa5]+/(n|a|vn|ad|b|t)")) {//去掉分词结果中的助词、语气词等
				titleWordList.add(tWord);
			}
		}
		return titleWordList;
	}
*/





}
