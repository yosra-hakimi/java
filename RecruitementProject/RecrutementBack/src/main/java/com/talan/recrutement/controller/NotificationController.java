package com.talan.recrutement.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.talan.recrutement.service.NotificationService;
import com.talan.recrutement.service.impl.NotificationServiceImpl;

@RestController
public class NotificationController {

	@Autowired
	NotificationServiceImpl notificationService;

	private Logger logger = LoggerFactory.getLogger(NotificationController.class);

	@PostMapping("/meeting")
	public String meeting(@RequestBody Map<String, String> mail) {

		try {
			notificationService.sendNotification(mail.get("receiver"), mail.get("subject"), mail.get("text"));
		} catch (MailException e) {
			logger.info("Error sending Email :" + e.getMessage());
		}

		return "mail of meeting was sended";
	}

}
