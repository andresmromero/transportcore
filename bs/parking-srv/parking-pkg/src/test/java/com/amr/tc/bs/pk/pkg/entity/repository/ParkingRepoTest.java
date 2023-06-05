package com.amr.tc.bs.pk.pkg.entity.repository;

import com.amr.tc.bs.pk.pkg.ParkingApp;
import com.amr.tc.bs.pk.pkg.controller.response.ParkedStatusRes;
import com.amr.tc.bs.pk.pkg.entity.ParkingJpaEnt;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@SpringBootTest(classes = {ParkingApp.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ParkingRepoTest {


    @Container
    public static MySQLContainer mysql =
            new MySQLContainer().withDatabaseName("test").withUsername("test").withPassword("test");

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ParkingRepo parkingRepo;

    @DynamicPropertySource
    static void mysqlProperties(DynamicPropertyRegistry registry) {

        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
    }


    @Test
    @Transactional
    void findByParkedIdIn() throws Exception {

        UUID firstUUID = UUID.fromString("53e1cd98-b44d-4a6e-87ad-e63abd6ac1af");
        UUID secondUUID = UUID.fromString("6bfc394b-a4bf-4ac7-ac64-ef3a5733c156");

        ParkingJpaEnt firstEntity =
                ParkingJpaEnt.builder().parkingId(UUID.randomUUID()).parkedId(firstUUID).quantity(5).build();

        ParkingJpaEnt secondEntity =
                ParkingJpaEnt.builder().parkingId(UUID.randomUUID()).parkedId(secondUUID).quantity(5).build();

        parkingRepo.save(firstEntity);
        parkingRepo.save(secondEntity);

        List<ParkingJpaEnt> res = parkingRepo.findByParkedIdIn(List.of(firstUUID, secondUUID));

        assertEquals(firstEntity.getParkedId(), res.get(0).getParkedId());
        assertEquals(secondEntity.getParkedId(), res.get(1).getParkedId());

    }


}
