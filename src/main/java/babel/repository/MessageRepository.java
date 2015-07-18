package babel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babel.entity.Message;
import babel.entity.User;

public interface MessageRepository extends JpaRepository<Message, Long>{
	
	public List<Message> findAll();

	public List<Message> findBySender(User sender);
	
	public List<Message> findByReceiver(User receiver);

	public List<Message> findByReceiverOrSenderOrderByMessageIdDesc(
			User user, User user2);
}
