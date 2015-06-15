package babel.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import babel.entity.Message;
import babel.repository.MessageRepository;

@RestController
@RequestMapping("/messages")
public class MessageController {
	
	@Autowired
	private MessageRepository messageRepo;
	
	private Set messagesSet = new HashSet();
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Message> getAllMessages() {
		return messageRepo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, params = "username")
	public Set<Message> getMessagesByUsername(@RequestParam(value = "username", required = true) String username) {
		
		messagesSet.clear();
		messagesSet.addAll(messageRepo.findBySender(username));
		messagesSet.addAll(messageRepo.findByReceiver(username));
		return messagesSet;
	}
}
