package ru.dmitrenko.demowebflux.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;


@Table("APP_USER")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class User extends BaseEntity{

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String phone;

    @Column
    private String mail;

    @Override
    public User setId(UUID id) {
        super.setId(id);
        return this;
    }

    @Override
    public User setCreatedAt(LocalDateTime createdAt) {
        super.setCreatedAt(createdAt);
        return this;
    }

    @Override
    public User setUpdatedAt(LocalDateTime updatedAt) {
        super.setUpdatedAt(updatedAt);
        return this;
    }
}

