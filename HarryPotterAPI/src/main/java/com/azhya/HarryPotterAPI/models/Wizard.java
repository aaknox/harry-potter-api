package com.azhya.HarryPotterAPI.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="wizards")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wizard {
	
	@Id
	@Column(name="wizardId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="species")
	private String species;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="house")
	private String house;
	
	@Column(name="dateOfBirth")
	private String dateOfBirth;
	
	@Column(name="yearOfBirth")
	private int yearOfBirth;
	
	@Column(name="ancestry")
	private String ancestry;
	
	@Column(name="eyeColour")
	private String eyeColour;
	
	@Column(name="hairColour")
	private String hairColour;
	
	@ManyToOne(targetEntity = Wand.class, cascade = CascadeType.ALL)
	private Wand wand;
	
	@Column(name="patronus")
	private String patronus;
	
	@Column(name="hogwartsStudent")
	@JsonProperty(value="hogwartsStudent")     
	private boolean hogwartsStudent;
	
	@Column(name="hogwartsStaff")
	@JsonProperty(value="hogwartsStaff")    
	private boolean hogwartsStaff;
	
	@Column(name="actor")
	private String actor;
	
	@Column(name="alive")
	@JsonProperty(value="alive")
	private boolean alive;
	
	@Column(name="image")
	private String image;
	
	public Wizard() {
		// empty constructor
	}

	// constructor without id
	public Wizard(String name, String species, String gender, String house, String dateOfBirth, int yearOfBirth,
			String ancestry, String eyeColour, String hairColour, Wand wand, String patronus, boolean hogwartsStudent,
			boolean hogwartsStaff, String actor, boolean alive, String image) {
		super();
		this.name = name;
		this.species = species;
		this.gender = gender;
		this.house = house;
		this.dateOfBirth = dateOfBirth;
		this.yearOfBirth = yearOfBirth;
		this.ancestry = ancestry;
		this.eyeColour = eyeColour;
		this.hairColour = hairColour;
		this.wand = wand;
		this.patronus = patronus;
		this.hogwartsStudent = hogwartsStudent;
		this.hogwartsStaff = hogwartsStaff;
		this.actor = actor;
		this.alive = alive;
		this.image = image;
	}

	// all fields constructor
	public Wizard(int id, String name, String species, String gender, String house, String dateOfBirth, int yearOfBirth,
			String ancestry, String eyeColour, String hairColour, Wand wand, String patronus, boolean hogwartsStudent,
			boolean hogwartsStaff, String actor, boolean alive, String image) {
		super();
		this.id = id;
		this.name = name;
		this.species = species;
		this.gender = gender;
		this.house = house;
		this.dateOfBirth = dateOfBirth;
		this.yearOfBirth = yearOfBirth;
		this.ancestry = ancestry;
		this.eyeColour = eyeColour;
		this.hairColour = hairColour;
		this.wand = wand;
		this.patronus = patronus;
		this.hogwartsStudent = hogwartsStudent;
		this.hogwartsStaff = hogwartsStaff;
		this.actor = actor;
		this.alive = alive;
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
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

	public String getEyeColour() {
		return eyeColour;
	}

	public void setEyeColour(String eyeColour) {
		this.eyeColour = eyeColour;
	}

	public String getHairColour() {
		return hairColour;
	}

	public void setHairColour(String hairColour) {
		this.hairColour = hairColour;
	}

	public Wand getWand() {
		return wand;
	}

	public void setWands(Wand wand) {
		this.wand = wand;
	}

	public String getPatronus() {
		return patronus;
	}

	public void setPatronus(String patronus) {
		this.patronus = patronus;
	}

	public boolean hogwartsStudent() {
		return hogwartsStudent;
	}

	public void setHogwartStudent(boolean hogwartsStudent) {
		this.hogwartsStudent = hogwartsStudent;
	}

	public boolean hogwartsStaff() {
		return hogwartsStaff;
	}

	public void setHogwartStaff(boolean hogwartsStaff) {
		this.hogwartsStaff = hogwartsStaff;
	}

	public boolean alive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actor == null) ? 0 : actor.hashCode());
		result = prime * result + ((ancestry == null) ? 0 : ancestry.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((eyeColour == null) ? 0 : eyeColour.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((hairColour == null) ? 0 : hairColour.hashCode());
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + (alive ? 1231 : 1237);
		result = prime * result + (hogwartsStaff ? 1231 : 1237);
		result = prime * result + (hogwartsStudent ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((patronus == null) ? 0 : patronus.hashCode());
		result = prime * result + ((species == null) ? 0 : species.hashCode());
		result = prime * result + ((wand == null) ? 0 : wand.hashCode());
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
		if (eyeColour == null) {
			if (other.eyeColour != null)
				return false;
		} else if (!eyeColour.equals(other.eyeColour))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (hairColour == null) {
			if (other.hairColour != null)
				return false;
		} else if (!hairColour.equals(other.hairColour))
			return false;
		if (house == null) {
			if (other.house != null)
				return false;
		} else if (!house.equals(other.house))
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (alive != other.alive)
			return false;
		if (hogwartsStaff != other.hogwartsStaff)
			return false;
		if (hogwartsStudent != other.hogwartsStudent)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (patronus == null) {
			if (other.patronus != null)
				return false;
		} else if (!patronus.equals(other.patronus))
			return false;
		if (species == null) {
			if (other.species != null)
				return false;
		} else if (!species.equals(other.species))
			return false;
		if (wand == null) {
			if (other.wand != null)
				return false;
		} else if (!wand.equals(other.wand))
			return false;
		if (yearOfBirth != other.yearOfBirth)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wizard [id=" + id + ", name=" + name + ", species=" + species + ", gender=" + gender + ", house="
				+ house + ", dateOfBirth=" + dateOfBirth + ", yearOfBirth=" + yearOfBirth + ", ancestry=" + ancestry
				+ ", eyeColour=" + eyeColour + ", hairColour=" + hairColour + ", wand=" + wand + ", patronus="
				+ patronus + ", hogwartsStudent=" + hogwartsStudent + ", hogwartsStaff=" + hogwartsStaff + ", actor="
				+ actor + ", alive=" + alive + ", image=" + image + "]";
	}
}
