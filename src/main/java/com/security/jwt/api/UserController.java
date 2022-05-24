package com.security.jwt.api;

import com.security.jwt.model.User;
import com.security.jwt.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/normal-user")
    public ResponseEntity<User> createNormalUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.saveNormalUser(user));
    }

    @PostMapping("/admin-user")
    public ResponseEntity<User> createAdminUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.saveAdminUser(user));
    }

}
