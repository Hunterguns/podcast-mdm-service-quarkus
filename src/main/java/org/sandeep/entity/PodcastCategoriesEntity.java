package org.sandeep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.rmi.server.UID;
import java.util.UUID;

@Entity
@Table(name = "podcast_categories")
public class PodcastCategoriesEntity {
    @Column(name = "category_id")
    public UUID categoryId;
    @Column(name = "podcast_id")
    public UUID podcastId;
}
