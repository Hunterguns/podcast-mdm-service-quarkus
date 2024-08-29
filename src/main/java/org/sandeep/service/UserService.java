package org.sandeep.service;

import org.sandeep.model.User;
import org.sandeep.model.UserRequest;

import java.util.UUID;

public interface UserService {
    User registerUser(UserRequest userRequest);

    boolean deleteUserById(UUID userId);

    User getUser(UserRequest userRequest) throws Exception;

    boolean updateUser(UserRequest userRequest);
}
