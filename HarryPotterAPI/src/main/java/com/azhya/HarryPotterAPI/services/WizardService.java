package com.azhya.HarryPotterAPI.services;

import java.util.List;

import com.azhya.HarryPotterAPI.models.Wizard;

public interface WizardService {

	// this methods correspond with original API endpoints
	public List<Wizard> getAllCharacters();
	public List<Wizard> getAllHogwartsStudents();
	public List<Wizard> getAllHogwartsStaff();
	public List<Wizard> getAllHouseMembers(String house);
	
	// business logic methods
	public boolean saveCharacter(Wizard character);
}
