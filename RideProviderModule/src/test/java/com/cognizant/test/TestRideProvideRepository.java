package com.cognizant.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.entities.RideProvide;
import com.cognizant.main.RideProviderModuleApplication;
import com.cognizant.repositories.RideProvideRepository;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ContextConfiguration(classes = RideProviderModuleApplication.class)
public class TestRideProvideRepository {

    @Autowired
    private RideProvideRepository rideProvideRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindAllPositive() {
        RideProvide rideProvide = new RideProvide();
        rideProvide.setRpId("RP001");
        rideProvide.setFirstName("John");
        rideProvide.setLastName("Doe");
        rideProvide.setEmailId("john@example.com");
        rideProvide.setAdharcard(123456789012L); // Adjusted to fit within long data type
        rideProvide.setPhone(1234567890); // Adjusted to fit within int data type
        rideProvide.setDlNo("DL12345678901234");
        rideProvide.setValidUpto(LocalDate.now().plusDays(31)); // Valid upto 30 days from current date
        rideProvide.setStatus("Registered");
        entityManager.persist(rideProvide);

        Iterable<RideProvide> it = rideProvideRepository.findAll();
        assertTrue(it.iterator().hasNext());
    }

    @Test
    public void testFindAllNegative() {
        Iterable<RideProvide> it = rideProvideRepository.findAll();
        assertFalse(it.iterator().hasNext());
    }

    @Test
    public void testFindByIdPositive() {
        RideProvide rideProvide = new RideProvide();
        rideProvide.setRpId("RP001");
        rideProvide.setAdharcard(123456789012L); // Adjusted to fit within long data type
        rideProvide.setFirstName("John");
        rideProvide.setLastName("Doe");
        rideProvide.setEmailId("john@example.com");
        rideProvide.setPhone(1234567890); // Adjusted to fit within int data type
        rideProvide.setDlNo("DL12345678901234");
        rideProvide.setValidUpto(LocalDate.now().plusDays(31)); // Valid upto 30 days from current date
        rideProvide.setStatus("Registered");
        entityManager.persist(rideProvide);

        Optional<RideProvide> foundRideProvide = rideProvideRepository.findById("RP001");
        assertTrue(foundRideProvide.isPresent());
    }

    @Test
    public void testFindByIdNegative() {
        Optional<RideProvide> notFoundRideProvide = rideProvideRepository.findById("InvalidRpId");
        assertFalse(notFoundRideProvide.isPresent());
    }

    @Test
    public void testSavePositive() {
        RideProvide rideProvide = new RideProvide();
        rideProvide.setRpId("RP001");
        rideProvide.setAdharcard(123456789012L); // Adjusted to fit within long data type
        rideProvide.setFirstName("John");
        rideProvide.setLastName("Doe");
        rideProvide.setEmailId("john@example.com");
        rideProvide.setPhone(1234567890); // Adjusted to fit within int data type
        rideProvide.setDlNo("DL12345678901234");
        rideProvide.setValidUpto(LocalDate.now().plusDays(31)); // Valid upto 30 days from current date
        rideProvide.setStatus("Registered");
        rideProvideRepository.save(rideProvide);

        Optional<RideProvide> savedRideProvide = rideProvideRepository.findById("RP001");
        assertTrue(savedRideProvide.isPresent());
    }

    @Test
    public void testDeletePositive() {
        RideProvide rideProvide = new RideProvide();
        rideProvide.setRpId("RP001");
        rideProvide.setFirstName("John");
        rideProvide.setLastName("Doe");
        rideProvide.setEmailId("john@example.com");
        rideProvide.setAdharcard(123456789012L); // Adjusted to fit within long data type
        rideProvide.setPhone(1234567890); // Adjusted to fit within int data type
        rideProvide.setDlNo("DL12345678901234");
        rideProvide.setValidUpto(LocalDate.now().plusDays(31)); // Valid upto 30 days from current date
        rideProvide.setStatus("Registered");
        entityManager.persist(rideProvide);

        rideProvideRepository.delete(rideProvide);

        Optional<RideProvide> deletedRideProvide = rideProvideRepository.findById("RP001");
        assertFalse(deletedRideProvide.isPresent());
    }
}