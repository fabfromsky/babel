package babel.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="Babel_user")
@JsonInclude(Include.NON_NULL)
public class User {
	
	public User(){};
	
	public User(String firstName, String lastName, String mail,
			String username, String password, List<Trophy> trophies,
			List<Contact> contacts) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.trophies = trophies;
		this.contacts = contacts;
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
	protected String password;
	
	@Column(nullable = true)
	@JsonProperty("trophies")
	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "userTrophy")
	protected List<Trophy> trophies;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user1")
	@JsonProperty("contacts")
	@JsonManagedReference
	protected List<Contact> contacts;

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

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
}

