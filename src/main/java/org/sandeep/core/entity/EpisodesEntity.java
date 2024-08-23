package org.sandeep.core.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "episodes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EpisodesEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id", updatable = false, nullable = false)
    public UUID id;
    @Column(name = "podcast_id")
    public UUID podcastId;
    @Column(name = "title")
    public String title;
    @Column(name = "description")
    public String description;
    @Column(name = "audio_file_url")
    public String audioFileUrl;
    @Column(name = "duration")
    public String duration;
    @Column(name = "publish_date")
    public LocalDate publishDate;
    @Column(name = "episode_number")
    public int episodeNumber;
    @Column(name = "season_number")
    public int seasonNumber;
}
