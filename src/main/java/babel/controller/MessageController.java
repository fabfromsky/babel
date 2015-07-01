package babel.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import babel.entity.Message;
import babel.repository.MessageRepository;

/**
 * 
 * @author fdesert
 *
 */
@RestController
@RequestMapping("/messages")
public class MessageController {
	
	@Autowired
	private MessageRepository messageRepo;
		
	/**
	 * find messages by [username]
	 * @param username
	 * @return list of messages where sender=[username]||receiver=[username]
	 */
	@RequestMapping(method = RequestMethod.GET, params = "username")
	public List<Message> getMessagesByUsername(@RequestParam(value = "username", required = true) String username) {
		
		return messageRepo.findByReceiverOrSender(username, username);
	}
	
	/**
	 * create new message
	 * @param message
	 */
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public void sendMessage(@RequestBody Message message){
		messageRepo.save(message);
	}
}
