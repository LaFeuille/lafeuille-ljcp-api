package org.lafeuille.ljcp.data;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface EventRepository extends ReactiveMongoRepository<Event, UUID> {

    Flux<Event> findBy(Pageable pageable);
}
