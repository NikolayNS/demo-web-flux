package ru.dmitrenko.demowebflux.client;

import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;
import ru.dmitrenko.demowebflux.exception.ClientResponseException;
import ru.dmitrenko.demowebflux.exception.ServerResponseException;

public interface BaseClient {

    <K> Mono<K> get(String url, HttpHeaders headers, Class<K> response) throws ClientResponseException, ServerResponseException;

    <T, K> Mono<T> post(String url, HttpHeaders headers, K body, Class<T> response) throws ClientResponseException, ServerResponseException;

    <T, K> Mono<T> put(String url, HttpHeaders headers, K body, Class<T> response) throws ClientResponseException, ServerResponseException;

    <K> Mono<K> delete(String url, HttpHeaders headers, Class<K> response) throws ClientResponseException, ServerResponseException;
}
