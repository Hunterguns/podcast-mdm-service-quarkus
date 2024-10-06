package org.sandeep.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sandeep.core.entity.PodcastEntity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class PodcastRequest {
    UUID id;
    UUID creatorId;
    String title;
    String description;
    String coverImageUrl;
    String language;
    boolean isExplicit;

    public static final Function<PodcastRequest, PodcastEntity> toPodcastEntity = podcastRequest ->
            PodcastEntity.builder()
                    .creatorId(podcastRequest.getCreatorId())
                    .title(podcastRequest.getTitle())
                    .description(podcastRequest.getDescription())
                    .coverImageUrl(podcastRequest.coverImageUrl)
                    .language(podcastRequest.getLanguage())
                    .isExplicit(podcastRequest.isExplicit())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
}
