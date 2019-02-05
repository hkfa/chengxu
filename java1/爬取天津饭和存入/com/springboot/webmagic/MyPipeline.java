package com.springboot.webmagic;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springboot.dao.UserDao;

import com.springboot.model.Xinlang;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Service
//@Component("PostInfoPipeline")
public class MyPipeline implements Pipeline{
	@Autowired
	UserDao userDao;
	@Override
	public void process(ResultItems resultItems, Task task) {
		for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {							
			if(entry.getKey().equals("xinlang")) {
				Xinlang xinlang = (Xinlang) entry.getValue();
				if(xinlang != null) {
					userDao.insert(xinlang);
				}

			}

		}
	}
}




//System.out.println(entry.getKey() + "  -------------------->  " + entry.getValue());
