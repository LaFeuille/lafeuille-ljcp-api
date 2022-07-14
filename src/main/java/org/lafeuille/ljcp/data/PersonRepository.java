package org.lafeuille.ljcp.data;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface PersonRepository extends ReactiveMongoRepository<Person, UUID> {
}
