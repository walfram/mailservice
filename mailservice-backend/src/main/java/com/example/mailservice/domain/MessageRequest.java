package com.example.mailservice.domain;

import com.google.common.base.MoreObjects;

public final class MessageRequest {

	public final String email;
	public final String subject;
	public final String body;

	public MessageRequest(String email, String subject, String body) {
		this.email = email;
		this.subject = subject;
		this.body = body;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("email", email).add("subject", subject).add("body", body).toString();
	}

}
