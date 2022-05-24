package com.security.jwt.service;

import com.security.jwt.enums.Role;
import com.security.jwt.model.User;

import java.util.List;

public interface UserService {

    User saveNormalUser(User user);

    User saveAdminUser(User user);

    User getUser(String username);

    List<User> getUsers();
}
