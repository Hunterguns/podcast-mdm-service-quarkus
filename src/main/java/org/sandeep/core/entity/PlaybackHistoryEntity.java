package org.sandeep.core.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
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

public class PlaybackHistoryEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id", updatable = false, nullable = false)
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
