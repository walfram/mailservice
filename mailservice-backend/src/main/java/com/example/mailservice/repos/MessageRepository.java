package com.example.mailservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.mailservice.domain.MessageEntity;

public interface MessageRepository extends CrudRepository<MessageEntity, Long> {

	@Query(value = "select * from messages m where m.sent = 0", nativeQuery = true)
	List<MessageEntity> fetchUnsentMessages();

	List<MessageEntity> findAll();

}
