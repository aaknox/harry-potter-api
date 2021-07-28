package com.azhya.HarryPotterAPI.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhya.HarryPotterAPI.models.Wizard;
import com.azhya.HarryPotterAPI.repositories.WizardRepository;

@Service("wizardService")
public class WizardServiceImpl implements WizardService {

	private static Logger log = Logger.getLogger(WizardServiceImpl.class);

	private String className = this.getClass().getSimpleName();

	@Autowired
	WizardRepository wizardRepo;

	@Override
	public List<Wizard> getAllCharacters() {
		log.info(className + ": retrieving the list of characters from DB.");
		return wizardRepo.findAll();
	}

	@Override
	public List<Wizard> getAllHogwartsStudents() {
		log.info(className + ": retrieving the list of Hogwarts students from DB.");
		return null;
	}

	@Override
	public List<Wizard> getAllHogwartsStaff() {
		log.info(className + ": retrieving the list of Hogwarts staff members from DB.");
		return null;
	}

	@Override
	public List<Wizard> getAllHouseMembers(String house) {
		log.info(className + ": retrieving the list of house members of " + house + " house from DB.");
		return null;
	}

	@Override
	public boolean saveCharacter(Wizard character) {
		log.info(className + ": saving character into DB.");
		log.debug(className + ": new character data received from controller: \n" + character.toString());
		Wizard tempCharacter = new Wizard(character.getId(), character.getName(), character.getActor(), character.getImageURL(), character.getSpecies(), character.getGender(), character.getHouse(),
				character.getDateOfBirth(), character.getYearOfBirth(), character.getAncestry(), character.getEyeColor(), character.getHairColor(),
				character.getWands(), character.getPatronusForm(), character.isHogwartStudent(), character.isHogwartStaff(), character.isAlive());
		log.debug(className + ": character being saved is: " + tempCharacter.toString());
		return wizardRepo.saveAndFlush(tempCharacter) != null;
	}

}
