package org.sandeep.core.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "podcast_subscription")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PodcastSubscriptionEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "podcast_id")
    private UUID podcastId;
    @Column(name = "subscribed_at")
    private LocalDate subscribedAt;
}
