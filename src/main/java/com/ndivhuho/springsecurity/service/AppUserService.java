package com.ndivhuho.springsecurity.service;

import com.ndivhuho.springsecurity.model.AppUser;
import com.ndivhuho.springsecurity.model.Role;

import java.util.List;

public interface AppUserService {

    AppUser saveUser(AppUser user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    AppUser getUser(String username);

    List<AppUser> getUsers();
}
