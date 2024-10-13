package org.sandeep.model.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sandeep.core.entity.EpisodeEntity;

import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;
import java.util.function.Function;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class EpisodeRequest {
    UUID id;
    UUID podcastId;
    String title;
    String description;
    String audioFileUrl;
    String duration;
    LocalDate publishDate;
    int episodeNumber;
    int seasonNumber;

    public static final Function<EpisodeRequest, EpisodeEntity> toEpisodeEntity = episodeRequest ->
            EpisodeEntity.builder()
                    .podcastId(episodeRequest.getPodcastId())
                    .title(episodeRequest.getTitle())
                    .description(episodeRequest.getDescription())
                    .audioFileUrl(episodeRequest.getAudioFileUrl())
                    .duration(Duration.parse(episodeRequest.getDuration()).toSeconds())
                    .publishDate(episodeRequest.getPublishDate())
                    .episodeNumber(episodeRequest.getEpisodeNumber())
                    .seasonNumber(episodeRequest.getSeasonNumber())
                    .build();
}
