package org.yemekler.reactiv.user.service;

import org.springframework.stereotype.Service;
import org.yemekler.reactiv.user.exception.UserAlreadyExistsException;
import org.yemekler.reactiv.user.exception.UserCreationException;
import org.yemekler.reactiv.user.exception.UserNotFoundException;
import org.yemekler.reactiv.user.modal.Users;
import org.yemekler.reactiv.user.repository.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<Object> addUser(Users user) {
        return userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail())
                .flatMap(existingUser -> {
                    if (existingUser.getUsername().equals(user.getUsername())) {
                        return Mono.error(new UserAlreadyExistsException("Bu kullanıcı adı zaten mevcut"));
                    } else if (existingUser.getEmail().equals(user.getEmail())) {
                        return Mono.error(new UserAlreadyExistsException("Bu e-posta adresi zaten mevcut"));
                    }
                    return Mono.empty(); // Kullanıcı adı ve e-posta mevcut değil
                })
                .switchIfEmpty(Mono.defer(() -> userRepository.save(user)))
                .onErrorResume(e -> {
                    System.out.println("Hata oluştu: " + e.getMessage());
                    return Mono.error(new UserCreationException("Kullanıcı oluşturulamadı: " + e.getMessage()));
                });
    }

        public Mono<Users> getUserById(Integer id) {
            Mono<Users> user =
                    userRepository.findById(id)
                    .switchIfEmpty(Mono.error(new UserNotFoundException("Kullanıcı bulunamadı")));
            return user;

        }

    public Mono<Users> deleteUser(Integer id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new UserNotFoundException("Kullanıcı bulunamadı")))
                .flatMap(user -> userRepository.deleteById(id).thenReturn(user));
    }
    public Flux<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Mono<Users> updateUser(Integer id, Users user) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new UserNotFoundException("Kullanıcı bulunamadı"))) // Kullanıcı bulunamadığında hata fırlatır
                .flatMap(existingUser -> {
                    existingUser.setUsername(user.getUsername());
                    existingUser.setPassword(user.getPassword());
                    existingUser.setEmail(user.getEmail());
                    return userRepository.save(existingUser);
                });
    }


}
