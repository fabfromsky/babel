package babel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name="Babel_game")
@JsonInclude(Include.NON_NULL)
public class Game {
	
	public Game() {};
	
	public Game(String gameId, String gameName, String gameDescription, String gameUrl) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
		this.gameDescription = gameDescription;
		this.gameUrl = gameUrl;
	}

	@Id
	protected String gameId;
	
	protected String gameName;
	
	protected String gameDescription;
	
	protected String gameUrl;

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
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

	public String getGameUrl() {
		return gameUrl;
	}

	public void setGameUrl(String gameUrl) {
		this.gameUrl = gameUrl;
	}
	
}