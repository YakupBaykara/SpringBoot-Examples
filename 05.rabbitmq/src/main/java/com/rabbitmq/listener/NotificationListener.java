package com.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.entity.Notification;

@Service
public class NotificationListener {
	
	@RabbitListener(queues = "rabbit_queue")   // application.properties dosyasındaki isim
	public void handleMessage(Notification notification) {
		System.out.println("Message received!");
		System.out.println(notification.toString());
	}

}
