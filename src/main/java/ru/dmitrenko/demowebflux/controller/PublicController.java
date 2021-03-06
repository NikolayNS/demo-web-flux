package ru.dmitrenko.demowebflux.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.dmitrenko.demowebflux.model.dto.response.UserDetailsResponse;
import ru.dmitrenko.demowebflux.service.PublicService;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.dmitrenko.demowebflux.util.ConstantEndPoint.GET_USER_DETAIL;
import static ru.dmitrenko.demowebflux.util.ConstantEndPoint.FIRST_VERSION;

@RequestMapping(FIRST_VERSION)
@RestController
@RequiredArgsConstructor
public class PublicController {

    private final PublicService publicService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = GET_USER_DETAIL, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Mono<UserDetailsResponse> getUserDetails(@PathVariable UUID id) {
        return publicService.getUserDetail(id);
    }
}
