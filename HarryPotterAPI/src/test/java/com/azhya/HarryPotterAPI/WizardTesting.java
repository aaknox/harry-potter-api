package com.azhya.HarryPotterAPI;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.azhya.HarryPotterAPI.models.Wizard;
import com.azhya.HarryPotterAPI.repositories.WizardRepository;
import com.azhya.HarryPotterAPI.services.WizardService;
import com.azhya.HarryPotterAPI.services.WizardServiceImpl;

/**
 * This test suite is testing the Wizard Service functionalities.
 * 
 * Mocks existing on: Wizard Repository
 * 
 * Functionalities being tested:
 * public List<Wizard> getAllHogwartsStaff(); 
 * public List<Wizard> getAllHouseMembers(String house);
 * 
 * // business logic methods public boolean saveCharacter(Wizard character);
 * public Optional<Wizard> getCharacterById(int id); public List<Wizard>
 * getCharactersByName(String name); public List<Wizard>
 * getCharactersByGender(String gender); public List<Wizard>
 * getAllCharactersByLivingStatus(boolean alive);
 **/

@SpringBootTest(classes = { WizardService.class, WizardServiceImpl.class })
@RunWith(SpringRunner.class)
class WizardTesting {

	@MockBean
	WizardRepository mockWizardRepo;

	@Autowired
	WizardService wizardService;

	@Test
	void getAllCharacters_NormalTest() {
		// Arrange
		List<Wizard> expectedWizards = new ArrayList<>();
		expectedWizards.add(new Wizard());
		when(mockWizardRepo.findAll()).thenReturn(expectedWizards);

		// Act
		List<Wizard> actualWizards = wizardService.getAllCharacters();

		// Assert
		assertNotNull(actualWizards);
		assertEquals(expectedWizards, actualWizards);
	}
	
	@Test
	void getAllCharacters_AbnormalTest() {
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
		    //Code under test
			//Arrange
			when(mockWizardRepo.findAll()).thenThrow(new ArrayIndexOutOfBoundsException());
			
			//Act
			List<Wizard> actualWizards = wizardService.getAllCharacters();
			
			//Assert
			assertNull(actualWizards);
		  });
	}

	@Test
	void getAllHogwartsStudents_NormalTest() {
		// Arrange
		List<Wizard> expectedWizards = new ArrayList<>();
		expectedWizards.add(new Wizard());
		when(mockWizardRepo.findAllHogwartsStudents()).thenReturn(expectedWizards);

		// Act
		List<Wizard> actualWizards = wizardService.getAllHogwartsStudents();

		System.out.println(actualWizards.size());
		
		// Assert
		assertNotNull(actualWizards);
		assertEquals(expectedWizards, actualWizards);
	}
	
	@Test
	void getAllHogwartsStudents_AbnormalTest() {
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
		    //Code under test
			//Arrange
			when(mockWizardRepo.findAllHogwartsStudents()).thenThrow(new ArrayIndexOutOfBoundsException());
			
			//Act
			List<Wizard> actualWizards = wizardService.getAllHogwartsStudents();
			
			//Assert
			assertNull(actualWizards);
		  });
	}

}
