package babel.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import babel.entity.Challenge;
import babel.repository.ChallengeRepository;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

	@Autowired
	private ChallengeRepository challengeRepo;

	private Set challengesSet = new HashSet();

	@RequestMapping(method = RequestMethod.GET, params = {"player"})
	public List<Challenge> getChallengesByPlayer(@RequestParam(value = "player", required = true) String player){
		return challengeRepo.findByPlayer(player);
	}

	@RequestMapping(method = RequestMethod.GET, params = {"challenger"})
	public List<Challenge> getChallengesByChallenger(@RequestParam(value = "challenger", required = true) String challenger){
		return challengeRepo.findByChallenger(challenger);
	}

	@RequestMapping(method = RequestMethod.GET, params = {"username"})
	public Set<Challenge> getChallengesByUsername(@RequestParam(value ="username", required = true) String username){
		challengesSet.clear();
		challengesSet.addAll(challengeRepo.findByPlayer(username));
		challengesSet.addAll(challengeRepo.findByChallenger(username));
		return challengesSet;		
	}
}
