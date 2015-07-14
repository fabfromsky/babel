package babel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import babel.entity.Game;
import babel.repository.GameRepository;

/**
 * 
 * @author fdesert
 *
 */
@RestController
@RequestMapping("/games")
public class GameController {

	@Autowired
	private GameRepository gameRepo;
	
	/**
	 * get all games
	 * @return list of all games
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Game> getAll() {
		return gameRepo.findAll();
	}

}
