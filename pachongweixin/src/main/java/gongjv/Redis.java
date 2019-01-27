package gongjv;

import redis.clients.jedis.Jedis;

public class Redis {
	private String myIP="127.0.0.1";
	private String myPort="6379";
	public static void main(String []args){
		Jedis jedis=new Jedis("localhost");
		String a=jedis.ping();
		System.out.println(a);
	}

}
