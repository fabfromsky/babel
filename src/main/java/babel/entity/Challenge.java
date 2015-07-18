package babel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="babel_challenge")
public class Challenge {
	
	public Challenge(){};
	
	public Challenge(int challengeId, Game game, User player,
			User challenger, Integer playerScore, Integer challengerScore, String date) {
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
	
	@ManyToOne
	@JoinColumn(name = "gameId")
	protected Game game;
	
	@ManyToOne
	@JoinColumn(name = "player")
	@JsonBackReference(value = "player")
	protected User player;

	@ManyToOne
	@JoinColumn(name = "challenger")
	@JsonBackReference(value = "challenger")
	protected User challenger;
	
	protected Integer playerScore;
	
	@Column(nullable = true)
	protected Integer challengerScore;
	
	protected String date;

	public int getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(int challengeId) {
		this.challengeId = challengeId;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public User getPlayer() {
		return player;
	}

	public void setPlayer(User player) {
		this.player = player;
	}

	public User getChallenger() {
		return challenger;
	}

	public void setChallenger(User challenger) {
		this.challenger = challenger;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	public Integer getChallengerScore() {
		return challengerScore;
	}

	public void setChallengerScore(Integer challengerScore) {
		this.challengerScore = challengerScore;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getPlayerName() {
		return player.getUsername();
	}
	
	public String getChallengerName() {
		return challenger.getUsername();
	}
}
