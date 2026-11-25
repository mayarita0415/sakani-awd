
package tn.esprit.microservice2.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI annonceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sakani - Annonce Service API")
                        .description("Microservice 2 : Gestion des annonces de logements etudiants")
                        .version("1.0"));
    }
}
