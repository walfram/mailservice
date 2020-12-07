package com.example.mailservice.domain;

import com.google.common.base.MoreObjects;

public final class MessageRequest {

	public String email;
	public String subject;
	public String body;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("email", email).add("subject", subject).add("body", body).toString();
	}

}
