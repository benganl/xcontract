package za.co.wyzetech.cms.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpServletResponse;
import za.co.wyzetech.cms.security.SecurityService;
import za.co.wyzetech.cms.security.filter.AuthenticationFilter;

@Configuration
@EnableWebSecurity
class SecurityConfig {

    private final AuthenticationFilter authenticationFilter;
    private final UserDetailsService userDetailsService;

    public SecurityConfig(AuthenticationFilter authenticationFilter, UserDetailsService userDetailsService) {
	this.authenticationFilter = authenticationFilter;
	this.userDetailsService = userDetailsService;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
	AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
	authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	return authenticationManagerBuilder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, SecurityService securityService) throws Exception {
	http
	.csrf(csrf -> csrf.disable())
	.sessionManagement(sessionManagement -> {
	    sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	})
	.authorizeHttpRequests(requests -> {
	    requests.requestMatchers("/svc/**").authenticated().anyRequest().permitAll();
	})
	.userDetailsService(userDetailsService)
	.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
	
	return http.build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurer() {
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*");
	    }
	};
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
	return (request, response, authentication) -> response.setStatus(HttpServletResponse.SC_OK);
    }
}
