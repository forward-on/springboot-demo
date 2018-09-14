package com.example.demo.pro.kafka;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Message {

	private Long id;
	private String message;
	private LocalDateTime sendTime;
	
}
