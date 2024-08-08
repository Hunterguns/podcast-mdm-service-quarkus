package org.sandeep.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "playback_history")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PlaybackHistoryEntity {
    @Id
    @Column(name = "id")
    public UUID id;
    @Column(name = "user_id")
    public UUID userId;
    @Column(name = "episode_id")
    public String episodeId;
    @Column(name = "played_at")
    public LocalDate playedAt;
    @Column(name = "progress")
    public int progress;
}
