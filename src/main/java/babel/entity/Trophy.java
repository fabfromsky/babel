package babel.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	public Trophy(String trophyId, List<User> userTrophy, String trophyName,
			int points, String description) {
		super();
		this.trophyId = trophyId;
		this.userTrophy = userTrophy;
		this.trophyName = trophyName;
		this.points = points;
		this.description = description;
	}

	@Id
	protected String trophyId;
	
	@JsonBackReference
	@ManyToMany()
	@JoinColumn(name="username")
	protected List<User> userTrophy;

	protected String trophyName;
	
	protected int points;
	
	protected String description;

	public String getTrophyId() {
		return trophyId;
	}

	public void setTrophyId(String trophyId) {
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
		
}