package id.mbingweb.hctest.config;

import com.google.common.base.Predicates;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author fqodry
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .paths(Predicates.not(PathSelectors.regex("/error/*")))
            .paths(Predicates.not(PathSelectors.regex("/actuator")))
            .build()
            .apiInfo(apiInfo());
    }
    
    private ApiInfo apiInfo() {
        Contact contact = new Contact(
            "Firman Qodry",
            "http://mbing.web.id",
            "firman.qodry@gmail.com");
        
        return new ApiInfo(
            "HomeCredit Technical Test", 
            "Technical Test untuk HomeCredit", 
            "Version 0.0.1", 
            "For Special Purpose Only", 
            contact, 
            "MIT", 
            "(license url empty)", 
            Collections.emptyList());
    }
}
