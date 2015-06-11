package babel.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="Babel_user")
@JsonInclude(Include.NON_NULL)
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	protected  int userId;
	
	public User() {}

	public User(int userId, String firstName, String lastName, String mail,
			String username, String password, List<Trophy> trophies,
			List<Game> playedGames, List<Game> answeredGames) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.trophies = trophies;
		this.playedGames = playedGames;
		this.answeredGames = answeredGames;
	}



	protected String firstName;
	
	protected String lastName;
	
	protected String mail;
	
	protected String username;
	
	protected String password;
	
	@JsonProperty("trophies")
	@JsonManagedReference
	@ManyToMany(cascade = { CascadeType.ALL }, mappedBy = "userTrophy")
	protected List<Trophy> trophies;
	
	@JsonProperty("playedGames")
	@JsonManagedReference
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "firstPlayer")
	protected List<Game> playedGames;
	
	@JsonProperty("answeredGames")
	@JsonManagedReference
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "secondPlayer")
	protected List<Game> answeredGames;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Trophy> getTrophies() {
		return trophies;
	}

	public void setTrophies(List<Trophy> trophies) {
		this.trophies = trophies;
	}

	public List<Game> getPlayedGames() {
		return playedGames;
	}

	public void setPlayedGames(List<Game> playedGames) {
		this.playedGames = playedGames;
	}

	public List<Game> getAnsweredGames() {
		return answeredGames;
	}

	public void setAnsweredGames(List<Game> answeredGames) {
		this.answeredGames = answeredGames;
	}
	
	
	
}
