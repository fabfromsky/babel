package babel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import babel.entity.Trophy;
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
		
		@RequestMapping(value = "/trophy", method = RequestMethod.GET, params = "username")
		public List<Trophy> getUserTrophies(@RequestParam(value = "username", required = true) String username) {
			User user = userRepo.findByUsername(username);
			return user.getTrophies();
		}
		
}
