package com.resonance.main;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.resonance.data.repo.UserRepository;
import com.resonance.entities.Role;
import com.resonance.entities.User;
import com.resonance.security.config.CustomUserDetails;
import com.resonance.service.processor.UserService;

@SpringBootApplication(scanBasePackages= {"com.resonance.controllers.impl","com.resonance.controllers", "com.resonance.configuration", "com.resonance.service.processor", "com.resonance.service.processor.impl","com.resonance.data.configuration","com.resonance.helper", "com.resonance.helper.generic", "com.resonance.api.elements", "com.resonance.api.tests", "com.resonance.security.config", "com.resonance.filter"}, exclude={MongoAutoConfiguration.class})
public class App {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, UserService service) throws Exception {
		if (repository.count()==0)
			service.save(new User("user", "user", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
		builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);;
	}
	
	private UserDetailsService userDetailsService(final UserRepository repository) {
		return username -> new CustomUserDetails(repository.findByUsername(username));
	}
}

