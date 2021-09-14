package ru.dmitrenko.demowebflux.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.dmitrenko.demowebflux.model.dto.request.UserAddRequest;
import ru.dmitrenko.demowebflux.model.dto.response.UserDetailsResponse;
import ru.dmitrenko.demowebflux.service.PrivateService;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.dmitrenko.demowebflux.util.ConstantEndPoint.ADD_USER;
import static ru.dmitrenko.demowebflux.util.ConstantEndPoint.FIRST_VERSION;

@RequestMapping(FIRST_VERSION)
@RestController
@RequiredArgsConstructor
public class PrivateController {

    private final PrivateService privateService;

    @GetMapping(value = ADD_USER, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Mono<UserDetailsResponse> addUser(@RequestBody @Valid UserAddRequest request) {
        return privateService.addUser(request);
    }
}
