package ru.dmitrenko.demowebflux.client.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import ru.dmitrenko.demowebflux.client.BaseClient;
import ru.dmitrenko.demowebflux.exception.ClientResponseException;
import ru.dmitrenko.demowebflux.exception.ServerResponseException;

@Slf4j
@Service
@RequiredArgsConstructor
public class BaseClientImpl implements BaseClient {

    private final WebClient webClient;

    @Override
    public <K> Mono<K> get(String url, HttpHeaders headers, Class<K> response) throws ClientResponseException, ServerResponseException {
        return webClient
                .get()
                .uri(UriComponentsBuilder.fromHttpUrl(url).build().toUri())
                .accept(MediaType.APPLICATION_JSON)
                .headers(o -> o.addAll(headers))
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, this::clientExceptionResponse)
                .onStatus(HttpStatus::is5xxServerError, this::serverExceptionResponse)
                .bodyToMono(response);
    }

    @Override
    public <T, K> Mono<T> post(String url, HttpHeaders headers, K body, Class<T> response) throws ClientResponseException, ServerResponseException {
        return webClient
                .post()
                .uri(UriComponentsBuilder.fromHttpUrl(url).build().toUri())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(o -> o.addAll(headers))
                .body(Mono.just(body), body.getClass())
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, this::clientExceptionResponse)
                .onStatus(HttpStatus::is5xxServerError, this::serverExceptionResponse)
                .bodyToMono(response);
    }

    @Override
    public <T, K> Mono<T> put(String url, HttpHeaders headers, K body, Class<T> response) throws ClientResponseException, ServerResponseException {
        return webClient
                .put()
                .uri(UriComponentsBuilder.fromHttpUrl(url).build().toUri())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .headers(o -> o.addAll(headers))
                .body(Mono.just(body), body.getClass())
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, this::clientExceptionResponse)
                .onStatus(HttpStatus::is5xxServerError, this::serverExceptionResponse)
                .bodyToMono(response);
    }

    @Override
    public <K> Mono<K> delete(String url, HttpHeaders headers, Class<K> response) throws ClientResponseException, ServerResponseException {
        return webClient
                .delete()
                .uri(UriComponentsBuilder.fromHttpUrl(url).build().toUri())
                .accept(MediaType.APPLICATION_JSON)
                .headers(o -> o.addAll(headers))
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, this::clientExceptionResponse)
                .onStatus(HttpStatus::is5xxServerError, this::serverExceptionResponse)
                .bodyToMono(response);
    }

    private Mono<? extends Exception> clientExceptionResponse(ClientResponse response) {
        return response
                .bodyToMono(String.class)
                .map(body -> new ClientResponseException(response.statusCode(), response.headers().asHttpHeaders(), body));
    }

    private Mono<? extends Exception> serverExceptionResponse(ClientResponse response) {
        return response
                .bodyToMono(String.class)
                .map(body -> new ServerResponseException(response.statusCode(), response.headers().asHttpHeaders(), body));
    }
}
