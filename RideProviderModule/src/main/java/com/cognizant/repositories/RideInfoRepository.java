package com.cognizant.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.entities.RideInfo;



@Repository
public interface RideInfoRepository extends CrudRepository<RideInfo,RideInfo.RideInfoVehicleRpId> {

    
}
