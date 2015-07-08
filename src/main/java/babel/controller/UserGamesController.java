package babel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import babel.entity.User;
import babel.entity.UserGames;
import babel.repository.UserGamesRepository;
import babel.repository.UserRepository;

@RestController
@RequestMapping("/user/games")
public class UserGamesController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserGamesRepository userGamesRepo;
	
	/**
	 * Returns user's games list
	 * @param username
	 * @return list of UserGames
	 */
	@RequestMapping(method = RequestMethod.GET, params = {"username"})
	public List<UserGames> getUserByUsername(@RequestParam(value = "username", required = true) String username) {
		User user = userRepo.findByUsername(username);
		return userGamesRepo.findByUser(user);
	}
	
	/**
	 * add a game to user's list
	 * @param game
	 */
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public void addGame(@RequestBody UserGames game) {
		userGamesRepo.save(game);
	}
}
