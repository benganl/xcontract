package za.co.wyzetech;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties({ R2dbcProperties.class, FlywayProperties.class })
@EnableR2dbcRepositories(basePackages = { "za.co.wyzetech" })
// @EnableJpaRepositories(basePackages = { "za.co.wyzetech" })
@ComponentScan(basePackages = { "za.co.wyzetech" })
public class SmartProcessesApplication extends ReactiveWebServerApplicationContext {

    public static void main(String[] args) {
	SpringApplication.run(SmartProcessesApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	return args -> { //
	    // Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
	    Arrays.asList(ctx.getBeanDefinitionNames()).forEach(b -> {
		log.info(":::::::::: loaded bean: {}", b);
	    });
	};
    }
//
//    @Bean
//    public NettyReactiveWebServerFactory webServerFactory() {
//	NettyReactiveWebServerFactory factory = new NettyReactiveWebServerFactory();
//	// Customize Netty server configuration here (optional)
//	factory.setPort(8080); // Set the port (optional)
//	return factory;
//    }
//
//    @Bean
//    public WebServerFactoryCustomizer<NettyReactiveWebServerFactory> customizer() {
//	return factory -> {
//	    factory.setPort(8080);
//	};
//    }
}
