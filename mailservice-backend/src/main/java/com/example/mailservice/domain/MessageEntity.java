package com.example.mailservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

@Entity
@Table(name = "messages")
public final class MessageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	public String address;
	public String subject;
	public String message;

	private int sent = 0;

	public MessageEntity() {
	}

	public MessageEntity(MessageRequest source) {
		this.address = source.email;
		this.subject = source.subject;
		this.message = source.body;
	}

	public boolean isSent() {
		return sent == 1;
	}

	public void markAsSent() {
		sent = 1;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("address", address).add("subject", subject).toString();
	}

}
