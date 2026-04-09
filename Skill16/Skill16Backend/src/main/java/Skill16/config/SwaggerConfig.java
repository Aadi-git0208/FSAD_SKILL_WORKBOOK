package Skill16.config;
import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.*;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Student CRUD API")
                        .version("1.0")
                        .description("Swagger Documentation for Student APIs"));
    }
}