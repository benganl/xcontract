package za.co.wyzetech.cms.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import za.co.wyzetech.cms.config.KeycloakServerProperties;

@SpringBootApplication(exclude = LiquibaseAutoConfiguration.class)
@EnableConfigurationProperties(KeycloakServerProperties.class)
public class AuthorizationServerApp {
    private static final Logger LOG = LoggerFactory.getLogger(AuthorizationServerApp.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AuthorizationServerApp.class, args);
    }


}