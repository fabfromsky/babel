package babel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babel.entity.Challenge;

public interface ChallengeRepository extends JpaRepository<Challenge, Long>{
	
	public List<Challenge> findByPlayer(String player);

	public List<Challenge> findByChallenger(String player);
	
}
