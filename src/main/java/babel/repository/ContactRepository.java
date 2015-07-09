package babel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babel.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

	List<Contact> findByContact(String username);

	List<Contact> findByUser(String username);
	
}
