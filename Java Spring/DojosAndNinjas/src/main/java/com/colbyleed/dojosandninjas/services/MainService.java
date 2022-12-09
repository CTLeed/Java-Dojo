package com.colbyleed.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colbyleed.dojosandninjas.models.Dojo;
import com.colbyleed.dojosandninjas.models.Ninja;
import com.colbyleed.dojosandninjas.repositories.DojoRepository;
import com.colbyleed.dojosandninjas.repositories.NinjaRepository;

@Service
public class MainService {
	
	@Autowired
	DojoRepository dojoRepo;
	
	@Autowired
	NinjaRepository ninjaRepo;
	
//	----------------- CRUD FOR DOJOS ------------------------------   //

	// CREATE
	public Dojo createDojo(Dojo newDojo) {
		return dojoRepo.save(newDojo);
	}
	// READ ONE
	public Dojo getOneDojo(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
	
	// READ ALL
	public List<Dojo> getAllDojos() {
		return dojoRepo.findAll();
	}
	
	// UPDATE ONE
	public Dojo updateDojo(Dojo updatedDojo) {
		return dojoRepo.save(updatedDojo);
	}
	
	// DELETE ONE
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
	
	
//	----------------- CRUD FOR NINJAS ------------------------------   //
	
	// CREATE
	public Ninja createNinja(Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	}
	
	// READ ONE
	public Ninja getOneNinja(Long id) {
		return ninjaRepo.findById(id).orElse(null);
	}
	
	// READ ALL
	public List<Ninja> getAllNinjas() {
		return ninjaRepo.findAll();
	}
	
	// UPDATE ONE
	public Ninja updateNinja(Ninja updatedNinja) {
		return ninjaRepo.save(updatedNinja);
	}
	
	// DELETE ONE
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}	
	
}
