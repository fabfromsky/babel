package babel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="babel_challenge")
public class Challenge {
	
	public Challenge(){};
	
	public Challenge(int challengeId, String game, String player,
			String challenger, int playerScore, int challengerScore, String date) {
		super();
		this.challengeId = challengeId;
		this.game = game;
		this.player = player;
		this.challenger = challenger;
		this.playerScore = playerScore;
		this.challengerScore = challengerScore;
		this.date = date;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected int challengeId;
	
	protected String game;
	
	protected String player;
	
	protected String challenger;
	
	protected int playerScore;
	
	@Column(nullable = true)
	protected int challengerScore;
	
	protected String date;

	public int getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(int challengeId) {
		this.challengeId = challengeId;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getChallenger() {
		return challenger;
	}

	public void setChallenger(String challenger) {
		this.challenger = challenger;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	public int getChallengerScore() {
		return challengerScore;
	}

	public void setChallengerScore(int challengerScore) {
		this.challengerScore = challengerScore;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
