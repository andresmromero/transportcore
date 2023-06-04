package com.amr.tc.bs.car.carifr.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Andres Mauricio Romero L",
                        email = "andresmromero7@gmail.com"

                ),
                description = "OpenApi documentation for car",
                title = "OpenApi - Car",
                version= "1.0"

        ),
        servers = {
                @Server(
                        description = "Development environment",
                        url = "http://localhost:1111"
                )
        }
)
public class SwaggerConfig {

}
