package babel.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import babel.entity.UserGames;
import babel.repository.UserGamesRepository;

@RestController
@RequestMapping("/user/games")
public class UserGamesController {

	private UserGamesRepository userGamesRepo;
	
	@RequestMapping(method = RequestMethod.GET, params = {"username"})
	public List<UserGames> getUserByUsername(@RequestParam(value = "username", required = true) String username) {
		return userGamesRepo.findByUser(username);
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public void addGame(@RequestBody UserGames game) {
		userGamesRepo.save(game);
	}
}
