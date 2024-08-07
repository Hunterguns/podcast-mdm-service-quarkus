package org.sandeep.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.arc.All;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersRequest {
    public UUID id;
    public String username;
    public String email;
    public String userType;
    public String externalId;
    public String password;
}
