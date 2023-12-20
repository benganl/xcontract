package za.co.wyzetech.smartprocesses.ui;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableAutoConfiguration
@EnableWebMvc
public class SmartProcessesUIApplication {

    public static void main(String[] args) {
	SpringApplication.run(SmartProcessesUIApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	return args -> {
	    Arrays.asList(ctx.getBeanDefinitionNames()).forEach(b -> {
		log.info(":::::::::: loaded bean: {}", b);
	    });
	};
    }
}
