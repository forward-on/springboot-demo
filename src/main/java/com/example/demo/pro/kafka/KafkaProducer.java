package com.example.demo.pro.kafka;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void produce() {
		Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMessage(UUID.randomUUID().toString());
        message.setSendTime(LocalDateTime.now());
        String msg = JSONObject.toJSONString(message);
        log.info("+++++++++++++++++++++  message = {}", msg);
        kafkaTemplate.send("Y.S.K", msg);
	}

}
