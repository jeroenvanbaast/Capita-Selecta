/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Card;
import java.util.ArrayList;
import java.util.Random;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Jeroen
 */
@RequestScoped
public class MoveService {

    private ArrayList<Card> cards;

    public void fillCards(){
        cards = new ArrayList();
        cards.add(new Card("Rock"));
        cards.add(new Card("Paper"));
        cards.add(new Card("Scissors"));
        cards.add(new Card("Spock"));
        cards.add(new Card("Lizard"));
    }
    
    public Card getRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(cards.size());
        return cards.get(randomIndex);
    }
}
