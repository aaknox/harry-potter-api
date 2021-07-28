package com.azhya.HarryPotterAPI.models;

import javax.persistence.*;

@Entity
@Table(name="wands")
public class Wand {
	
	@Id
	@Column(name="wandId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int wandId;
	
	@Column(name="wood")
	private String wood;
	
	@Column(name="feather")
	private String feather;
	
	@Column(name="length")
	private int length;
	
	public Wand() {
		// TODO Auto-generated constructor stub
	}

	public Wand(int wandId, String wood, String feather, int length) {
		super();
		this.wandId = wandId;
		this.wood = wood;
		this.feather = feather;
		this.length = length;
	}

	public int getWandId() {
		return wandId;
	}

	public void setWandId(int wandId) {
		this.wandId = wandId;
	}

	public String getWood() {
		return wood;
	}

	public void setWood(String wood) {
		this.wood = wood;
	}

	public String getFeather() {
		return feather;
	}

	public void setFeather(String feather) {
		this.feather = feather;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feather == null) ? 0 : feather.hashCode());
		result = prime * result + length;
		result = prime * result + wandId;
		result = prime * result + ((wood == null) ? 0 : wood.hashCode());
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
		Wand other = (Wand) obj;
		if (feather == null) {
			if (other.feather != null)
				return false;
		} else if (!feather.equals(other.feather))
			return false;
		if (length != other.length)
			return false;
		if (wandId != other.wandId)
			return false;
		if (wood == null) {
			if (other.wood != null)
				return false;
		} else if (!wood.equals(other.wood))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wand [wandId=" + wandId + ", wood=" + wood + ", feather=" + feather + ", length=" + length + "]";
	}
}
