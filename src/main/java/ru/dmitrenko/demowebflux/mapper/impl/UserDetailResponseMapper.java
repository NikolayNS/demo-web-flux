package ru.dmitrenko.demowebflux.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dmitrenko.demowebflux.mapper.Mapper;
import ru.dmitrenko.demowebflux.model.domain.User;
import ru.dmitrenko.demowebflux.model.dto.response.UserDetailsResponse;

@Service
@RequiredArgsConstructor
public class UserDetailResponseMapper implements Mapper<UserDetailsResponse, User> {

    @Override
    public UserDetailsResponse from(User source) {
        return new UserDetailsResponse()
                .setName(source.getName())
                .setPhone(source.getPhone())
                .setMail(source.getMail())
                .setCreatedAt(source.getCreatedAt());
    }
}
