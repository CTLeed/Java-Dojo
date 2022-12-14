package com.colbyleed.otom.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colbyleed.otom.models.Dish;

@Repository
public interface DishRepository extends CrudRepository<Dish, Long>{
	List<Dish> findAll();

}
