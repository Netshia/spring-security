package com.ndivhuho.springsecurity.controller;

import com.ndivhuho.springsecurity.model.AppUser;
import com.ndivhuho.springsecurity.model.Role;
import com.ndivhuho.springsecurity.service.AppUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @RequestMapping("/users")
    private ResponseEntity<List<AppUser>> getUsers() {
        List<AppUser> users = appUserService.getUsers();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/user/save")
    private ResponseEntity<AppUser> saveUsers(@RequestBody AppUser user) {
        AppUser appUser = appUserService.saveUser(user);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(appUser);
    }

    @PostMapping("/role/save")
    private ResponseEntity<Role> saveUsers(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    private ResponseEntity<Role> saveRole(@RequestBody RoleToUserForm form) {
        appUserService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}
