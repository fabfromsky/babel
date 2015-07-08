package babel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import babel.entity.Contact;
import babel.repository.ContactRepository;

@RestController
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepo;
	
	/**
	 * add a contact to user's list
	 * @param contact
	 */
	@RequestMapping(value="/user/contact/add", method = RequestMethod.POST)
	public void addContact(@RequestBody Contact contact){
		contactRepo.save(contact);
	}
}
