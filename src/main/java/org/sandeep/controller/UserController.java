package org.sandeep.controller;

import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.*;
import org.sandeep.model.LoginResponse;
import org.sandeep.model.User;
import org.sandeep.model.requests.UserRequest;
import org.sandeep.service.UserService;

import java.util.UUID;

@GraphQLApi
public class UserController {

    @Inject
    private UserService userService;

    @Query(value = "getUser")
    @Description("Get a user based on id/username/email")
    public User getUser(@Source UserRequest userRequest) throws Exception {
        return userService.getUser(userRequest);
    }

    @Mutation(value = "createUser")
    @Description("Create a new user")
    public User createUser(@Source UserRequest userRequest) {
        return userService.registerUser(userRequest);
    }

    @Mutation(value = "updateUser")
    @Description("Update an existing user")
    public String updateUser(@Source UserRequest userRequest) {
        return userService.updateUser(userRequest) ? "Successfully updated User" : "Something went wrong while updating the user. Please try again after sometime";

    }

    @Mutation(value = "deleteUserById")
    @Description("Delete an existing user")
    public String deleteUserById(@Source UUID id) {
        return userService.deleteUserById(id) ? "Successfully deleted user" : "Unable to delete user. Please try again.";
    }

    @Mutation(value = "userLogin")
    @Description("User login")
    public LoginResponse userLogin(@Source UserRequest userRequest) {
        return userService.userLogin(userRequest);
    }
}
