package app.car.appcarapi.config;

import org.springframework.context.annotation.Bean;

public class OpenAPIConfig {
    @Bean
    public OpenAPI openAPIDocumentation() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("C.A.R. API")
                                .description("API do sistema C.A.R., de facilitação de mobilidade urbana")
                                .version("v1.0")
                                .contact(new Contact()
                                        .name("Alexandre Saudate")
                                        .description("alesaudate@gmail.com")
                                )
                );
    }
}
