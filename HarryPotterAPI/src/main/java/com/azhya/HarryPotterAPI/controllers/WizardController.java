package com.azhya.HarryPotterAPI.controllers;

import static com.azhya.HarryPotterAPI.util.ClientMessageImpl.CREATION_FAILED;
import static com.azhya.HarryPotterAPI.util.ClientMessageImpl.SUCCESSFULLY_CREATED;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azhya.HarryPotterAPI.models.Wizard;
import com.azhya.HarryPotterAPI.services.WizardService;
import com.azhya.HarryPotterAPI.util.ClientMessage;



@RestController("wizardController")
@RequestMapping("/characters")
@CrossOrigin("http://localhost:4200", "https://20.98.180.248")
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
}
