package com.azhya.HarryPotterAPI.services;

import java.util.List;
import java.util.Optional;

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
		return wizardRepo.findAllHogwartsStudents();
	}

	@Override
	public List<Wizard> getAllHogwartsStaff() {
		log.info(className + ": retrieving the list of Hogwarts staff members from DB.");
		return wizardRepo.findAllHogwartsStaff();
	}

	@Override
	public List<Wizard> getAllHouseMembers(String house) {
		log.info(className + ": retrieving the list of house members of " + house + " house from DB.");
		return wizardRepo.findAllByHouse(house);
	}

	@Override
	public boolean saveCharacter(Wizard character) {
		log.info(className + ": saving character into DB.");
		log.debug(className + ": new character data received from controller: \n" + character.toString());
		Wizard tempCharacter = new Wizard(
					character.getId(), 
					character.getName(), 
					character.getSpecies(),
					character.getGender(), 
					character.getHouse(),
					character.getDateOfBirth(), 
					character.getYearOfBirth(),
					character.getAncestry(),
					character.getEyeColour(), 
					character.getHairColour(),
					character.getWand(), 
					character.getPatronus(),
					character.hogwartsStudent(), 
					character.hogwartsStaff(),
					character.getActor(), 
					character.alive(),
					character.getImage()
				);
		log.debug(className + ": character being saved is: " + tempCharacter.toString());
		return wizardRepo.saveAndFlush(tempCharacter) != null;
	}

	@Override
	public Optional<Wizard> getCharacterById(int id) {
		log.info(className + ": retrieving character from DB with id: " + id + ".");
		return wizardRepo.findById(id);
	}

	@Override
	public List<Wizard> getCharactersByName(String name) {
		log.info(className + ": retrieving the list of characters that contains: [" + name + "] in name.");
		String searchName = name.toLowerCase();
		return wizardRepo.findAllByName(searchName);
	}

	@Override
	public List<Wizard> getCharactersByGender(String gender) {
		log.info(className + ": retrieving the list of characters that are: [" + gender + "] in gender.");
		String searchGender = gender.toLowerCase();
		return wizardRepo.findAllByGender(searchGender);
	}

	@Override
	public List<Wizard> getAllCharactersByLivingStatus(boolean alive) {
		log.info(className + ": retrieving the list of characters from DB that are living status of: " + alive);
		return wizardRepo.findAllLivingCharacters(alive);
	}

}
