package org.sandeep.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "podcasts")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PodcastsEntity extends AuditEntity {
    @Id
    @Column(name = "id")
    public UUID id;

    @Column(name = "creator_id")
    public UUID creatorId;
    @Column(name = "title")
    public String title;
    @Column(name = "description")
    public String description;
    @Column(name = "cover_image_url")
    public String coverImageUrl;
    @Column(name = "language")
    public String language;
    @Column(name = "is_explicit")
    public boolean isExplicit;


}
