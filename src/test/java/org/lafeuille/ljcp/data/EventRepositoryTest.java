package org.lafeuille.ljcp.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.UUID;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
class EventRepositoryTest {

    @Autowired
    private ReactiveMongoTemplate template;

    @Autowired
    private EventRepository repository;

    @Test
    void get_events() {
        template.insertAll(Flux.fromStream(IntStream.range(0, 20)
                                .mapToObj(i -> new Event(UUID.randomUUID(), "Event" + i)))
                        .collectList())
                .blockLast(Duration.ofSeconds(1));

        repository.findBy(PageRequest.of(1, 5))
                .as(StepVerifier::create)
                .assertNext(event -> {
                    assertThat(event.id()).isNotNull();
                    assertThat(event.title()).isEqualTo("Event5");
                })
                .assertNext(event -> {
                    assertThat(event.id()).isNotNull();
                    assertThat(event.title()).isEqualTo("Event6");
                })
                .assertNext(event -> {
                    assertThat(event.id()).isNotNull();
                    assertThat(event.title()).isEqualTo("Event7");
                })
                .assertNext(event -> {
                    assertThat(event.id()).isNotNull();
                    assertThat(event.title()).isEqualTo("Event8");
                })
                .assertNext(event -> {
                    assertThat(event.id()).isNotNull();
                    assertThat(event.title()).isEqualTo("Event9");
                })
                .verifyComplete();
    }

    @Test
    void get_event() {
        var id = UUID.fromString("49cf0dae-bf57-4cc7-a0b6-1c528c726668");
        var eventToSave = new Event(id, "Some event");
        template.save(eventToSave).block(Duration.ofSeconds(1));

        repository.findById(id).as(StepVerifier::create).assertNext(event -> {
            assertThat(event).isNotNull();
            assertThat(event.id()).hasToString("49cf0dae-bf57-4cc7-a0b6-1c528c726668");
            assertThat(event.title()).isEqualTo("Some event");
        }).verifyComplete();
    }

}
