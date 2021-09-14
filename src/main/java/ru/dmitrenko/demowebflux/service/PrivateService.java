package ru.dmitrenko.demowebflux.service;

import reactor.core.publisher.Mono;
import ru.dmitrenko.demowebflux.model.dto.request.UserAddRequest;
import ru.dmitrenko.demowebflux.model.dto.response.UserDetailsResponse;

public interface PrivateService {

    Mono<UserDetailsResponse> addUser(UserAddRequest request);
}
