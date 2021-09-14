package ru.dmitrenko.demowebflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import ru.dmitrenko.demowebflux.model.domain.User;

import java.util.UUID;

public interface UserRepository extends ReactiveCrudRepository<User, UUID> {

    Mono<User> findByName(String name);
}
