package babel.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="Babel_trophy")
@JsonInclude(Include.NON_NULL)
public class Trophy {

	public Trophy(){};

	public Trophy(int trophyId, List<User> userTrophy, String trophyName,
			int points, String description, String trophyCategory, String trophyTitle) {
		super();
		this.trophyId = trophyId;
		this.trophyTitle = trophyTitle;
		this.userTrophy = userTrophy;
		this.trophyName = trophyName;
		this.points = points;
		this.description = description;
		this.trophyCategory = trophyCategory;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int trophyId;

	protected String trophyName;
	
	protected String trophyTitle;
	
	protected String trophyCategory;
	
	@JsonBackReference
	@ManyToMany()
	@JoinTable(name="babel_user_trophies",
		joinColumns = @JoinColumn(name="trophyId"),
		inverseJoinColumns = @JoinColumn(name="username"))
	protected List<User> userTrophy;
	
	protected int points;
	
	protected String description;

	public int getTrophyId() {
		return trophyId;
	}

	public void setTrophyId(int trophyId) {
		this.trophyId = trophyId;
	}

	public List<User> getUserTrophy() {
		return userTrophy;
	}

	public void setUserTrophy(List<User> userTrophy) {
		this.userTrophy = userTrophy;
	}

	public String getTrophyName() {
		return trophyName;
	}

	public void setTrophyName(String trophyName) {
		this.trophyName = trophyName;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTrophyCategory() {
		return trophyCategory;
	}

	public void setTrophyCategory(String trophyCategory) {
		this.trophyCategory = trophyCategory;
	}

	public String getTrophyTitle() {
		return trophyTitle;
	}

	public void setTrophyTitle(String trophyTitle) {
		this.trophyTitle = trophyTitle;
	}	
		
}