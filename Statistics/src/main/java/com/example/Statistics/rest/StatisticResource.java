/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Statistics.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.StatisticsService;

/**
 *
 * @author Jeroen
 */
@Path("/statistics")
public class StatisticResource {

    @Inject
    private StatisticsService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addScore(@QueryParam("outcome") String outcome) {
        System.out.println("in statistics uitkomst is:" + outcome);
        service.addScore(outcome);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getScore() {
        System.out.println("in statestics score is: " + service.getScore());
        return Response.ok(service.getScore()).build();
    }
}
