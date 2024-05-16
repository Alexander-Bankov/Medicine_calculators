package com.example.medicine.calculators.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Medicine",
                description = "Medicine Calculators", version = "1.0.0",
                contact = @Contact(
                        name = "Bankov Alexander",
                        email = "1bankov2003@mail.ru"
                )
        )
)

public class OpenApiConfig {
}
