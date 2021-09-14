package ru.dmitrenko.demowebflux.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
@Validated
public class UserAddRequest {

    @NotBlank(message = "Field [name] must be present")
    private String name;

    @NotBlank(message = "Field [password] must be present")
    private String password;

    @NotBlank(message = "Field [phone] must be present")
    private String phone;

    @NotBlank(message = "Field [mail] must be present")
    private String mail;
}
