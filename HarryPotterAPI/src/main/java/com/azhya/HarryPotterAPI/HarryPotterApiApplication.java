package com.azhya.HarryPotterAPI;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.azhya.HarryPotterAPI.models.Wizard;
import com.azhya.HarryPotterAPI.services.WizardService;

/**
 * This service will deal with all of the API data requests and manpulating it for my own services.
 * 
 * 
 * @author Azhya Knox
 **/
@SpringBootApplication
public class HarryPotterApiApplication {
	
	private static Logger log = Logger.getLogger(HarryPotterApiApplication.class);
	private static String uri = "http://hp-api.herokuapp.com/api/characters";
	private String className = this.getClass().getSimpleName();
	
	@Autowired
	WizardService wizardService;
	

	public static void main(String[] args) {
		SpringApplication.run(HarryPotterApiApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	//this method runs upon startup
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		log.info(className + ": preloading data from Harry Potter API into social site db...");
		
		return args -> {
			//call the api & parse data into Java object
			ResponseEntity<Wizard[]> re = restTemplate.getForEntity(uri, Wizard[].class);
			
			//save each wiz into database
			Wizard[] wizards = re.getBody();
			
			for(Wizard w : wizards) {
				log.debug(className + ": character from external URL - " + w.toString());
				boolean isSaved = wizardService.saveCharacter(w);
				if(isSaved == true) {
					continue;
				}else {
					break;
				}
			}
		    
		    log.info(className + ": preload data is now complete.");
		};
	}

}
