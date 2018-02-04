package app.chat;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface MessageRepository extends CrudRepository<MessageEntity, String> {
    Set<MessageEntity> findByVisitorId(String visitorId);
}
