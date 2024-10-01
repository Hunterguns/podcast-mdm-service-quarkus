package org.sandeep.core.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "episode")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EpisodeEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "podcast_id")
    private UUID podcastId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "audio_file_url")
    private String audioFileUrl;
    @Column(name = "duration")
    private String duration;
    @Column(name = "publish_date")
    private LocalDate publishDate;
    @Column(name = "episode_number")
    private int episodeNumber;
    @Column(name = "season_number")
    private int seasonNumber;

    public static List<EpisodeEntity> findAllByPodcastId(String podcastId) {
        return EpisodeEntity.find("podcastId", podcastId).list();
    }
}
