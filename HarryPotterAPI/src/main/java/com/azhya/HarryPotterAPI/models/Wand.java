package com.azhya.HarryPotterAPI.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="wands")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wand {
	
	@Id
	@Column(name="wandId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int wandId;
	
	@Column(name="wood")
	private String wood;
	
	@Column(name="core")
	private String core;
	
	@Column(name="length")
	private int length;
	
	public Wand() {
		// TODO Auto-generated constructor stub
	}

	public Wand(int wandId, String wood, String core, int length) {
		super();
		this.wandId = wandId;
		this.wood = wood;
		this.core = core;
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

	public String getCore() {
		return core;
	}

	public void setCore(String core) {
		this.core = core;
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
		result = prime * result + ((core == null) ? 0 : core.hashCode());
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
		if (core == null) {
			if (other.core != null)
				return false;
		} else if (!core.equals(other.core))
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
		return "Wand [wandId=" + wandId + ", wood=" + wood + ", core=" + core + ", length=" + length + "]";
	}
}
