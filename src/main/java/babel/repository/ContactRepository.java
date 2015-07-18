package babel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babel.entity.Contact;
import babel.entity.User;

public interface ContactRepository extends JpaRepository<Contact, Long>{

	List<Contact> findByContact(User user);

	List<Contact> findByUser(User user);
	
}
