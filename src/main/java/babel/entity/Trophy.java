package babel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="Babel_trophy")
@JsonInclude(Include.NON_NULL)
public class Trophy {

	public Trophy(){};

	public Trophy(int trophyId, String trophyName,
			int points, String description, String trophyCategory, String trophyTitle) {
		super();
		this.trophyId = trophyId;
		this.trophyTitle = trophyTitle;
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
	
	protected int points;
	
	protected String description;

	public int getTrophyId() {
		return trophyId;
	}

	public void setTrophyId(int trophyId) {
		this.trophyId = trophyId;
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