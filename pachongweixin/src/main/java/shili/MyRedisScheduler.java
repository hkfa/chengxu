package shili;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.MonitorableScheduler;

public class MyRedisScheduler implements MonitorableScheduler {
	private JedisPool jedisPool;
	
	MyRedisScheduler (String host){
		JedisPoolConfig config=new JedisPoolConfig();
		JedisPool jedisPool=new JedisPool(config,host);
		System.out.println("fad");
	}
	MyRedisScheduler (JedisPool jedisPool){
		this.jedisPool=jedisPool;
	}

	

	public Request poll(Task arg0) {

		return null;
	}

	public void push(Request request, Task task) {
		Jedis jedis=jedisPool.getResource();
		
		
		
		jedis.rpush( request.getUrl());


	}

	public int getLeftRequestsCount(Task arg0) {

		return 0;
	}

	public int getTotalRequestsCount(Task arg0) {

		return 0;
	}





}
