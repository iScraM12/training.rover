package com.iscram.rover.service.api;

import com.iscram.rover.service.core.service.PropertyService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.net.UnknownHostException;

@Path("/api/properties")
public class PropertyResource {
    @Inject
    PropertyService propertyService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hostname")
    public String getHostname() throws UnknownHostException {
        return propertyService.getHostname();
    }
}
