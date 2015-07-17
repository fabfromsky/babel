package babel.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="Babel_user")
@JsonInclude(Include.NON_NULL)
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "username")
public class User {
	
	public User(){};
	
	public User(String firstName, String lastName, String mail,
			String username, String pwd, List<Trophy> trophies,
			List<Contact> contacts, List<Contact> manageContacts,
			List<UserGames> games, List<Message> sentMessages,
			List<Message> receivedMessages, String userImg, 
			int userChallengesCount, int userVictoriesCount, String sex) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.username = username;
		this.pwd = pwd;
		this.trophies = trophies;
		this.contacts = contacts;
		this.manageContacts = manageContacts;
		this.games = games;
		this.sentMessages = sentMessages;
		this.receivedMessages = receivedMessages;
		this.userImg = userImg;
		this.userChallengesCount = userChallengesCount;
		this.userVictoriesCount = userVictoriesCount;
		this.sex = sex;
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
	protected String userImg;
	
	@Column(nullable = true)
	protected int userChallengesCount;
	
	@Column(nullable = true)
	protected int userVictoriesCount;
	
	@Column(nullable = true)
	protected String sex;
	
	@Column(nullable = true)
	@JsonProperty("trophies")
	@ManyToMany
	@JoinTable(name="babel_user_trophies", 
		joinColumns=@JoinColumn(name="user"), 
		inverseJoinColumns=@JoinColumn(name="trophy"))
	protected List<Trophy> trophies;
	
	@Column(nullable = true)
	@JsonProperty("games")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	protected List<UserGames> games;
	
	@Column(nullable = true)
	@OneToMany
	@JoinColumn(name="user", referencedColumnName="username")
	@JsonProperty("contacts")
	protected List<Contact> contacts;
	
	@Column(nullable = true)
	@OneToMany
	@JoinColumn(name="contact", referencedColumnName="username")
	@JsonProperty("manageContacts")
	protected List<Contact> manageContacts;
	
	@Column(nullable = true)
	@JsonProperty("sentMessages")
	@OneToMany
	@JoinColumn(name="sender", referencedColumnName="username")
	protected List<Message> sentMessages;
	
	@Column(nullable = true)
	@JsonProperty("receivedMessages")
	@OneToMany
	@JoinColumn(name="receiver", referencedColumnName="username")
	protected List<Message> receivedMessages;
	
	@Column(nullable = true)
	@JsonProperty("sentChallenges")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
	protected List<Challenge> sentChallenges;
	
	@Column(nullable = true)
	@JsonProperty("receivedChallenges")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "challenger")
	protected List<Challenge> receivedChallenges;
	
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

	public int getUserChallengesCount() {
		return userChallengesCount;
	}

	public void setUserChallengesCount(int userChallengesCount) {
		this.userChallengesCount = userChallengesCount;
	}

	public int getUserVictoriesCount() {
		return userVictoriesCount;
	}

	public void setUserVictoriesCount(int userVictoriesCount) {
		this.userVictoriesCount = userVictoriesCount;
	}

	public String getUserImg() {
		if(userImg != null) {
			return userImg;
		}
		else {
			return this.getSex() + ".jpg";
		}
		
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
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

	public List<Message> getSentMessages() {
		return sentMessages;
	}

	public void setSentMessages(List<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}

	public List<Message> getReceivedMessages() {
		return receivedMessages;
	}

	public void setReceivedMessages(List<Message> receivedMessages) {
		this.receivedMessages = receivedMessages;
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
	
	public List<Contact> getManageContacts() {
		return manageContacts;
	}

	public void setManageContacts(List<Contact> manageContacts) {
		this.manageContacts = manageContacts;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	

	public float getPoints() {
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

	public int getGamesCount() {
		int userGamesCount = 0;
		userGamesCount = this.getGames().size();
		return userGamesCount;
	}
	
}

