package com.cognizant.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.entities.Simles;


@Repository
public interface SimlesRepository extends CrudRepository<Simles,Integer> {

	

    
}
