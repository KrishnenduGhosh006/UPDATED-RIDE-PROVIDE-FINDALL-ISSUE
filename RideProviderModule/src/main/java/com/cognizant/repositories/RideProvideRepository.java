package com.cognizant.repositories;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.entities.RideProvide;


@Repository
public interface RideProvideRepository extends CrudRepository<RideProvide,String> {

    
}

