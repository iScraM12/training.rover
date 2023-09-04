package com.iscram.rover.service.input.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/greeting")
public class GreetingsResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return "Hello World";
    }
}
