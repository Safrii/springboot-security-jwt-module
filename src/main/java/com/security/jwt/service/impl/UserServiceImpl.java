package com.security.jwt.service.impl;

import com.security.jwt.enums.Role;
import com.security.jwt.model.User;
import com.security.jwt.repository.UserRepository;
import com.security.jwt.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveNormalUser(User user) {
        user.setRole(Role.ROLE_USER);
        return userRepository.save(user);
    }

    @Override
    public User saveAdminUser(User user) {
        user.setRole(Role.ROLE_ADMIN);
        return userRepository.save(user);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
