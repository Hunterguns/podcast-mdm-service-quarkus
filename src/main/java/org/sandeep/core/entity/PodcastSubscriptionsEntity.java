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
@Table(name = "podcast_subscriptions")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PodcastSubscriptionsEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id", updatable = false, nullable = false)
    public UUID id;
    @Column(name = "user_id")
    public UUID userId;
    @Column(name = "podcast_id")
    public UUID podcastId;
    @Column(name = "subscribed_at")
    public LocalDate subscribedAt;
}
