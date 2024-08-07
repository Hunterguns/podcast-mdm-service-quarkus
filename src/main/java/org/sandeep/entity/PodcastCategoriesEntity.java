package org.sandeep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.rmi.server.UID;
import java.util.UUID;

@Entity
@Table(name = "podcast_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PodcastCategoriesEntity {
    @Column(name = "category_id")
    public UUID categoryId;
    @Column(name = "podcast_id")
    public UUID podcastId;
}
