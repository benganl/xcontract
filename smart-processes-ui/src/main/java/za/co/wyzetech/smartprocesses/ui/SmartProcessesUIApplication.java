package za.co.wyzetech.smartprocesses.ui;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Arrays;

@Slf4j
@SpringBootApplication
@EnableAutoConfiguration
@EnableWebMvc
public class SmartProcessesUIApplication {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(SmartProcessesUIApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
            Arrays.asList(ctx.getBeanDefinitionNames()).forEach(b -> {
                log.info(":::::::::: loaded bean: {}", b);
            });
        };
    }
}
