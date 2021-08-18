package com.azhya.HarryPotterAPI.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.azhya.HarryPotterAPI.models.Wizard;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, Integer> {
	@Query(value = "SELECT * FROM wizards WHERE house= ?1", nativeQuery = true)
	List<Wizard> findAllByHouse(String house);
	
	@Query(value = "SELECT * FROM wizards WHERE lower(name) LIKE %?1%", nativeQuery = true)
	List<Wizard> findAllByName(String name);

	@Query(value = "SELECT * FROM wizards WHERE gender= ?1", nativeQuery = true)
	List<Wizard> findAllByGender(String searchGender);

	@Query(value = "SELECT * FROM wizards WHERE hogwarts_Student = true", nativeQuery = true)
	List<Wizard> findAllHogwartsStudents();
	
	@Query(value = "SELECT * FROM wizards WHERE hogwarts_Staff = true", nativeQuery = true)
	List<Wizard> findAllHogwartsStaff();

	@Query(value = "SELECT * FROM wizards WHERE alive = ?1", nativeQuery = true)
	List<Wizard> findAllLivingCharacters(boolean alive);
}
