package br.com.tipotelas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI OpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .version("0.0.1")
                        .title("Documentation API")
                        .description("Essa API foi desenvolvida para permitir cadastros de Tipo de Telas.")
                        .contact(new Contact()
                                .name("Developer Daniel Cavalcante")
                                .email("daniel16henrrique@gmail.com")));
    }

}