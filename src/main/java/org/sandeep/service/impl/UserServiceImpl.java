package org.sandeep.service.impl;

import com.google.common.base.Strings;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.ext.web.handler.HttpException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.sandeep.core.entity.UserEntity;
import org.sandeep.model.LoginResponse;
import org.sandeep.model.User;
import org.sandeep.model.requests.UserRequest;
import org.sandeep.service.JwtTokenService;
import org.sandeep.service.UserService;
import org.sandeep.utils.PasswordUtils;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static org.sandeep.constants.UserTypes.FREE_USER;

@Slf4j
@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    JwtTokenService jwtTokenService;

    @Override
    @Transactional
    public User registerUser(UserRequest userRequest) {
        if (Strings.isNullOrEmpty(userRequest.getPassword()) || Strings.isNullOrEmpty(userRequest.confirmPassword) || !userRequest.getPassword().equals(userRequest.getConfirmPassword())) {
            log.error("Password and confirm password are mandatory and should match");
        }
        UserEntity existingUser = UserEntity.findByEmail(userRequest.getEmail());
        if (Objects.nonNull(existingUser)) {
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
    @Transactional
    public boolean deleteUserById(UUID userId) {
        return UserEntity.deleteById(userId);
    }

    @Override
    public User getUser(UserRequest userRequest) throws Exception {
        UserEntity userEntity;
        if (Objects.nonNull(userRequest.getId())) {
            userEntity = UserEntity.findById(userRequest.getId());
        } else if (!Strings.isNullOrEmpty(userRequest.getUsername())) {
            userEntity = UserEntity.findByUserName(userRequest.getUsername());
        } else if (!Strings.isNullOrEmpty(userRequest.getEmail())) {
            userEntity = UserEntity.findByEmail(userRequest.getEmail());
        } else {
            throw new Exception("Please provide atleast one of the following: userId, username, email");
        }
        return UserEntity.toUser.apply(userEntity);
    }

    @Override
    @Transactional
    public boolean updateUser(UserRequest userRequest) {
        try {
            UserEntity userEntity = UserEntity.findById(userRequest.getId());
            if (Objects.nonNull(userEntity)) {
                Optional.ofNullable(userRequest.getNewUserName()).ifPresent(u -> userEntity.setUsername(userRequest.getNewUserName()));
                Optional.ofNullable(userRequest.getNewEmail()).ifPresent(u -> userEntity.setEmail(userRequest.getNewEmail()));
                return true;
            }
            return false;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public LoginResponse userLogin(UserRequest userRequest) {
        try {
            UserEntity userEntity = !Strings.isNullOrEmpty(userRequest.getUsername()) ? UserEntity.findByUserName(userRequest.getUsername()) : UserEntity.findByEmail(userRequest.getEmail());
            if (Objects.isNull(userEntity)) {
                throw new HttpException(HttpResponseStatus.BAD_REQUEST.code());
            }
            boolean validPassword = PasswordUtils.verifyPassword(userRequest.getPassword(), userEntity.getHashedPassword());
            User user = UserEntity.toUser.apply(userEntity);
            if (validPassword) {
                return LoginResponse.builder().username(userEntity.getUsername())
                        .accessToken(jwtTokenService.generateToken(user))
                        .refreshToken(jwtTokenService.generateRefreshToken(user))
                        .build();
            } else {
                throw new HttpException(HttpResponseStatus.UNAUTHORIZED.code());
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
