package ru.dmitrenko.demowebflux.model.dto.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class UserDetailsResponse {
    private String name;
    private String phone;
    private String mail;
    private LocalDateTime createdAt;
}
