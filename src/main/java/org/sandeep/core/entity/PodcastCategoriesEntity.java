package org.sandeep.core.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
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
public class PodcastCategoriesEntity extends PanacheEntityBase {
    @EmbeddedId
    private PodcastCategoriesId id;
    @Column(name = "category_id")
    private UUID categoryId;
    @Column(name = "podcast_id")
    private UUID podcastId;
}
