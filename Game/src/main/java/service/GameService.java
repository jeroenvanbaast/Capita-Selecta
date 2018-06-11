/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import domain.Card;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.JsonParser;
import domain.Message;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author Jeroen
 */
@RequestScoped
public class GameService {

    public Message play(String playersCard) {
        Message message = new Message();
        String aiCard = getCard().getCard();
        String result = decideWinner(playersCard, aiCard);
        pushResult(result);
        message.setAiCard(aiCard);
        message.setOutcome(result);
        message.setPlayersCard(playersCard);
        return message;
    }

    private Card getCard() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/api/play");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        JsonObject jo = new JsonParser().parse(response).getAsJsonObject();
        Card card = new Gson().fromJson(jo.toString(), Card.class);
        return card;
    }

    public void pushResult(String result) {
        System.out.println("kom in pushresult met: " + result);
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8083/api/statistics?outcome=" + result);
        target.request().post(Entity.html("outcome=" + result));
    }

    private String decideWinner(String playersCard, String aiCard) {
        switch (playersCard) {
            case "Rock":
                if (aiCard.equals("Rock")) {
                    return "Gelijkspel";
                } else if (aiCard.equals("Paper") || aiCard.equals("Spock")) {
                    return "Verloren";
                } else if (aiCard.equals("Scissors") || aiCard.equals("Lizard")) {
                    return "Gewonnen";
                }
                break;
            case "Paper":
                if (aiCard.equals("Paper")) {
                    return "Gelijkspel";
                } else if (aiCard.equals("Scissors") || aiCard.equals("Lizard")) {
                    return "Verloren";
                } else if (aiCard.equals("Rock") || aiCard.equals("Spock")) {
                    return "Gewonnen";
                }
                break;
            case "Scissors":
                if (aiCard.equals("Scissors")) {
                    return "Gelijkspel";
                } else if (aiCard.equals("Rock") || aiCard.equals("Spock")) {
                    return "Verloren";
                } else if (aiCard.equals("Paper") || aiCard.equals("Lizard")) {
                    return "Gewonnen";
                }
                break;
            case "Spock":
                if (aiCard.equals("Spock")) {
                    return "Gelijkspel";
                } else if (aiCard.equals("Paper") || aiCard.equals("Lizard")) {
                    return "Verloren";
                } else if (aiCard.equals("Scissors") || aiCard.equals("Rock")) {
                    return "Gewonnen";
                }
                break;
            case "Lizard":
                if (aiCard.equals("Lizard")) {
                    return "Gelijkspel";
                } else if (aiCard.equals("Scissors") || aiCard.equals("Rock")) {
                    return "Verloren";
                } else if (aiCard.equals("Spock") || aiCard.equals("Paper")) {
                    return "Gewonnen";
                }
                break;
        }
        return "Oops something went wrong";
    }
}
