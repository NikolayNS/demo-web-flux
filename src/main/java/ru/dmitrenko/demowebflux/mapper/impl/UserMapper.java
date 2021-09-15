package ru.dmitrenko.demowebflux.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dmitrenko.demowebflux.mapper.Mapper;
import ru.dmitrenko.demowebflux.model.domain.User;
import ru.dmitrenko.demowebflux.model.dto.request.UserAddRequest;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserMapper implements Mapper<User, UserAddRequest> {

    @Override
    public User from(UserAddRequest source) {
        return new User()
                .setId(UUID.randomUUID())
                .setName(source.getName())
                .setPassword(source.getPassword())
                .setPhone(source.getPhone())
                .setMail(source.getMail())
                .setCreatedAt(LocalDateTime.now())
                .setUpdatedAt(LocalDateTime.now());
    }
}
