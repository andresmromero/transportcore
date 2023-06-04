package com.amr.tc.bs.car.carifr.pers.jpa.car;


import com.amr.tc.bs.car.carifr.api.req.CreateCarReq;
import com.amr.tc.bs.car.carpkg.CarApp;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@Testcontainers
@SpringBootTest(classes = {CarApp.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CarJpaRepoTest {

    @Container
    public static MySQLContainer mysql =
            new MySQLContainer().withDatabaseName("test").withUsername("test").withPassword("test");

    @Autowired
    private CarJpaRepo repository;


    @DynamicPropertySource
    static void mysqlProperties(DynamicPropertyRegistry registry) {

        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
    }


    @Test
    @Transactional
    void save() {

        UUID id = UUID.randomUUID();
        CarJpaEnt entity = getCarJpaEnt();
        entity.setCarId(id);

        CarJpaEnt saved = repository.save(entity);
        Optional<CarJpaEnt> found = repository.findById(id);

        assertTrue(found.isPresent());
        assertEquals(entity.getCarId(), found.get().getCarId());
        assertNotNull(saved);
    }


    @Test
    @Transactional
    void deleteById() {

        UUID id = UUID.randomUUID();
        CarJpaEnt entity = getCarJpaEnt();
        entity.setCarId(id);

        CarJpaEnt saved = repository.save(entity);
        repository.deleteById(entity.getCarId());
        Optional<CarJpaEnt> found = repository.findById(id);

        assertTrue(found.isEmpty());

    }


    @Test
    @Transactional
    void getAll() {

        CarJpaEnt firstEntity = getCarJpaEnt();
        CarJpaEnt secondEntity = getCarJpaEnt();

        repository.save(firstEntity);
        repository.save(secondEntity);
        List<CarJpaEnt> carJpaList = repository.findAll();

        assertNotNull(carJpaList);
        assertEquals(2, carJpaList.size());
    }

    @Test
    @Transactional
    void getById() {

        UUID id = UUID.randomUUID();
        CarJpaEnt entity = getCarJpaEnt();
        entity.setCarId(id);

        CarJpaEnt saved = repository.save(entity);
        Optional<CarJpaEnt> found = repository.findById(id);

        assertTrue(found.isPresent());
        assertNotNull(saved);
        assertEquals(entity.getCarId(), found.get().getCarId());
    }

    @Test
    @Transactional
    void UpdateById() {

        UUID id = UUID.randomUUID();
        CarJpaEnt entity = getCarJpaEnt();
        entity.setCarId(id);
        CarJpaEnt newEntity = getCarJpaEnt();
        newEntity.setCarId(id);

        repository.save(entity);
        repository.save(newEntity);
        Optional<CarJpaEnt> found = repository.findById(id);

        assertTrue(found.isPresent());
        assertEquals(found.get(), newEntity);
    }


    private CreateCarReq getCreateCarReq() {

        return CreateCarReq.builder()
                           .carId(UUID.randomUUID())
                           .vimId(UUID.randomUUID())
                           .typeModelId(UUID.randomUUID())
                           .engineId(UUID.randomUUID())
                           .bodyId(UUID.randomUUID())
                           .brakeId(UUID.randomUUID())
                           .suspensionId(UUID.randomUUID())
                           .gearBoxId(UUID.randomUUID())
                           .build();
    }

    private CarJpaEnt getCarJpaEnt() {

        return new CarJpaEnt(UUID.randomUUID(),
                             UUID.randomUUID(),
                             UUID.randomUUID(),
                             UUID.randomUUID(),
                             UUID.randomUUID(),
                             UUID.randomUUID(),
                             UUID.randomUUID(),
                             UUID.randomUUID());

    }

}
