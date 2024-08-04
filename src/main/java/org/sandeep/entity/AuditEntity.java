package org.sandeep.entity;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class AuditEntity {
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

}
