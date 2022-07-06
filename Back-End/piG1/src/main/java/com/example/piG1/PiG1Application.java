package com.example.piG1;

import com.example.piG1.Model.Entity.Role;
import com.example.piG1.Service.UserServices;
import com.example.piG1.Service.RoleServices;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PiG1Application {

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(PiG1Application.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserServices userServices, RoleServices roleServices) {
		return args -> {
			if (roleServices.findRoleByName("ADMIN") == null || roleServices.findRoleByName("CLIENT") == null){
			userServices.saveRole(new Role(null,"ADMIN"));
			userServices.saveRole(new Role(null,"CLIENT"));
			}
		};
	}
}