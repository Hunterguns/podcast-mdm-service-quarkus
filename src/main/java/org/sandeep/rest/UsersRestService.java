package org.sandeep.rest;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.sandeep.model.UserRequest;

@Path(value = "/users")
public class UsersRestService {

    @POST
    @Path(value = "/register")
    public void userRegistration(UserRequest userRequest){

    }
}
