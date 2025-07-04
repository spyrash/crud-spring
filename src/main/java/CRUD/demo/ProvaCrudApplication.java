package CRUD.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class ProvaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvaCrudApplication.class, args);
	}

	@Bean
    protected CommandLineRunner unoCiProva(){
		return args -> {
			System.out.println("Prova Crud Application is running!");
		};
	}
}
