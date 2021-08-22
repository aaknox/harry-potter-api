package com.azhya.HarryPotterAPI;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
 * @author Azhya Knox
 **/

@SpringBootTest(classes = { WizardService.class, WizardServiceImpl.class })
@RunWith(SpringRunner.class)
class WizardServiceTesting {

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
			wizardService.getAllCharacters();
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
			wizardService.getAllHogwartsStudents();
		  });
	}
	
	@Test
	void getAllHogwartsStaff_NormalTest() {
		// Arrange
		List<Wizard> expectedWizards = new ArrayList<>();
		expectedWizards.add(new Wizard());
		when(mockWizardRepo.findAllHogwartsStaff()).thenReturn(expectedWizards);

		// Act
		List<Wizard> actualWizards = wizardService.getAllHogwartsStaff();

		System.out.println(actualWizards.size());
		
		// Assert
		assertNotNull(actualWizards);
		assertEquals(expectedWizards, actualWizards);
	}
	
	@Test
	void getAllHogwartsStaff_AbnormalTest() {
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
		    //Code under test
			//Arrange
			when(mockWizardRepo.findAllHogwartsStaff()).thenThrow(new ArrayIndexOutOfBoundsException());
			
			//Act
			wizardService.getAllHogwartsStaff();
		  });
	}
	
	@Test
	void getAllHouseMembers_NormalTest() {
		// Arrange
		List<Wizard> expectedWizards = new ArrayList<>();
		String expectedHouse = "someHouse";
		expectedWizards.add(new Wizard());
		when(mockWizardRepo.findAllByHouse(expectedHouse)).thenReturn(expectedWizards);

		// Act
		List<Wizard> actualWizards = wizardService.getAllHouseMembers(expectedHouse);

		System.out.println(actualWizards.size());
		
		// Assert
		assertNotNull(actualWizards);
		assertEquals(expectedWizards, actualWizards);
	}
	
	@Test
	void getAllHouseMembers_AbnormalTest_NoHouseGiven() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			//Code under test
			//Arrange
			when(mockWizardRepo.findAllByHouse(null)).thenThrow(new NullPointerException("House string cannot be null"));
			
			//Act
			wizardService.getAllHouseMembers(null);
		});
	}
	
	@Test
	void getAllHouseMembers_AbnormalTest_NoMembers() {
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			//Code under test
			//Arrange
			String expectedHouse = "someOtherHouse";
			when(mockWizardRepo.findAllByHouse(expectedHouse)).thenThrow(new ArrayIndexOutOfBoundsException());
			
			//Act
			wizardService.getAllHouseMembers(expectedHouse);
		});
	}
	
	@Test
	void saveCharacter_NormalTest() {
		// Arrange
		Wizard expectedWizard = new Wizard();
		when(mockWizardRepo.saveAndFlush(Mockito.any(Wizard.class))).thenReturn(new Wizard());

		// Act
		boolean actualWizard = wizardService.saveCharacter(expectedWizard);

		// Assert
		assertTrue(actualWizard);
	}
	
	@Test
	void saveCharacter_AbnormalTest() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			// Arrange
			Wizard expectedWizard = null;
			when(mockWizardRepo.saveAndFlush(expectedWizard)).thenThrow(new NullPointerException());
	
			// Act
			wizardService.saveCharacter(expectedWizard);
		});
	}
	
	@Test
	void getCharacterById_NormalTest() {
		// Arrange
		Wizard expectedWizard = new Wizard();
		expectedWizard.setId(1);
		Optional<Wizard> expectedWizards = Optional.of(expectedWizard);
		when(mockWizardRepo.findById(expectedWizard.getId())).thenReturn(expectedWizards);

		// Act
		Optional<Wizard> actualWizards = wizardService.getCharacterById(expectedWizard.getId());

		// Assert
		assertNotNull(actualWizards);
		assertEquals(expectedWizards, actualWizards);
	}
	
	@Test
	void getCharacterById_AbnormalTest() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			// Arrange
			Wizard expectedWizard = new Wizard();
			when(mockWizardRepo.findById(expectedWizard.getId())).thenThrow(new NullPointerException());
	
			// Act
			wizardService.getCharacterById(expectedWizard.getId());
		});
	}
	
	@Test
	void getCharactersByName_NormalTest() {
		// Arrange
		List<Wizard> expectedWizards = new ArrayList<>();
		Wizard w = new Wizard();
		w.setName("Test Wizard");
		expectedWizards.add(w);
		when(mockWizardRepo.findAllByName(w.getName().toLowerCase())).thenReturn(expectedWizards);

		// Act
		List<Wizard> actualWizards = wizardService.getCharactersByName(w.getName());

		// Assert
		assertNotNull(actualWizards);
		assertEquals(expectedWizards, actualWizards);
	}
	
	@Test
	void getCharactersByName_AbnormalTest_NoNameGiven() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			//Code under test
			// Arrange
			List<Wizard> expectedWizards = new ArrayList<>();
			Wizard w = new Wizard();
			// setting no name here so name = null
			expectedWizards.add(w);
			when(mockWizardRepo.findAllByName(w.getName().toLowerCase())).thenThrow(new NullPointerException());

			// Act
			wizardService.getCharactersByName(w.getName());
		});
	}
	
	@Test
	void getCharactersByName_AbnormalTest_NameDoNotExist() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			//Code under test
			// Arrange
			List<Wizard> expectedWizards = new ArrayList<>();
			Wizard w = new Wizard();
			w.setName("realName");
			String fakeName = "badName";
			expectedWizards.add(w);
			when(mockWizardRepo.findAllByName(fakeName.toLowerCase())).thenThrow(new NullPointerException("name doesn't exist in db"));
			
			// Act
			wizardService.getCharactersByName(fakeName);
		});
	}
	
	@Test
	void getCharacterByGender_NormalTest() {
		// Arrange
		Wizard expectedWizard = new Wizard();
		expectedWizard.setGender("male");
		List<Wizard> expectedWizards = new ArrayList<>();
		expectedWizards.add(expectedWizard);
		when(mockWizardRepo.findAllByGender(expectedWizard.getGender())).thenReturn(expectedWizards);

		// Act
		List<Wizard> actualWizards = wizardService.getCharactersByGender(expectedWizard.getGender());

		// Assert
		assertNotNull(actualWizards);
		assertEquals(expectedWizards, actualWizards);
	}
	
	@Test
	void getCharacterByGender_AbnormalTest() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			// Arrange
			Wizard expectedWizard = new Wizard();
			when(mockWizardRepo.findAllByGender(expectedWizard.getGender())).thenThrow(new NullPointerException());
			
			// Act
			wizardService.getCharactersByGender(expectedWizard.getGender());
		});
	}
	
	@Test
	void getAllCharactersByLivingStatus_NormalTest() {
		// Arrange
		Wizard expectedWizard = new Wizard();
		expectedWizard.setAlive(true);
		List<Wizard> expectedWizards = new ArrayList<>();
		expectedWizards.add(expectedWizard);
		when(mockWizardRepo.findAllLivingCharacters(expectedWizard.alive())).thenReturn(expectedWizards);

		// Act
		List<Wizard> actualWizards = wizardService.getAllCharactersByLivingStatus(true);

		// Assert
		assertEquals(expectedWizards, actualWizards);
	}
	
	@Test
	void getAllCharactersByLivingStatus_AbnormalTest() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			// Arrange
			Wizard expectedWizard = new Wizard();
			expectedWizard.setAlive(false);
			List<Wizard> expectedWizards = new ArrayList<>();
			expectedWizards.add(expectedWizard);
			when(mockWizardRepo.findAllLivingCharacters(false)).thenReturn(expectedWizards);
			when(mockWizardRepo.findAllLivingCharacters(true)).thenThrow(new NullPointerException("no characters found"));

			// Act
			wizardService.getAllCharactersByLivingStatus(true);
		});
	}
}
