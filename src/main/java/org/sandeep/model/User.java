package org.sandeep.model;

import jakarta.persistence.Column;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {
    public UUID id;
    public String username;
    public String email;
    public String userType;
    public String externalId;
    public String hashedPassword;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

}
