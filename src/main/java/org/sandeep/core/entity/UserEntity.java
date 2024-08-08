package org.sandeep.core.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserEntity extends PanacheEntity{
    @Id
    @Column(name = "id")
    public UUID id;
    @Column(name = "username")
    public String username;
    @Column(name = "email")
    public String email;
    @Column(name = "user_type")
    public String userType;
    @Column(name = "external_id")
    public String externalId;
    @Column(name = "hashed_password")
    public String hashedPassword;
}
