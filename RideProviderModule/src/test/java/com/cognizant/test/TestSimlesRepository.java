package com.cognizant.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.entities.RideInfo;
import com.cognizant.entities.RideProvide;
import com.cognizant.main.RideProviderModuleApplication;
import com.cognizant.repositories.RideProvideRepository;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.cognizant.entities.Simles;
import com.cognizant.repositories.SimlesRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ContextConfiguration(classes = RideProviderModuleApplication.class)
public class TestSimlesRepository {

    @Autowired
    private SimlesRepository simlesRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindAllPositive() {
    	
        Simles simles = new Simles();
        simles.setSmileId(1);
        simles.setRpId("RP001"); // Assuming RP001 exists as a valid foreign key
        simles.setSource("Source");
        simles.setDestination("Destination");
        simles.setOccupancy(3);
        
        //ride info
        RideInfo RI = new RideInfo();
        RI.setVechileNo("ABC123");
        RI.setRpId("RP001");
        RI.setCarType("SUV");
        RI.setCarName("Tgoyota RAV4");
        RI.setFuelType("Petrol");
        RI.setNoOfSeats(5);
        
        //ride provide
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
        RideInfo rideInfo=entityManager.find(RideInfo.class,"ABC123" );
        simles.setRideInfo(rideInfo);
        
        
        entityManager.persist(simles);

        Iterable<Simles> it = simlesRepository.findAll();
        assertTrue(it.iterator().hasNext());
    }

    @Test
    public void testFindAllNegative() {
        Iterable<Simles> it = simlesRepository.findAll();
        assertFalse(it.iterator().hasNext());
    }

    @Test
    public void testFindBySmileIdPositive() {
    	Simles simles = new Simles();
        simles.setSmileId(1);
        simles.setRpId("RP001"); // Assuming RP001 exists as a valid foreign key
        simles.setSource("Source");
        simles.setDestination("Destination");
        simles.setOccupancy(3);
        
        //ride info
        RideInfo RI = new RideInfo();
        RI.setVechileNo("ABC123");
        RI.setRpId("RP001");
        RI.setCarType("SUV");
        RI.setCarName("Tgoyota RAV4");
        RI.setFuelType("Petrol");
        RI.setNoOfSeats(5);
        
        //ride provide
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
        RideInfo rideInfo=entityManager.find(RideInfo.class,"ABC123" );
        simles.setRideInfo(rideInfo);
        
        
        entityManager.persist(simles);


        Optional<Simles> foundSimles = simlesRepository.findById(1);
        assertTrue(foundSimles.isPresent());
    }

    @Test
    public void testFindBySmileIdNegative() {
        Optional<Simles> notFoundSimles = simlesRepository.findById(9999);
        assertFalse(notFoundSimles.isPresent());
    }

    @Test
    public void testSavePositive() {
    	Simles simles = new Simles();
        simles.setSmileId(1);
        simles.setRpId("RP001"); // Assuming RP001 exists as a valid foreign key
        simles.setSource("Source");
        simles.setDestination("Destination");
        simles.setOccupancy(3);
        
        //ride info
        RideInfo RI = new RideInfo();
        RI.setVechileNo("ABC123");
        RI.setRpId("RP001");
        RI.setCarType("SUV");
        RI.setCarName("Tgoyota RAV4");
        RI.setFuelType("Petrol");
        RI.setNoOfSeats(5);
        
        //ride provide
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
        RideInfo rideInfo=entityManager.find(RideInfo.class,"ABC123" );
        simles.setRideInfo(rideInfo);
        
        
        entityManager.persist(simles);

        simlesRepository.save(simles);

        Optional<Simles> savedSimles = simlesRepository.findById(1);
        assertTrue(savedSimles.isPresent());
    }

    @Test
    public void testDeletePositive() {
    	Simles simles = new Simles();
        simles.setSmileId(1);
        simles.setRpId("RP001"); // Assuming RP001 exists as a valid foreign key
        simles.setSource("Source");
        simles.setDestination("Destination");
        simles.setOccupancy(3);
        
        //ride info
        RideInfo RI = new RideInfo();
        RI.setVechileNo("ABC123");
        RI.setRpId("RP001");
        RI.setCarType("SUV");
        RI.setCarName("Tgoyota RAV4");
        RI.setFuelType("Petrol");
        RI.setNoOfSeats(5);
        
        //ride provide
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
        RideInfo rideInfo=entityManager.find(RideInfo.class,"ABC123" );
        simles.setRideInfo(rideInfo);
        
        
        entityManager.persist(simles);


        simlesRepository.delete(simles);

        Optional<Simles> deletedSimles = simlesRepository.findById(1);
        assertFalse(deletedSimles.isPresent());
    }

   
}