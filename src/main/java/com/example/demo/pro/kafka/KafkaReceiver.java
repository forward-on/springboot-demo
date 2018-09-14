package com.example.demo.pro.kafka;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaReceiver {

	@KafkaListener(topics = {"Y.S.K"})
	public void listen(ConsumerRecord<?, ?> consumerRecord) {
		Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord);
		if (kafkaMessage.isPresent()) {
			Object message = kafkaMessage.get();
			log.info("********* record = " + consumerRecord);
			log.info("********* message = " + message);
		}
	}
	
}
