package com.example.mailservice.mail.transport;

import java.util.List;

import com.example.mailservice.domain.MessageEntity;

/**
 * 
 * Implementation might utilize org.springframework.core.task.TaskExecutor
 * 
 * Implementation must use "markAsSent" method of MessageEntity to indicate that this message has been sent
 * 
 */
public interface MailTransport {

	public void sendOne(MessageEntity unsentMessage);

	public void sendBulk(List<MessageEntity> unsentMessages);

}
