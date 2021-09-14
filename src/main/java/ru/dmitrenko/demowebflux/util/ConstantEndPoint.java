package ru.dmitrenko.demowebflux.util;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ConstantEndPoint {

    public static final String FIRST_VERSION = "/v1";

    public static final String GET_USER_DETAIL = "/public/user/{id}/get-detail";



    public static final String ADD_USER = "/private/user";
}
