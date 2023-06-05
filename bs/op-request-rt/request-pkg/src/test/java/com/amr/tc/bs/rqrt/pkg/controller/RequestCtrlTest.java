package com.amr.tc.bs.rqrt.pkg.controller;

import com.amr.tc.bs.rqrt.pkg.RequestRouteApp;
import com.amr.tc.bs.rqrt.pkg.controller.request.CreateRequestItemReq;
import com.amr.tc.bs.rqrt.pkg.controller.request.CreateRequestReq;
import com.amr.tc.bs.rqrt.pkg.model.RequestCarItemJpaEnt;
import com.amr.tc.bs.rqrt.pkg.model.RequestJpaEnt;
import com.amr.tc.bs.rqrt.pkg.model.repository.RequestJpaRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@SpringBootTest(classes = {RequestRouteApp.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RequestCtrlTest {


    @Container
    public static MySQLContainer mysql =
            new MySQLContainer().withDatabaseName("test").withUsername("test").withPassword("test");


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RequestJpaRepo requestJpaRepo;


    @DynamicPropertySource
    static void mysqlProperties(DynamicPropertyRegistry registry) {

        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
    }


    @Test
    @Transactional
    void shouldCreateCar() throws Exception {

        CreateRequestReq getRequest = gerRequest();
        String request = objectMapper.writeValueAsString(getRequest);


        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/request")
                                              .contentType(MediaType.APPLICATION_JSON)
                                              .content(request)

                       ).andExpect(status().isCreated());

        Assertions.assertEquals(1, requestJpaRepo.findAll().size());

    }

    private CreateRequestReq gerRequest() {


        List<CreateRequestItemReq> item = List.of(CreateRequestItemReq.builder()
                                                                      .requestCarItemId(UUID.randomUUID())
                                                                      .price(new BigDecimal("5.25"))
                                                                      .quantity(1)
                                                                      .build());

        return CreateRequestReq.builder()
                               .requestId(UUID.randomUUID())
                               .trackingId(UUID.randomUUID())
                               .carItems(item)
                               .build();
    }

    private RequestJpaEnt getCarJpaEnt() {

        List<RequestCarItemJpaEnt> item = List.of(RequestCarItemJpaEnt.builder()
                                                                      .requestCarItemId(UUID.randomUUID())
                                                                      .price(new BigDecimal("5.25"))
                                                                      .quantity(1)
                                                                      .build());

        return RequestJpaEnt.builder()
                            .requestId(UUID.randomUUID())
                            .trackingId(UUID.randomUUID())
                            .carItems(item)
                            .build();
    }

}
