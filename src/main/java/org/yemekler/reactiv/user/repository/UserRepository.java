package org.yemekler.reactiv.user.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.yemekler.reactiv.user.modal.Users;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public interface UserRepository extends ReactiveCrudRepository<Users,Integer> {

Mono<Users> findByUsername(String username);

    // İçinde belirli bir harf geçen kullanıcı adlarını bul
    Flux<Users> findByUsernameContaining(String harf);

    Mono<Users> findByUsernameOrEmail(String username, String email); // Kullanıcı adı veya e-posta için sorgu



}
