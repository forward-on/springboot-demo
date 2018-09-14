package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.pro.kafka.KafkaProducer;
import com.example.demo.pro.kafka.KafkaReceiver;

@RunWith(SpringRunner.class)
@Component
@SpringBootTest(classes = Demo2Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KafkaTest {
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@Test
	public void kafkaTest() {
		
		for (int i = 0; i < 10; i++) {
			kafkaProducer.produce();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
