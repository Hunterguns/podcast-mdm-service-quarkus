package org.sandeep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "ratings")
public class RatingsEntity extends AuditEntity{
    @Id
    @Column(name = "id")
    public UUID id;
    @Column(name = "user_id")
    public UUID podcastId;
    @Column(name = "rating")
    public int rating;
    @Column(name = "review_text")
    public String reviewText;

}
