package org.sandeep.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class Episode {
    UUID id;
    UUID podcastId;
    String title;
    String description;
    String audioFileUrl;
    long duration;
    LocalDate publishDate;
    int episodeNumber;
    int seasonNumber;
}
