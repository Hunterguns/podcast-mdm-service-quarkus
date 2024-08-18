package org.sandeep.core.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "premium_subscriptions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PremiumSubscriptionsEntity extends PanacheEntity {
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
