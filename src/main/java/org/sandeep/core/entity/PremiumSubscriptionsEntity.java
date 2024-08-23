package org.sandeep.core.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "premium_subscriptions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PremiumSubscriptionsEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id", updatable = false, nullable = false)
    public UUID id;
    @Column(name = "user_id")
    public String userId;
    @Column(name = "start_date")
    public LocalDate startDate;
    @Column(name = "end_date")
    public LocalDate endDate;
    @Column(name = "subscription_type")
    public String subscriptionType;
    @Column(name = "status")
    public String status;
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
