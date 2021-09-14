package ru.dmitrenko.demowebflux.event;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class StartupEvent {

    @EventListener(ApplicationStartedEvent.class)
    public void run() {

    }
}
