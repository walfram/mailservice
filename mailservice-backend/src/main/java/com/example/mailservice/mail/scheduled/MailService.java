package com.example.mailservice.mail.scheduled;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.mailservice.domain.MessageEntity;
import com.example.mailservice.mail.transport.MailTransport;
import com.example.mailservice.repos.MessageRepository;

@Component
public final class MailService {

	private static final Logger logger = LoggerFactory.getLogger(MailService.class);

	private final MessageRepository messageRepository;

	private final MailTransport mailTransport;

	public MailService(MessageRepository messageRepository, MailTransport mailer) {
		this.messageRepository = messageRepository;
		this.mailTransport = mailer;
	}

	@Scheduled(fixedRate = 10 * 1000, initialDelay = 1000)
	public void sendMail() {
		logger.debug("executing mail send");

		List<MessageEntity> unsentMessages = messageRepository.fetchUnsentMessages();
		logger.debug("found unsent messages = {}", unsentMessages.size());

		mailTransport.sendBulk(unsentMessages);

		unsentMessages.forEach(e -> messageRepository.save(e));
	}

}
