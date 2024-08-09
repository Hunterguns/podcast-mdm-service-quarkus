package org.sandeep.core.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.*;
import org.sandeep.model.User;

import java.util.UUID;
import java.util.function.Function;

import static org.sandeep.Constants.ApplicationConstants.FREE_USER;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    @Column(name = "hashed_password")
    public String hashedPassword;

    public static final Function<UserEntity, User> toUser = userEntity -> User.builder()
            .username(userEntity.getUsername())
            .email(userEntity.getEmail())
            .userType(userEntity.userType)
            .build();

    public static UserEntity findByEmail(String email) {
        return find("email", email).firstResult();
    }
}
