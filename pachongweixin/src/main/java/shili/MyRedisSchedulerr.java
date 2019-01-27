package shili;

import redis.clients.jedis.JedisPool;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.DuplicateRemovedScheduler;
import us.codecraft.webmagic.scheduler.MonitorableScheduler;
import us.codecraft.webmagic.scheduler.component.DuplicateRemover;

public class MyRedisSchedulerr {
    private JedisPool jedisPool;
    public void getStringKey(Task task){
    	String a=task.getUUID();
    	System.out.println(a);
    }
	public Request poll(Task arg0) {
		
		return null;
	}

	public void push(Request arg0, Task arg1) {
		
	}

	public boolean isDuplicate(Request arg0, Task arg1) {
	
		return false;
	}

	public void resetDuplicateCheck(Task arg0) {
		
		
	}

	public int getLeftRequestsCount(Task arg0) {
		
		return 0;
	}

	public int getTotalRequestsCount(Task arg0) {
		
		return 0;
	}

}
