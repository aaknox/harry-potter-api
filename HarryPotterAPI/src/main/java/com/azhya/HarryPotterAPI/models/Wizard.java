package com.azhya.HarryPotterAPI.models;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="wizards")
public class Wizard {
	
	@Id
	@Column(name="wizardId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="actor")
	private String actor;
	
	@Column(name="imageURL")
	private String imageURL;
	
	@Column(name="species")
	private String species;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="house")
	private String house;
	
	@Column(name="dateOfBirth")
	private LocalDate dateOfBirth;
	
	@Column(name="yearOfBirth")
	private int yearOfBirth;
	
	@Column(name="ancestry")
	private String ancestry;
	
	@Column(name="eyeColor")
	private String eyeColor;
	
	@Column(name="hairColor")
	private String hairColor;
	
	@ManyToOne(targetEntity = Wand.class, cascade = CascadeType.ALL)
	private Wand wands;
	
	@Column(name="patronus")
	private String patronusForm;
	
	@Column(name="isHogwartStudent")
	private boolean isHogwartStudent;
	
	@Column(name="isHogwartStaff")
	private boolean isHogwartStaff;
	
	@Column(name="isAlive")
	private boolean isAlive;
	
	public Wizard() {
		// empty constructor
	}

	// constructor without id
	public Wizard(String name, String actor, String imageURL, String species, String gender, String house,
			LocalDate dateOfBirth, int yearOfBirth, String ancestry, String eyeColor, String hairColor,
			Wand wands, String patronusForm, boolean isHogwartStudent, boolean isHogwartStaff, boolean isAlive) {
		super();
		this.name = name;
		this.actor = actor;
		this.imageURL = imageURL;
		this.species = species;
		this.gender = gender;
		this.house = house;
		this.dateOfBirth = dateOfBirth;
		this.yearOfBirth = yearOfBirth;
		this.ancestry = ancestry;
		this.eyeColor = eyeColor;
		this.hairColor = hairColor;
		this.wands = wands;
		this.patronusForm = patronusForm;
		this.isHogwartStudent = isHogwartStudent;
		this.isHogwartStaff = isHogwartStaff;
		this.isAlive = isAlive;
	}

	// all fields constructor
	public Wizard(int id, String name, String actor, String imageURL, String species, String gender, String house,
			LocalDate dateOfBirth, int yearOfBirth, String ancestry, String eyeColor, String hairColor,
			Wand wands, String patronusForm, boolean isHogwartStudent, boolean isHogwartStaff, boolean isAlive) {
		super();
		this.id = id;
		this.name = name;
		this.actor = actor;
		this.imageURL = imageURL;
		this.species = species;
		this.gender = gender;
		this.house = house;
		this.dateOfBirth = dateOfBirth;
		this.yearOfBirth = yearOfBirth;
		this.ancestry = ancestry;
		this.eyeColor = eyeColor;
		this.hairColor = hairColor;
		this.wands = wands;
		this.patronusForm = patronusForm;
		this.isHogwartStudent = isHogwartStudent;
		this.isHogwartStaff = isHogwartStaff;
		this.isAlive = isAlive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getAncestry() {
		return ancestry;
	}

	public void setAncestry(String ancestry) {
		this.ancestry = ancestry;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public Wand getWands() {
		return wands;
	}

	public void setWands(Wand wands) {
		this.wands = wands;
	}

	public String getPatronusForm() {
		return patronusForm;
	}

	public void setPatronusForm(String patronusForm) {
		this.patronusForm = patronusForm;
	}

	public boolean isHogwartStudent() {
		return isHogwartStudent;
	}

	public void setHogwartStudent(boolean isHogwartStudent) {
		this.isHogwartStudent = isHogwartStudent;
	}

	public boolean isHogwartStaff() {
		return isHogwartStaff;
	}

	public void setHogwartStaff(boolean isHogwartStaff) {
		this.isHogwartStaff = isHogwartStaff;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actor == null) ? 0 : actor.hashCode());
		result = prime * result + ((ancestry == null) ? 0 : ancestry.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((eyeColor == null) ? 0 : eyeColor.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((hairColor == null) ? 0 : hairColor.hashCode());
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		result = prime * result + id;
		result = prime * result + ((imageURL == null) ? 0 : imageURL.hashCode());
		result = prime * result + (isAlive ? 1231 : 1237);
		result = prime * result + (isHogwartStaff ? 1231 : 1237);
		result = prime * result + (isHogwartStudent ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((patronusForm == null) ? 0 : patronusForm.hashCode());
		result = prime * result + ((species == null) ? 0 : species.hashCode());
		result = prime * result + ((wands == null) ? 0 : wands.hashCode());
		result = prime * result + yearOfBirth;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wizard other = (Wizard) obj;
		if (actor == null) {
			if (other.actor != null)
				return false;
		} else if (!actor.equals(other.actor))
			return false;
		if (ancestry == null) {
			if (other.ancestry != null)
				return false;
		} else if (!ancestry.equals(other.ancestry))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (eyeColor == null) {
			if (other.eyeColor != null)
				return false;
		} else if (!eyeColor.equals(other.eyeColor))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (hairColor == null) {
			if (other.hairColor != null)
				return false;
		} else if (!hairColor.equals(other.hairColor))
			return false;
		if (house == null) {
			if (other.house != null)
				return false;
		} else if (!house.equals(other.house))
			return false;
		if (id != other.id)
			return false;
		if (imageURL == null) {
			if (other.imageURL != null)
				return false;
		} else if (!imageURL.equals(other.imageURL))
			return false;
		if (isAlive != other.isAlive)
			return false;
		if (isHogwartStaff != other.isHogwartStaff)
			return false;
		if (isHogwartStudent != other.isHogwartStudent)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (patronusForm == null) {
			if (other.patronusForm != null)
				return false;
		} else if (!patronusForm.equals(other.patronusForm))
			return false;
		if (species == null) {
			if (other.species != null)
				return false;
		} else if (!species.equals(other.species))
			return false;
		if (wands == null) {
			if (other.wands != null)
				return false;
		} else if (!wands.equals(other.wands))
			return false;
		if (yearOfBirth != other.yearOfBirth)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wizard [id=" + id + ", name=" + name + ", actor=" + actor + ", imageURL=" + imageURL + ", species="
				+ species + ", gender=" + gender + ", house=" + house + ", dateOfBirth=" + dateOfBirth
				+ ", yearOfBirth=" + yearOfBirth + ", ancestry=" + ancestry + ", eyeColor=" + eyeColor + ", hairColor="
				+ hairColor + ", wands=" + wands + ", patronusForm=" + patronusForm + ", isHogwartStudent="
				+ isHogwartStudent + ", isHogwartStaff=" + isHogwartStaff + ", isAlive=" + isAlive + "]";
	}
}
