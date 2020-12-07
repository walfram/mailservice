package com.example.mailservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.mailservice.domain.MessageEntity;
import com.example.mailservice.domain.MessageRequest;
import com.example.mailservice.domain.MessageResponse;
import com.example.mailservice.repos.MessageRepository;

@Component
public final class MessageService {

	private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

	private final MessageRepository messageRepository;

	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public MessageEntity process(MessageRequest message) {
		logger.debug("saving message = {}", message);
		return messageRepository.save(new MessageEntity(message));
	}

	public List<MessageResponse> allMessages() {
		return messageRepository.findAll().stream().map(me -> new MessageResponse(me)).collect(Collectors.toList());
	}

}
