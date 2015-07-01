package babel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babel.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{
	
	public List<Message> findAll();

	public List<Message> findBySender(String sender);
	
	public List<Message> findByReceiver(String receiver);

	public List<Message> findByReceiverOrSenderOrderByMessageIdDesc(
			String username, String username2);
}
