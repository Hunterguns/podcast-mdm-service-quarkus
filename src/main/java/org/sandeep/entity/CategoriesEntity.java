package org.sandeep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CategoriesEntity {
    @Id
    @Column(name = "id")
    public UUID id;
    @Column(name = "name")
    public String name;
    @Column(name = "description")
    public String description;
}
