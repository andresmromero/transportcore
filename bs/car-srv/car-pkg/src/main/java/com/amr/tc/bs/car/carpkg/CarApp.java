package com.amr.tc.bs.car.carpkg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.amr.tc.bs.car.*")
@EntityScan(basePackages = {"com.amr.tc.bs.car.*", "com.amr.tc.shared.shdbs.*"})
@SpringBootApplication(scanBasePackages = {"com.amr.tc.bs.car.*"})

public class CarApp {

    public static void main(String[] args) {

        SpringApplication.run(CarApp.class, args);

    }

}