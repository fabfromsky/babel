package babel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Babel_trophy")
public class Trophy {

	
	public Trophy(int trophyId, User userTrophy, String trophyName, int points,
			boolean unlocked) {
		super();
		this.trophyId = trophyId;
		this.userTrophy = userTrophy;
		this.trophyName = trophyName;
		this.points = points;
		this.unlocked = unlocked;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected int trophyId;
	
	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name="userId")
	protected User userTrophy;

	protected String trophyName;
	
	protected int points;
	
	protected boolean unlocked;

	public int getTrophyId() {
		return trophyId;
	}

	public void setTrophyId(int trophyId) {
		this.trophyId = trophyId;
	}

	public User getUserTrophy() {
		return userTrophy;
	}

	public void setUserTrophy(User userTrophy) {
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

	public boolean isUnlocked() {
		return unlocked;
	}

	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}
	
	
}
