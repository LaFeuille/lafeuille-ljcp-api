package org.lafeuille.ljcp.data;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

import static org.lafeuille.ljcp.domain.EventConstants.Sizes.TITLE;

@Document
public record Event(
        @MongoId UUID id,
        @NotBlank @Size(max = TITLE) String title) {
}
