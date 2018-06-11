/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import domain.Message;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jeroen
 */
@RequestScoped
public class PlayerService {

    public Message play(String card) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8081/api/game/" + card);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(response);
        JsonObject jo = new JsonParser().parse(response).getAsJsonObject();
        Message message = new Gson().fromJson(jo.toString(), Message.class);
        return message;
    }
}
