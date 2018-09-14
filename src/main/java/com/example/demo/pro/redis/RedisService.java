package com.example.demo.pro.redis;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Repository
public class RedisService {
	
	@Autowired
    StringRedisTemplate stringRedisTemplate;

    public void add(String key, User user, Long time) {
        stringRedisTemplate.opsForValue().set(key, JSONObject.toJSONString(user), time, TimeUnit.MINUTES);
    }

    public void add(String key, List<User> users, Long time) {
        String src = JSONObject.toJSONString(users);
        stringRedisTemplate.opsForValue().set(key, src, time, TimeUnit.MINUTES);
    }

    public User get(String key) {
        String source = stringRedisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(source)) {
        	return JSONObject.parseObject(source, User.class);
        }
        return null;
    }

    public List<User> getUserList(String key) {
        String source = stringRedisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(source)) {
        	List<User> users = JSONObject.parseArray(source, User.class);
        	return users;
        }
        return null;
    }

    public void delete(String key) {
        stringRedisTemplate.opsForValue().getOperations().delete(key);
    }

}
