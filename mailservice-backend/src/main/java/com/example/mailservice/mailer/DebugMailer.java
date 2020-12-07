package com.example.mailservice.mailer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.mailservice.domain.MessageEntity;

@Component
public final class DebugMailer implements Mailer {

	private static final Logger logger = LoggerFactory.getLogger(DebugMailer.class);

	@Override
	public void sendOne(MessageEntity messageEntity) {
		logger.debug("sending mail to {}", messageEntity.address);
		messageEntity.markAsSent();
	}

	@Override
	public void sendBulk(List<MessageEntity> unsentMessages) {
		unsentMessages.forEach(me -> sendOne(me));
	}

}
