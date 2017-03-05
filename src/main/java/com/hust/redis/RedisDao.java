package com.hust.redis;

import java.util.Set;
import redis.clients.jedis.Jedis;

public class RedisDao {

	public static void main(String[] args) {

		//Jedis jedis = new Jedis("120.25.12.92", 6379);
		Jedis jedis = new Jedis("120.55.195.177", 6379);

		jedis.set("yxx", "yxx");
		jedis.set("yexx", "yxx");

		System.out.println("----" + jedis.get("yxx"));

		Set<String> set = jedis.keys("*");

		for (String string : set) {
			System.out.println(string);
		}
	}

}
