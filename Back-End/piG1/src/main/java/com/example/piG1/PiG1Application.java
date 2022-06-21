package com.example.piG1;

import com.example.piG1.Model.Entity.Role;
import com.example.piG1.Model.Entity.User;
import com.example.piG1.Service.UserServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class PiG1Application {

	public static void main(String[] args) {
		SpringApplication.run(PiG1Application.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserServices userServices) {
		return args -> {
			userServices.saveRole(new Role(null,"ADMIN"));
			userServices.saveRole(new Role(null,"CLIENT"));

			userServices.saveUser(new User(null, "Flor ","Garcia","flor","1234", new ArrayList<>()));
			userServices.saveUser(new User(null, "Eze ","Mardaras","eze","1234", new ArrayList<>()));

			userServices.addRoleToUser("flor", "ADMIN");
			userServices.addRoleToUser("eze", "CLIENT");
		};
	}
}