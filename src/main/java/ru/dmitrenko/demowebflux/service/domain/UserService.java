package ru.dmitrenko.demowebflux.service.domain;

import reactor.core.publisher.Mono;
import ru.dmitrenko.demowebflux.model.dto.request.UserAddRequest;
import ru.dmitrenko.demowebflux.model.dto.response.UserDetailsResponse;

import java.util.UUID;

public interface UserService {

    Mono<UserDetailsResponse> add(UserAddRequest request);

    Mono<UserDetailsResponse> getUserDetail(UUID id);
}
