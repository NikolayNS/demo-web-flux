package ru.dmitrenko.demowebflux.service.domain.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import ru.dmitrenko.demowebflux.mapper.impl.UserDetailResponseMapper;
import ru.dmitrenko.demowebflux.model.dto.request.UserAddRequest;
import ru.dmitrenko.demowebflux.model.dto.response.UserDetailsResponse;
import ru.dmitrenko.demowebflux.repository.UserRepository;
import ru.dmitrenko.demowebflux.service.domain.UserService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserDetailResponseMapper userDetailResponseMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Mono<UserDetailsResponse> add(UserAddRequest request) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<UserDetailsResponse> getUserDetail(UUID id) {
        return userRepository
                .findById(id)
                .map(userDetailResponseMapper::from);
    }
}
