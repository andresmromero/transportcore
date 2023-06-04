package com.amr.tc.bs.car.carifr.api.ctrl;

import com.amr.tc.bs.car.carifr.api.req.CreateCarReq;
import com.amr.tc.bs.car.carifr.pers.jpa.car.CarJpaEnt;
import com.amr.tc.bs.car.carifr.pers.jpa.car.CarJpaRepo;
import com.amr.tc.bs.car.carpkg.CarApp;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@SpringBootTest(classes = {CarApp.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CarCmdCtrlTest {

    @Container
    public static MySQLContainer mysql =
            new MySQLContainer().withDatabaseName("test").withUsername("test").withPassword("test");

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CarJpaRepo carJpaRepo;

    @DynamicPropertySource
    static void mysqlProperties(DynamicPropertyRegistry registry) {

        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
    }

    @Test
    @Transactional
    void shouldCreateCar() throws Exception {

        CreateCarReq getCreateCarReq = getCreateCarReq();
        String request = objectMapper.writeValueAsString(getCreateCarReq);


        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/car")
                                              .contentType(MediaType.APPLICATION_JSON)
                                              .content(request)

                       ).andExpect(status().isCreated());

        Assertions.assertEquals(1, carJpaRepo.findAll().size());

    }


    @Test
    @Transactional
    void shouldUpdateCar() throws Exception {

        UUID id = UUID.randomUUID();
        CreateCarReq getRequest = getCreateCarReq();
        getRequest.setCarId(id);
        String request = objectMapper.writeValueAsString(getRequest);
        CarJpaEnt save = getCarJpaEnt();
        save.setCarId(id);


        carJpaRepo.save(save);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/car/{id}", id)
                                              .contentType(MediaType.APPLICATION_JSON)
                                              .content(request)).andExpect(status().isOk());
        Optional<CarJpaEnt> found = carJpaRepo.findById(id);
        CarJpaEnt mapperFound = new CarJpaEnt();
        BeanUtils.copyProperties(getRequest, mapperFound);

        Assertions.assertTrue(found.isPresent());
        Assertions.assertEquals(found.get(), mapperFound);

    }


    @Test
    @Transactional
    void shouldDeleteCar() throws Exception {

        UUID id = UUID.randomUUID();
        CarJpaEnt save = getCarJpaEnt();
        save.setCarId(id);

        carJpaRepo.save(save);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/car/{id}", id).contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isNoContent());
        Optional<CarJpaEnt> found = carJpaRepo.findById(id);

        Assertions.assertTrue(found.isEmpty());
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
