package CRUD.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    // Bean get injected into spring container
    public RestTemplate restTemplate() {

        //Configure rest template if needed
        return new RestTemplate();
    }
}
