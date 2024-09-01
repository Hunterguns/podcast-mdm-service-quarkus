package org.sandeep.core.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "podcast_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PodcastCategoryEntity extends PanacheEntityBase {
    @EmbeddedId
    private PodcastCategoriesId id;
    @Column(name = "category_id")
    private UUID categoryId;
    @Column(name = "podcast_id")
    private UUID podcastId;
}
