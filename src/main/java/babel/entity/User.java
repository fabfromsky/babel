package babel.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="Babel_user")
@JsonInclude(Include.NON_NULL)
public class User {
	
	public User(){};
	
	public User(String firstName, String lastName, String mail,
			String username, String pwd, List<Trophy> trophies,
			List<Contact> contacts, String userImg, float userPoints, int userChallenges, int userGameCount, int userVictories, List<UserGames> games) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.username = username;
		this.pwd = pwd;
		this.trophies = trophies;
		this.contacts = contacts;
		this.games = games;
		this.userImg = userImg;
		this.userPoints = userPoints;
		this.userChallenges = userChallenges;
		this.userGameCount = userGameCount;
		this.userVictories = userVictories;
	}
	
	@Column(nullable = false)
	protected String firstName;
	
	@Column(nullable = false)
	protected String lastName;
	
	@Column(nullable = false)
	protected String mail;
	
	@Id
	@Column(nullable = false, unique = true)
	protected String username;
	
	@Column(nullable = false)
	protected String pwd;
	
	@Column(nullable = true)
	@JsonProperty("trophies")
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "userTrophy")
	protected List<Trophy> trophies;
	
	@Column(nullable = true)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user1")
	@JsonProperty("contact")
	protected List<Contact> contacts;
	
	@Column(nullable = true)
	@JsonProperty("games")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	protected List<UserGames> games;
		
	@Column(nullable = true)
	protected String userImg;

	@Transient
	protected float userPoints;
	
	@Transient
	protected int userGameCount;
	
	protected int userChallenges;
	
	protected int userVictories;
	
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

	public List<Trophy> getTrophies() {
		return trophies;
	}

	public void setTrophies(List<Trophy> trophies) {
		this.trophies = trophies;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<UserGames> getGames() {
		return games;
	}

	public void setGames(List<UserGames> games) {
		this.games = games;
	}

	public float getUserPoints() {
		float trophyPoints = 0;
		List <Trophy> trophies = this.getTrophies();
		for(int i=0; i<trophies.size(); i++) {
			trophyPoints += trophies.get(i).getPoints();
		}
		float gamesPoints = 0;
		List<UserGames> games = this.getGames();
		for(int j=0; j<games.size(); j++) {
			gamesPoints += games.get(j).getScore();
		}
		return (gamesPoints + trophyPoints);
	}

	public void setUserPoints(float userPoints) {
		this.userPoints = userPoints;
	}

	public int getUserGameCount() {
		int userGameCount = 0;
		userGameCount = this.getGames().size();
		return userGameCount;
	}

	public void setUserGameCount(int userGameNumber) {
		this.userGameCount = userGameNumber;
	}

	public int getUserChallenges() {
		return userChallenges;
	}

	public void setUserChallenges(int userChallenges) {
		this.userChallenges = userChallenges;
	}

	public int getUserVictories() {
		return userVictories;
	}

	public void setUserVictories(int userVictories) {
		this.userVictories = userVictories;
	}
	
}

