package com.azhya.HarryPotterAPI.controllers;

import static com.azhya.HarryPotterAPI.util.ClientMessageImpl.CREATION_FAILED;
import static com.azhya.HarryPotterAPI.util.ClientMessageImpl.SUCCESSFULLY_CREATED;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azhya.HarryPotterAPI.models.Wizard;
import com.azhya.HarryPotterAPI.services.WizardService;
import com.azhya.HarryPotterAPI.util.ClientMessage;



@RestController("wizardController")
@RequestMapping("/characters")
@CrossOrigin(origins= {"http://localhost:4200","https://20.98.180.248"})
public class WizardController {
	
	private static Logger log = Logger.getLogger(WizardController.class);
	
	private String className = this.getClass().getSimpleName();
	
	@Autowired
	WizardService wizardService;
	
	@PostMapping(path="/create", consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClientMessage> createNewCharacter(@RequestBody Wizard character) {
		log.info(className + ": User is making a POST request to add character to DB.");
		log.debug(className + ": Character retrieved from client side - " + character.toString());
		ClientMessage body = wizardService.saveCharacter(character) ? SUCCESSFULLY_CREATED : CREATION_FAILED;
		log.info(className + ": createNewCharacter request has been completed.");
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}
	
	@GetMapping(path="/view/all", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Wizard>> viewPredefinedCharacters() {
		log.info(className + ": User is making a GET request to retrieve characters from DB.");
		List<Wizard> wizardList = wizardService.getAllCharacters();
		log.info(className + ": Character list has been retrieved. List size: " + wizardList.size() + ".");
		return ResponseEntity.ok(wizardList);
	}
	
	@GetMapping(path="/view/{wizardId}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Optional<Wizard>> viewWizardById(@PathVariable("wizardId") int wizardId) {
		Optional<Wizard> wizardList = wizardService.getCharacterById(wizardId);
		log.info(className + ": Character has been retrieved: " + wizardList.get().getName() + ".");
		return ResponseEntity.ok(wizardList);
	}
	
	@GetMapping(path="/view/house/{wizardHouse}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Wizard>> viewWizardsByHouse(@PathVariable("wizardHouse") String wizardHouse) {
		log.info(className + ": User is making a GET request to retrieve characters from DB by house " + wizardHouse);
		List<Wizard> wizardList = wizardService.getAllHouseMembers(wizardHouse);
		log.info(className + ": Character list has been retrieved. List size: " + wizardList.size() + ".");
		return ResponseEntity.ok(wizardList);
	}
	
	@GetMapping(path="/view/house/", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Wizard>> viewWizardsByHouse() {
		String wizardHouse = "";
		log.info(className + ": User is making a GET request to retrieve characters from DB by house " + wizardHouse);
		List<Wizard> wizardList = wizardService.getAllHouseMembers(wizardHouse);
		log.info(className + ": Character list has been retrieved. List size: " + wizardList.size() + ".");
		return ResponseEntity.ok(wizardList);
	}
	
	@GetMapping(path="/view/name/{wizardName}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Wizard>> viewWizardsByName(@PathVariable("wizardName") String wizardName) {
		log.info(className + ": User is making a GET request to retrieve characters from DB by name" + wizardName);
		List<Wizard> wizardList = wizardService.getCharactersByName(wizardName);
		log.info(className + ": Character list has been retrieved. List size: " + wizardList.size() + ".");
		return ResponseEntity.ok(wizardList);
	}
	
	@GetMapping(path="/view/gender/{gender}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Wizard>> viewWizardsByGender(@PathVariable("gender") String gender) {
		log.info(className + ": User is making a GET request to retrieve characters from DB by given gender: " + gender);
		List<Wizard> wizardList = wizardService.getCharactersByGender(gender);
		log.info(className + ": Character list has been retrieved. List size: " + wizardList.size() + ".");
		return ResponseEntity.ok(wizardList);
	}
	
	@GetMapping(path="/view/hogwarts/students", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Wizard>> viewAllHogwartsStudents() {
		log.info(className + ": User is making a GET request to retrieve characters from DB that are Hogwarts students.");
		List<Wizard> wizardList = wizardService.getAllHogwartsStudents();
		log.info(className + ": Character list has been retrieved. List size: " + wizardList.size() + ".");
		return ResponseEntity.ok(wizardList);
	}
	
	@GetMapping(path="/view/hogwarts/staff", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Wizard>> viewAllHogwartsStaff() {
		log.info(className + ": User is making a GET request to retrieve characters from DB that are Hogwarts staff.");
		List<Wizard> wizardList = wizardService.getAllHogwartsStaff();
		log.info(className + ": Character list has been retrieved. List size: " + wizardList.size() + ".");
		return ResponseEntity.ok(wizardList);
	}
	
	@GetMapping(path="/view/status/{alive}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Wizard>> viewAllCharactersByLivingStatus(@PathVariable("alive") boolean alive) {
		log.info(className + ": User is making a GET request to retrieve characters from DB with living status as " + alive);
		List<Wizard> wizardList = wizardService.getAllCharactersByLivingStatus(alive);
		log.info(className + ": Character list has been retrieved. List size: " + wizardList.size() + ".");
		return ResponseEntity.ok(wizardList);
	}
}
