package ru.dmitrenko.demowebflux.service.domain.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import ru.dmitrenko.demowebflux.mapper.impl.UserDetailResponseMapper;
import ru.dmitrenko.demowebflux.mapper.impl.UserMapper;
import ru.dmitrenko.demowebflux.model.dto.request.UserAddRequest;
import ru.dmitrenko.demowebflux.model.dto.response.UserDetailsResponse;
import ru.dmitrenko.demowebflux.repository.UserRepository;
import ru.dmitrenko.demowebflux.service.domain.UserService;

import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;
    private final UserDetailResponseMapper userDetailResponseMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Mono<UserDetailsResponse> add(UserAddRequest request) {
        return null;
        /*return Mono.just(request)
                .filter(o -> Boolean.FALSE.equals(userRepository.existsByName(o.getName()).block()))
                .map(o -> {
                    var user = userMapper.from(o);
                    return userDetailResponseMapper.from(Objects.requireNonNull(userRepository.save(user).block()));
                });*/
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<UserDetailsResponse> getUserDetail(UUID id) {
        return userRepository
                .findById(id)
                .map(userDetailResponseMapper::from)
                .doOnError(ex -> log.warn("User with id {} not found, ex {}", id, ex));
    }
}
