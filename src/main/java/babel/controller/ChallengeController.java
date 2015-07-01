package babel.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import babel.entity.Challenge;
import babel.repository.ChallengeRepository;

/**
 * 
 * @author fdesert
 *
 */
@RestController
@RequestMapping("/challenges")
public class ChallengeController {

	@Autowired
	private ChallengeRepository challengeRepo;

	private Set<Challenge> challengesSet = new HashSet<Challenge>();

	/**
	 * find challenges by field "player"
	 * @param player
	 * @return list of challenges
	 */
	@RequestMapping(method = RequestMethod.GET, params = {"player"})
	public List<Challenge> getChallengesByPlayer(@RequestParam(value = "player", required = true) String player){
		return challengeRepo.findByPlayer(player);
	}

	/**
	 * find challenges by field "challenger"
	 * @param challenger
	 * @return list of challenges
	 */
	@RequestMapping(method = RequestMethod.GET, params = {"challenger"})
	public List<Challenge> getChallengesByChallenger(@RequestParam(value = "challenger", required = true) String challenger){
		return challengeRepo.findByChallenger(challenger);
	}
	
	/**
	 * find challenge by challengeId
	 * @param challengeid
	 * @return object challenge
	 */
	@RequestMapping(method = RequestMethod.GET, params = {"challengeid"})
	public Challenge getChallengeByChallengeId(@RequestParam(value = "challengeid", required = true) int challengeid) {
		return challengeRepo.findByChallengeId(challengeid);
	}

	/**
	 * find challenges by [username]
	 * @param username
	 * @return list of challenges where player=[username] || challenger=[username]
	 */
	@RequestMapping(method = RequestMethod.GET, params = {"username"})
	public Set<Challenge> getChallengesByUsername(@RequestParam(value ="username", required = true) String username){
		challengesSet.clear();
		challengesSet.addAll(challengeRepo.findByPlayer(username));
		challengesSet.addAll(challengeRepo.findByChallenger(username));
		return challengesSet;		
	}
	
	/**
	 * create a new challenge
	 * @param challenge
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/new")
	public void createChallenge(@RequestBody Challenge challenge) {
		challengeRepo.save(challenge);
	}
}
