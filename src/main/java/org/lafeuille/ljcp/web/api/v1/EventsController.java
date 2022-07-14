package org.lafeuille.ljcp.web.api.v1;

import org.lafeuille.ljcp.data.Event;
import org.lafeuille.ljcp.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/events")
class EventsController {

    private final EventService service;

    EventsController(EventService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    Mono<ResponseEntity<Event>> readEvent(@Valid @PathVariable UUID id) {
        return service.readEvent(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
