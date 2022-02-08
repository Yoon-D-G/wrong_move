package com.example;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path("users")
public class UserResource {

    @EJB
    public PersistenceService persistenceService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers () {
        List<User> users = persistenceService.getAllUsers();
        return Response.ok(users).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser (User user, @Context UriInfo uriInfo) {
        persistenceService.addUser(user);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(user.getId()));
        return Response.created(builder.build()).build();

    }

}