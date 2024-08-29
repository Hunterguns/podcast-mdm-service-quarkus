package org.sandeep.rest;

import jakarta.ws.rs.*;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.sandeep.model.User;
import org.sandeep.model.UserRequest;
import org.sandeep.service.UserService;

import java.util.UUID;

@Path(value = "/user")
@RequiredArgsConstructor
public class UserRestService {
    private final UserService userService;

    @POST
    @Path(value = "/register")
    public User userRegistration(@RequestBody UserRequest userRequest){
        return userService.registerUser(userRequest);
    }

    @DELETE
    @Path(value = "/delete/{userId}")
    public String deleteUserById(@PathParam("userId") UUID userId){
        return userService.deleteUserById(userId)? "Successfully deleted user":"Unable to delete user. Please try again.";
    }

    @GET
    @Path(value = "/get")
    public User getUser(@RequestBody UserRequest userRequest) throws Exception {
        return userService.getUser(userRequest);
    }

    @PUT
    @Path(value = "/update")
    public String updateUser(@RequestBody UserRequest userRequest){
        boolean result = userService.updateUser(userRequest);
        return result?"Successfully updated User":"Something went wrong while updating the user. Please try again after sometime";
    }
}
