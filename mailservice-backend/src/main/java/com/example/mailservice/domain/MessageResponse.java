package com.example.mailservice.domain;

public final class MessageResponse {

	public final Long id;
	public final boolean sent;

	public MessageResponse(MessageEntity source) {
		this.id = source.id;
		this.sent = source.isSent();
	}

}
