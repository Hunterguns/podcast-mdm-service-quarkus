package org.sandeep.service.impl;

import org.sandeep.model.UserRequest;
import org.sandeep.repository.UsersRepository;
import org.sandeep.service.UserService;

public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    private void registerUser(UserRequest userRequest){
        usersRepository.
    }
}
