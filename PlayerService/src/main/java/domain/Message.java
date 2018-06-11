/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Jeroen
 */
public class Message {

    private String playersCard;
    private String aiCard;
    private String outcome;

    public Message() {
    }

    public String getPlayersCard() {
        return playersCard;
    }

    public void setPlayersCard(String playersCard) {
        this.playersCard = playersCard;
    }

    public String getAiCard() {
        return aiCard;
    }

    public void setAiCard(String aiCard) {
        this.aiCard = aiCard;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

}
