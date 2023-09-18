package com.iscram.rover.service.api;

import com.iscram.rover.service.core.domain.Rover;
import com.iscram.rover.service.core.domain.RoverCommand;
import com.iscram.rover.service.core.service.RoverService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/api/rover")
public class RoverResource {
    @Inject
    RoverService roverService;

    @POST
    @Path(("/{roverCommand}"))
    public Rover executeCommand(@RequestBody Rover roverState, @PathParam("roverCommand") RoverCommand roverCommand) {
        return roverService.executeCommand(roverState, roverCommand);
    }
}
