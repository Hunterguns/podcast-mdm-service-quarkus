package org.sandeep.core.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;
import org.sandeep.model.User;

import java.util.UUID;
import java.util.function.Function;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "user_type")
    private String userType;
    @Column(name = "hashed_password")
    private String hashedPassword;

    public static final Function<UserEntity, User> toUser = userEntity -> User.builder()
            .username(userEntity.getUsername())
            .email(userEntity.getEmail())
            .userType(userEntity.userType)
            .build();

    public static UserEntity findByEmail(String email) {
        return find("email", email).firstResult();
    }
    public static UserEntity findByUserName(String username){ return find("username", username).firstResult(); }
}
