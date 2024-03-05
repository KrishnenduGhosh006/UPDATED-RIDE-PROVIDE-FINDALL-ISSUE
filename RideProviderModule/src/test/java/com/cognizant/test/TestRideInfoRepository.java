package com.cognizant.test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.entities.RideInfo;
import com.cognizant.entities.RideProvide;
import com.cognizant.main.RideProviderModuleApplication;
import com.cognizant.repositories.RideInfoRepository;
import com.cognizant.repositories.RideProvideRepository;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ContextConfiguration(classes = RideProviderModuleApplication.class)
public class TestRideInfoRepository {

    @Autowired
    private RideInfoRepository rideInfoRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindAllPositive() {
        RideInfo RI = new RideInfo();
        RideInfo.RideInfoVehicleRpId vehiclerpid=  RI.new RideInfoVehicleRpId();
        vehiclerpid.setRp_Id("R1");
        vehiclerpid.setVechileNo("V1");
          System.out.println("--data set in embeddable--");
       RI.setRideInfoVehicleRpId(vehiclerpid);
        RI.setCarType("SUV");
        RI.setCarName("Toyota RAV4");
        RI.setFuelType("Petrol");
        RI.setNoOfSeats(5);
        
        RideProvide R= new RideProvide();
        R.setRpId("R1");
        R.setAdharcard(123456789012L); // Adjusted to fit within long data type
        R.setFirstName("John");
        R.setLastName("Doe");
        R.setEmailId("john@example.com");
        R.setPhone(1234567890); // Adjusted to fit within int data type
        R.setDlNo("DL12345678901234");
        R.setValidUpto(LocalDate.now().plusDays(31)); // Valid upto 30 days from current date
        R.setStatus("Registered");
        System.out.println("--before persist--");
        entityManager.persist(R);    
        System.out.println("--After persist--");
        RideProvide rideProvide=entityManager.find(RideProvide.class,"R1");
        RI.setRideProvide(rideProvide);
        System.out.println("--before persist RI--");
        entityManager.persist(RI); 
        System.out.println("--after persist RI--");
        
        System.out.println(RI);

       //Iterable<RideInfo> it = rideInfoRepository.findAll();
        Iterable<RideInfo.RideInfoVehicleRpId> iterable=new ArrayList<>();
        rideInfoRepository.findAllById(iterable);
        rideInfoRepository.existsById(vehiclerpid);
      Optional<RideInfo> optionalOfRideInfo= rideInfoRepository.findById(vehiclerpid);
      assertTrue(optionalOfRideInfo.isPresent());
        
        //assertTrue(it.iterator().hasNext());
    }

    @Test
    public void testFindAllNegative() {
        Iterable<RideInfo> it = rideInfoRepository.findAll();
        assertFalse(it.iterator().hasNext());
    }

    @Test
    public void testFindByVechileNoPositive() {
    	RideInfo RI = new RideInfo();
        RI.setVechileNo("ABC123");
        RI.setRpId("RP001");
        RI.setCarType("SUV");
        RI.setCarName("Toyota RAV4");
        RI.setFuelType("Petrol");
        RI.setNoOfSeats(5);
        
        RideProvide R= new RideProvide();
        R.setRpId("RP001");
        R.setAdharcard(123456789012L); // Adjusted to fit within long data type
        R.setFirstName("John");
        R.setLastName("Doe");
        R.setEmailId("john@example.com");
        R.setPhone(1234567890); // Adjusted to fit within int data type
        R.setDlNo("DL12345678901234");
        R.setValidUpto(LocalDate.now().plusDays(31)); // Valid upto 30 days from current date
        R.setStatus("Registered");
        
        entityManager.persist(R);        
        RideProvide rideProvide=entityManager.find(RideProvide.class,"RP001");
        RI.setRideProvide(rideProvide);
        
        entityManager.persist(RI);  
        //error The method findById(RideInfoId) in the type CrudRepository<RideInfo,RideInfoId> is not applicable for the arguments (String)
        Optional<RideInfo> foundRideInfo = rideInfoRepository.findById("ABC123");
        assertTrue(foundRideInfo.isPresent());
    }

    @Test
    public void testFindByVechileNoNegative() {
    	//error The method findById(RideInfoId) in the type CrudRepository<RideInfo,RideInfoId> is not applicable for the arguments (String)
        Optional<RideInfo> notFoundRideInfo = rideInfoRepository.findById("InvalidVechileNo");
        assertFalse(notFoundRideInfo.isPresent());
    }

    @Test
    public void testSavePositive() {
    	RideInfo RI = new RideInfo();
        RI.setVechileNo("ABC123");
        RI.setRpId("RP001");
        RI.setCarType("SUV");
        RI.setCarName("Toyota RAV4");
        RI.setFuelType("Petrol");
        RI.setNoOfSeats(5);
        
        RideProvide R= new RideProvide();
        R.setRpId("RP001");
        R.setAdharcard(123456789012L); // Adjusted to fit within long data type
        R.setFirstName("John");
        R.setLastName("Doe");
        R.setEmailId("john@example.com");
        R.setPhone(1234567890); // Adjusted to fit within int data type
        R.setDlNo("DL12345678901234");
        R.setValidUpto(LocalDate.now().plusDays(31)); // Valid upto 30 days from current date
        R.setStatus("Registered");
        
        entityManager.persist(R);        
        RideProvide rideProvide=entityManager.find(RideProvide.class,"RP001");
        RI.setRideProvide(rideProvide);
        
        entityManager.persist(RI); 
        rideInfoRepository.save(RI);

        //error The method findById(RideInfoId) in the type CrudRepository<RideInfo,RideInfoId> is not applicable for the arguments (String)
        Optional<RideInfo> savedRideInfo = rideInfoRepository.findById("ABC123");
        assertTrue(savedRideInfo.isPresent());
    }

    @Test
    public void testDeletePositive() {
    	RideInfo RI = new RideInfo();
        RI.setVechileNo("ABC123");
        RI.setRpId("RP001");
        RI.setCarType("SUV");
        RI.setCarName("Toyota RAV4");
        RI.setFuelType("Petrol");
        RI.setNoOfSeats(5);
        
        RideProvide R= new RideProvide();
        R.setRpId("RP001");
        R.setAdharcard(123456789012L); // Adjusted to fit within long data type
        R.setFirstName("John");
        R.setLastName("Doe");
        R.setEmailId("john@example.com");
        R.setPhone(1234567890); // Adjusted to fit within int data type
        R.setDlNo("DL12345678901234");
        R.setValidUpto(LocalDate.now().plusDays(31)); // Valid upto 30 days from current date
        R.setStatus("Registered");
        
        entityManager.persist(R);        
        RideProvide rideProvide=entityManager.find(RideProvide.class,"RP001");
        RI.setRideProvide(rideProvide);
        
        entityManager.persist(RI); 

        rideInfoRepository.delete(RI);
        
        //error The method findById(RideInfoId) in the type CrudRepository<RideInfo,RideInfoId> is not applicable for the arguments (String)

        Optional<RideInfo> deletedRideInfo = rideInfoRepository.findById("ABC123");
        assertFalse(deletedRideInfo.isPresent());
    }
}