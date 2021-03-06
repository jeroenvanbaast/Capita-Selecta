/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Jeroen
 */
@Singleton
@Startup
public class StartUp {

    @Inject
    private MoveService moveService;

    public StartUp() {
    }

    @PostConstruct
    public void postConstruct() {
        moveService.fillCards();

    }
}
