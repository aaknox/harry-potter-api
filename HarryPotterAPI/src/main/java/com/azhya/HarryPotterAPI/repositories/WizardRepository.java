package com.azhya.HarryPotterAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azhya.HarryPotterAPI.models.Wizard;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, Integer> {

}
