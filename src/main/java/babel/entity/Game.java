package babel.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name="Babel_game")
@JsonInclude(Include.NON_NULL)
public class Game {
	
	public Game() {};
	
	public Game(int gameId, String gameName, String gameDescription, String gameImg, List<UserGames> sessions, String gameTitle) {
		super();
		this.gameId = gameId;
		this.gameTitle = gameTitle;
		this.gameName = gameName;
		this.gameDescription = gameDescription;
		this.gameImg = gameImg;
		this.sessions = sessions;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int gameId;
	
	protected String gameTitle;
	
	protected String gameName;
	
	protected String gameDescription;
	
	protected String gameImg;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
	protected List<UserGames> sessions;

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameDescription() {
		return gameDescription;
	}

	public void setGameDescription(String gameDescription) {
		this.gameDescription = gameDescription;
	}

	public String getGameImg() {
		return gameImg;
	}

	public void setGameImg(String gameImg) {
		this.gameImg = gameImg;
	}

	public List<UserGames> getSessions() {
		return sessions;
	}

	public void setSessions(List<UserGames> sessions) {
		this.sessions = sessions;
	}
	
}