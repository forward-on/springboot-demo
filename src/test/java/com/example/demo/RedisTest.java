package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.pro.redis.RedisService;
import com.example.demo.pro.redis.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {
	
	private static Logger logger = LoggerFactory.getLogger(RedisTest.class);
	
	@Autowired
	private RedisService redisService;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void redisTest() {
		String key = "first";
		User user = redisService.get(key);
		if (user == null) {
			user = new User();
			user.setAge(33);
			user.setName("haha");
			redisService.add(key, user, 1L);
			System.out.println("没有找到用户，设置了一个新的用户，user---" + user.toString());
		}
		logger.info("get user:" + user.toString());
		
		redisService.delete(key);
		
		User user2 = redisService.get(key);
		if (user2 == null) {
			logger.info("get user again : 未找到用户...");
		}
		System.out.println("***********");
		
	}

}
