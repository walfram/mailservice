package com.example.mailservice.mail.transport;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.mailservice.domain.MessageEntity;

@Component
public final class DebugMailTransport implements MailTransport {

	private static final Logger logger = LoggerFactory.getLogger(DebugMailTransport.class);

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
