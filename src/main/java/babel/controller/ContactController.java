package babel.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import babel.entity.Contact;
import babel.entity.User;
import babel.repository.ContactRepository;
import babel.repository.UserRepository;

@RestController
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	/**
	 * find user's that added you as contact
	 * @param username
	 * @return list of users
	 */
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	protected Set<User> findContactByManagedContact(@Param(value = "username") String username) {
		/*find contacts where user is "contact"*/
		User user = userRepo.findByUsername(username);
		List<Contact> contacts = contactRepo.findByContact(user);
		
		/*Get users linked to contacts*/
		Set<User> users = new HashSet<User>();
		for(int i=0; i<contacts.size(); i++) {
			String userUsername = contacts.get(i).getUserName();	
			User contact = userRepo.findByUsername(userUsername);
			users.add(contact);
		}
		
		/*find contacts where user is "user"*/
		List<Contact> myContacts = contactRepo.findByUser(user);
		
		/*remove from users list, users i already added*/
		for(int i=0; i<myContacts.size(); i++) {
			String contactUsername = myContacts.get(i).getContactName();	
			User addedContact = userRepo.findByUsername(contactUsername);
			users.remove(addedContact);
		}
		
		return users;
		
	}
	/**
	 * add a contact to user's list
	 * @param contact
	 */
	@RequestMapping(value="/user/contact/add", method = RequestMethod.POST)
	public void addContact(@RequestBody Contact contact){
		contactRepo.save(contact);
	}
}
