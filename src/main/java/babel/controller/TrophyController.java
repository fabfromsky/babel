package babel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import babel.entity.Trophy;
import babel.repository.TrophyRepository;

/**
 * 
 * @author fdesert
 *
 */
@RestController
@RequestMapping("/trophy")
public class TrophyController {
	
	@Autowired
	private TrophyRepository trophyRepo;

	@RequestMapping(method = RequestMethod.GET)
	public List<Trophy> getAllTrophies() {
		return trophyRepo.findAll();
		
	}
	/**
	 * create a new trophy
	 * @param trophy
	 */
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public void addTrophy(@RequestBody Trophy trophy) {
		trophyRepo.save(trophy);
	}
}
