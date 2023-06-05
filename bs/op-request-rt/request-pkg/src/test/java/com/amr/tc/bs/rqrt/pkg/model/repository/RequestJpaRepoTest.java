package com.amr.tc.bs.rqrt.pkg.model.repository;

import com.amr.tc.bs.rqrt.pkg.RequestRouteApp;
import com.amr.tc.bs.rqrt.pkg.model.RequestCarItemJpaEnt;
import com.amr.tc.bs.rqrt.pkg.model.RequestJpaEnt;
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

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@SpringBootTest(classes = {RequestRouteApp.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RequestJpaRepoTest {

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
    void save() {

        UUID id = UUID.randomUUID();
        RequestJpaEnt entity = getCarJpaEnt();
        entity.setRequestId(id);

        RequestJpaEnt saved = requestJpaRepo.save(entity);
        Optional<RequestJpaEnt> found = requestJpaRepo.findById(id);

        assertTrue(found.isPresent());
        assertEquals(entity.getRequestId(), found.get().getRequestId());
        assertNotNull(saved);
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
