package org.sandeep.rest;

import jakarta.annotation.Resource;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.sandeep.model.UsersRequest;

@Path(value = "/users")
public class UsersRestService {

    @POST
    @Path(value = "/register")
    public void userRegistration(UsersRequest usersRequest){
    }
}
