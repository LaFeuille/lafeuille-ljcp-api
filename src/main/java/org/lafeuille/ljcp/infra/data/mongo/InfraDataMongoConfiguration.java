package org.lafeuille.ljcp.infra.data.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;

import javax.validation.Validator;

@Configuration
public class InfraDataMongoConfiguration {

    @Bean
    ValidatingMongoEventListener validatingMongoEventListener(Validator validator) {
        return new ValidatingMongoEventListener(validator);
    }
}
