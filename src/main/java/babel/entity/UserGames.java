package babel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="babel_user_games")
@JsonInclude(Include.NON_NULL)
public class UserGames {
	
	public UserGames(){}
	
	public UserGames(int userGameId, User user, Game game, int score) {
		super();
		this.userGameId = userGameId;
		this.user = user;
		this.game = game;
		this.score = score;
	}

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int userGameId;
	
	@ManyToOne
	@JoinColumn(name="username")
	protected User user;
	
	@ManyToOne
	@JoinColumn(name = "game")
	protected Game game;
	
	protected int score;

	public int getUserGameId() {
		return userGameId;
	}

	public void setUserGameId(int userGameId) {
		this.userGameId = userGameId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	

}
