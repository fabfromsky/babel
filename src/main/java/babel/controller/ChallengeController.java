package babel.controller;

import java.util.List;

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
	public List<Challenge> getChallengesByUsername(@RequestParam(value ="username", required = true) String username){
		return challengeRepo.findByChallengerOrPlayerOrderByChallengeIdDesc(username, username);
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
