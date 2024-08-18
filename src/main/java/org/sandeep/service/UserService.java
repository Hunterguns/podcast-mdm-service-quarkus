package org.sandeep.service;

import org.sandeep.model.User;
import org.sandeep.model.UserRequest;

public interface UserService {
    User registerUser(UserRequest userRequest);

    boolean deleteUserById(String userId);
}
