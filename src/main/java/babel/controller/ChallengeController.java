package babel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import babel.entity.Challenge;
import babel.repository.ChallengeRepository;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {
	
	@Autowired
	private ChallengeRepository challengeRepo;
	
	@RequestMapping(method = RequestMethod.GET, params = {"username"})
	public List<Challenge> getChallengesByPlayer(@RequestParam(value ="username", required = true) String player){
		return challengeRepo.findByPlayer(player);
	}

}
