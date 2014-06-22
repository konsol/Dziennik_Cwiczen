/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pk.java.konrad.controller;

import com.pk.java.konrad.DAOSingleton;
import com.pk.java.konrad.model.DecoratorFactory;
import com.pk.java.konrad.view.ViewFactory;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Paweł
 */
public class MainViewController  implements Controller{
    
    public static String nazwa = "main";
    private boolean uzupelnianie = true;

    @Override
    public void distributionActionEvent(String name, ActionEvent ae, Object model) {

        
        switch(ae.getActionCommand()){
            case "Uzupełnij Dziennik":
                uzupelnianie=(Boolean)model;
                break;
            case "Statystyki":
                uzupelnianie=!(Boolean)model;
                break;
            default:
                if(uzupelnianie){
                    List<Object> model1 = new ArrayList<>();
                    model1.add(DecoratorFactory.getInstance().getDecorator(ae.getActionCommand(), null));
                    model1.add(false);
                    model1.add(false);
                    MainController.getInstance().changeView(ViewFactory.widoki.addView, model1);
                } else {
                    List<Object> model1 = new ArrayList<>();
                    model1.add(false);
                    model1.add(false);
                    model1.add(DAOSingleton.getInstance().GetDataNajwczesniejsza(ae.getActionCommand()));
                    model1.add(DAOSingleton.getInstance().GetDataNajpozniejsza(ae.getActionCommand()));
                    model1.add(ae.getActionCommand());
                    
                    MainController.getInstance().changeView(ViewFactory.widoki.statSelectView, model1);
                    //System.out.println(model1);
                }
        }
        //System.out.println("mainViewController.distributionActionEvent() name="+name+" ae.getActionCommand()"+ae.getActionCommand());
    }
    
}
