package com.example.mailservice.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mailservice.domain.MessageEntity;
import com.example.mailservice.domain.MessageRequest;
import com.example.mailservice.domain.MessageResponse;
import com.example.mailservice.services.MessageService;

@RestController
@RequestMapping(path = "/api/message")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:3000" })
public final class MessageEndpoint {

	private static final Logger logger = LoggerFactory.getLogger(MessageEndpoint.class);
	private final MessageService messageService;

	public MessageEndpoint(MessageService mailService) {
		this.messageService = mailService;
	}

	@PostMapping
	public ResponseEntity<?> saveMessage(@RequestBody MessageRequest message) {
		logger.debug("received message = {}", message);
		MessageEntity saved = messageService.process(message);
		logger.debug("saved message = {}", saved);
		return new ResponseEntity<>(saved, HttpStatus.OK);
	}

	@GetMapping
	public List<MessageResponse> allMessages() {
		return messageService.allMessages();
	}

}
