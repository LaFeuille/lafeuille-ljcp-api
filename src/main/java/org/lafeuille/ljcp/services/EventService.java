package org.lafeuille.ljcp.services;

import org.lafeuille.ljcp.data.Event;
import org.lafeuille.ljcp.data.EventRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Service
public class EventService {

    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public Mono<Event> readEvent(@NotNull UUID id) {
        return this.repository.findById(id);
    }

}
