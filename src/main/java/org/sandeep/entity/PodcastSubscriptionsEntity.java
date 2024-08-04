package org.sandeep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "podcast_subscriptions")
public class PodcastSubscriptionsEntity {
    @Id
    @Column(name = "id")
    public UUID id;
    @Column(name = "user_id")
    public UUID userId;
    @Column(name = "podcast_id")
    public UUID podcastId;
    @Column(name = "subscribed_at")
    public LocalDate subscribedAt;
}
