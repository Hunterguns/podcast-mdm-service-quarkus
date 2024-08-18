package org.sandeep.service.impl;

import com.google.common.base.Strings;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.Components;
import org.sandeep.core.entity.UserEntity;
import org.sandeep.model.User;
import org.sandeep.model.UserRequest;
import org.sandeep.service.UserService;
import org.sandeep.utils.PasswordUtils;

import java.util.Objects;

import static org.sandeep.Constants.UserTypes.FREE_USER;

@Slf4j
@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Override
    public User registerUser(UserRequest userRequest){
        if(Strings.isNullOrEmpty(userRequest.getPassword()) || Strings.isNullOrEmpty(userRequest.confirmPassword) || !userRequest.getPassword().equals(userRequest.getConfirmPassword())){
            log.error("Password and confirm password are mandatory and should match");
        }
        UserEntity existingUser = UserEntity.findByEmail(userRequest.getEmail());
        if(Objects.nonNull(existingUser)) {
            //throw exception
            log.error("User with email already exists");
            return null;
        }

        String hashedPassword = PasswordUtils.hashPassword(userRequest.getPassword());

        UserEntity userEntity = UserEntity.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .userType(FREE_USER.name())
                .hashedPassword(hashedPassword)
                .build();

        UserEntity.persist(userEntity);

        return UserEntity.toUser.apply(userEntity);
    }

    @Override
    public boolean deleteUserById(String userId){
        return UserEntity.deleteById(userId);
    }
}
