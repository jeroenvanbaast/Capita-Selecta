/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import doamin.Score;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Jeroen
 */
@ApplicationScoped
public class StatisticsService implements Serializable {

    private Score score;

    public void addScore(String outcome) {
        if (score == null) {
            score = new Score();
        }
        if (outcome.equals("Gelijkspel")) {
            score.setDraw(score.getDraw() + 1);
        } else if (outcome.equals("Gewonnen")) {
            score.setWin(score.getWin() + 1);
        } else if (outcome.equals("Verloren")) {
            score.setLose(score.getLose() + 1);
        }
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

}
