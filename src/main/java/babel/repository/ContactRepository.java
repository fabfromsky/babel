package babel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import babel.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{
	
}
