package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("helloResource")
public class HelloResource {

    @GET
    @Path("hello")
    public Response hello() {
        return Response.ok().entity("Hello, world").build();
    }
}
