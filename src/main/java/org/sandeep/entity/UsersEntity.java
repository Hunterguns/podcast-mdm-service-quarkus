package org.sandeep.entity;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class UsersEntity extends AuditEntity{
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
