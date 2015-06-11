package babel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import babel.entity.User;
import babel.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

		@Autowired
		private UserRepository userRepo;
		
		@RequestMapping(method = RequestMethod.GET, params = {"username"})
		public User getUserByUsername(@RequestParam(value = "username", required = true, defaultValue = "") String username) {
			return userRepo.findByUsername(username);
		}
		
		@RequestMapping(value = "save", method = RequestMethod.POST)
		@ResponseStatus(HttpStatus.OK)
		public User saveUser(@RequestBody User user) {
			return userRepo.save(user);
		}
		
}
