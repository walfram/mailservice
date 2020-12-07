package com.example.mailservice.scheduled;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.mailservice.domain.MessageEntity;
import com.example.mailservice.mailer.Mailer;
import com.example.mailservice.repos.MessageRepository;

@Component
public final class MailService {

	private static final Logger logger = LoggerFactory.getLogger(MailService.class);

	private final MessageRepository messageRepository;

	private final Mailer mailer;

	public MailService(MessageRepository messageRepository, Mailer mailer) {
		this.messageRepository = messageRepository;
		this.mailer = mailer;
	}

	@Scheduled(fixedRate = 10 * 1000, initialDelay = 1000)
	public void sendMail() {
		logger.debug("executing mail send");

		List<MessageEntity> unsentMessages = messageRepository.fetchUnsentMessages();
		logger.debug("found unsent messages = {}", unsentMessages.size());

		mailer.sendBulk(unsentMessages);

		unsentMessages.forEach(e -> messageRepository.save(e));
	}

}
