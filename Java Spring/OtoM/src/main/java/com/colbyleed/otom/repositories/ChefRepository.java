package com.colbyleed.otom.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colbyleed.otom.models.Chef;

@Repository
public interface ChefRepository extends CrudRepository<Chef, Long>{
	List<Chef> findAll();

}
