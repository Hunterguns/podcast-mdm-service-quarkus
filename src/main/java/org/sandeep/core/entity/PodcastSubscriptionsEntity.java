package org.sandeep.core.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

public class PodcastSubscriptionsEntity extends PanacheEntity {
    @Column(name = "user_id")
    public UUID userId;
    @Column(name = "podcast_id")
    public UUID podcastId;
    @Column(name = "subscribed_at")
    public LocalDate subscribedAt;
}
