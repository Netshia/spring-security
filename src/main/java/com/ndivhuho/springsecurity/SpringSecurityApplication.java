package com.ndivhuho.springsecurity;

import com.ndivhuho.springsecurity.model.AppUser;
import com.ndivhuho.springsecurity.model.Role;
import com.ndivhuho.springsecurity.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}
}
