package org.sandeep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Table(name = "premium_subscriptions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PremiumSubscriptionsEntity extends AuditEntity {
    @Id
    @Column(name = "id")
    public String id;
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

}
