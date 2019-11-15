package com.talan.recrutement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talan.recrutement.persistence.entity.CandidateEntity;
import com.talan.recrutement.persistence.entity.UserEntity;
import com.talan.recrutement.service.NotificationService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class NotificationServiceImpl  {

	private JavaMailSender javaMailSender;

	@Autowired
	public NotificationServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendNotification(String receiver,String subject,String text) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(receiver);		
		mail.setFrom("Talanrecrutement@gmail.com");
		mail.setSubject(subject);
		mail.setText(text);
	

		javaMailSender.send(mail);

	}
}
