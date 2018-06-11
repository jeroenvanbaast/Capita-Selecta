/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PlayerService.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.PlayerService;

/**
 *
 * @author Jeroen
 */
@Path("/play")
public class PlayerEndPoint {

    @Inject
    private PlayerService service;
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response doMove(@QueryParam("card") String card) {
        System.out.println("Kom in player met: " + card);
        return Response.ok(service.play(card)).build();
    }
}
