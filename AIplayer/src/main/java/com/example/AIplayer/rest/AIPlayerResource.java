/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AIplayer.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.MoveService;

/**
 *
 * @author Jeroen
 */
@Path("/play")
public class AIPlayerResource {
    
    @Inject
    private MoveService moveService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRandomMove() {
        System.out.println("Kom in ai");
        this.moveService.fillCards();
        return Response.ok(moveService.getRandom()).build();
    }
}
