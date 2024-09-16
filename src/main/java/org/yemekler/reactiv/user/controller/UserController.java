
package org.yemekler.reactiv.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yemekler.reactiv.user.exception.UserCreationException;
import org.yemekler.reactiv.user.modal.Users;
import org.yemekler.reactiv.user.repository.UserRepository;
import org.yemekler.reactiv.user.service.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
    public class UserController {

        private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
            this.userService = userService;
        this.userRepository = userRepository;
    }


    @PostMapping("/add-user")
    public Mono<Object> addUser(@RequestBody Users user) {
        return userService.addUser(user);
    }


        @GetMapping("/get-users")
        public Flux<Users> getAllUsers() {
            return userService.getAllUsers();
        }

        @GetMapping("get-user/{id}")
        public Mono<Users> getUserById(@PathVariable Integer id) {
            return userService.getUserById(id);
        }

        @DeleteMapping("delete-user/{id}")
        public Mono<Users> deleteUser(@PathVariable Integer id) {
            return userService.deleteUser(id);
        }

        @PutMapping("/update-user/{id}")
        public Mono<Users> updateUser(@RequestBody Users user, @PathVariable Integer id) {
            return userService.updateUser(id, user);
        }
    }
