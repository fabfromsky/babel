package babel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import babel.entity.Contact;
import babel.entity.Trophy;
import babel.entity.User;
import babel.repository.ContactRepository;
import babel.repository.UserGamesRepository;
import babel.repository.UserRepository;

/**
 * 
 * @author fdesert
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

		@Autowired
		private UserRepository userRepo;
		
		@Autowired
		private UserGamesRepository userGamesRepo;
		
		@Autowired
		private ContactRepository contactRepo;
		
		/**
		 * Search users with username containing search parameter 
		 * @param search
		 * @return list of users
		 */
		@RequestMapping(value="/search", method = RequestMethod.GET, params = {"search", "username"})
		public List<User> getAllUsers(@RequestParam(value = "search") String search, @RequestParam(value = "username") String username){
			List<User> result = userRepo.searchByUsernameLike(search);
			List<Contact> contacts = contactRepo.findByUser(username);
			/*remove contacts already addded*/
			for(int i=0; i<contacts.size(); i++) {
				User contactUser = userRepo.findByUsername(contacts.get(i).getContact());
				result.remove(contactUser);
			}
			return result;
		}
		/**
		 * Return user's informations
		 * @param 
		 * @return informations linked to the user
		 */
		@RequestMapping(method = RequestMethod.GET, params = {"username"})
		public User getUserByUsername(@RequestParam(value = "username", required = true) String username) {
			return userRepo.findByUsername(username);
		}
		
		/**
		 * Create user
		 * @param user
		 */
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public void createUserAccount(@RequestBody User user) {
			userRepo.save(user);
		}
		
		/**
		 * Delete user with username given in parameter
		 * @param username
		 */
		@RequestMapping(value = "/delete", method = RequestMethod.POST, params = "username")
		public void deleteUserAccount(@RequestParam(value = "username", required = true) String username) {
			User user = userRepo.findByUsername(username);
			userRepo.delete(user);
		}
		
		/**
		 * Get user's list of trophies
		 * @param username
		 * @return a list of trophies
		 */
		@RequestMapping(value = "/trophy", method = RequestMethod.GET, params = "username")
		public List<Trophy> getUserTrophies(@RequestParam(value = "username", required = true) String username) {
			User user = userRepo.findByUsername(username);
			return user.getTrophies();
		}
		
		/**
		 * Get user's list of contacts
		 * @param username
		 * @return a list of contacts 
		 */
		@RequestMapping(value = "/contacts", method = RequestMethod.GET, params = "username")
		public List<Contact> getUserContacts(@RequestParam(value = "username", required = true) String username) {
			User user = userRepo.findByUsername(username);
			return user.getContacts();
		}
		
		/**
		 * Add a trophy to user's list of trophies
		 * @param trophy
		 * @param username
		 */
//		@RequestMapping(value = "/trophy/add", method = RequestMethod.POST, params = "username")
//		public void addTrophy(@RequestBody Trophy trophy, @RequestParam(value = "username", required = true) String username) {
//			User user = userRepo.findByUsername(username);
//			List<Trophy> trophées = user.getTrophies();
//			trophées.add(trophy);
//			user.setTrophies(trophées);
//			userRepo.save(user);
//		}	
}
