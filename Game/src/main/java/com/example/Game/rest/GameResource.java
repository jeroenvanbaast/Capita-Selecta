/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Game.rest;

import domain.Message;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.GameService;

/**
 *
 * @author Jeroen
 */
@Path("/game")
public class GameResource {

    @Inject
    private GameService gameService;

    @GET
    @Path("{card}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response movePlayed(@PathParam("card") String card) {
        System.out.println("kom in game met: " + card);
        Message message = gameService.play(card);
        return Response.ok(message).build();
    }
}
