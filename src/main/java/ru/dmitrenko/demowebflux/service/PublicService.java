package ru.dmitrenko.demowebflux.service;

import reactor.core.publisher.Mono;
import ru.dmitrenko.demowebflux.model.dto.response.UserDetailsResponse;

import java.util.UUID;

public interface PublicService {

    Mono<UserDetailsResponse> getUserDetail(UUID id);
}
