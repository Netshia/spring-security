package com.ndivhuho.springsecurity.config;

import com.ndivhuho.springsecurity.model.AppUser;
import com.ndivhuho.springsecurity.model.Role;
import com.ndivhuho.springsecurity.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@Configuration
public class GeneralAppConfig {

    @Bean
    CommandLineRunner run(AppUserService appUserService) {
        return args -> {
            appUserService.saveRole(new Role(null, "ROLE_USER"));
            appUserService.saveRole(new Role(null, "ROLE_MANAGER"));
            appUserService.saveRole(new Role(null, "ROLE_ADMIN"));
            appUserService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            appUserService.saveUser(new AppUser(null, "John Travolta", "john", "1234", new ArrayList<>()));
            appUserService.saveUser(new AppUser(null, "Will Smith", "will", "1234", new ArrayList<>()));
            appUserService.saveUser(new AppUser(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
            appUserService.saveUser(new AppUser(null, "Arnold Schwarzenegger", "arnold", "1234", new ArrayList<>()));

            appUserService.addRoleToUser("john", "ROLE_USER");
            appUserService.addRoleToUser("john", "ROLE_MANAGER");
            appUserService.addRoleToUser("will", "ROLE_MANAGER");
            appUserService.addRoleToUser("jim", "ROLE_ADMIN");
            appUserService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
            appUserService.addRoleToUser("arnold", "ROLE_ADMIN");
            appUserService.addRoleToUser("arnold", "ROLE_USER");
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
