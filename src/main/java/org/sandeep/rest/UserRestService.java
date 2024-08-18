package org.sandeep.rest;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import lombok.RequiredArgsConstructor;
import org.sandeep.model.User;
import org.sandeep.model.UserRequest;
import org.sandeep.service.UserService;

@Path(value = "/user")
@RequiredArgsConstructor
public class UserRestService {
    private final UserService userService;

    @POST
    @Path(value = "/register")
    public User userRegistration(UserRequest userRequest){
        return userService.registerUser(userRequest);
    }

    @DELETE
    @Path(value = "/delete/{userId}")
    public String deleteUserById(@PathParam("userId") String userId){
        return userService.deleteUserById(userId)? "Successfully deleted user":"Unable to delete user";
    }
}
