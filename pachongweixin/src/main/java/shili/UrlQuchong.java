package shili;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.MonitorableScheduler;
import us.codecraft.webmagic.scheduler.component.DuplicateRemover;

public class UrlQuchong implements DuplicateRemover{
	private JedisPool jedisPool;
	private static final String item_prefix="item_";
	private static final String queue_prefix="queue_";
	private static final String set_prefix="set_";
	
	public String getSetKey(Task task){
		return set_prefix+task.getUUID();
		
	}
	public String getQueueKey(Task task){
		return queue_prefix+task.getUUID();
	}
	
	

	public int getTotalRequestsCount(Task task) {
		
		return 0;
	}

	public boolean isDuplicate(Request request, Task task) {
		Jedis jedis =jedisPool.getResource();
		String key="set_"+task.getUUID();
		String member=request.getUrl();
		
		boolean isDuplicate=jedis.sismember(key, member);
		if(!isDuplicate){jedis.sadd(key, member);}
		return isDuplicate;
	}

	public void resetDuplicateCheck(Task task) {
		
		
	}


}
 
