package org.sandeep.core.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ratings")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RatingsEntity extends PanacheEntity {
    @Column(name = "user_id")
    public UUID podcastId;
    @Column(name = "rating")
    public int rating;
    @Column(name = "review_text")
    public String reviewText;
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
