package ru.dmitrenko.demowebflux.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.dmitrenko.demowebflux.model.dto.response.UserDetailsResponse;
import ru.dmitrenko.demowebflux.service.PublicService;
import ru.dmitrenko.demowebflux.service.domain.UserService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PublicServiceImpl implements PublicService {

    private final UserService userService;

    @Override
    public Mono<UserDetailsResponse> getUserDetail(UUID id) {
        return userService.getUserDetail(id);
    }
}
