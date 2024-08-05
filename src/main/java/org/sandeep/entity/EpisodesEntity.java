package org.sandeep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "episodes")
public class EpisodesEntity {
    @Id
    @Column(name = "id")
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