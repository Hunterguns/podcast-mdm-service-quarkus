package org.sandeep.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Podcast {
    UUID id;
    UUID creatorId;
    String title;
    String description;
    String coverImageUrl;
    String language;
    boolean isExplicit;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
