package org.sandeep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "categories")
public class CategoriesEntity {
    @Id
    @Column(name = "id")
    public UUID id;
    @Column(name = "name")
    public String name;
    @Column(name = "description")
    public String description;
}
