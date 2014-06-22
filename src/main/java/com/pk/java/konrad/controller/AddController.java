/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pk.java.konrad.controller;

import com.pk.java.konrad.DAOSingleton;
import com.pk.java.konrad.model.Dekorator;
import com.pk.java.konrad.view.ViewFactory;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Paweł
 */
public class AddController implements Controller{
    
    public static String nazwa = "add";

    @Override
    public void distributionActionEvent(String name, ActionEvent ae, Object model) {
        Dekorator cwiczenie;
        switch(ae.getActionCommand()){
            case "Wstecz":
                MainController.getInstance().changeView(ViewFactory.widoki.mainView);
                break;
            case "Zapisz":
                cwiczenie = (Dekorator)model;
                List<Object> model1 = new ArrayList<>();
                model1.add(cwiczenie);
                model1.add( cwiczenie.getValue()[0]<0 );
                model1.add( cwiczenie.getValue()[1]<0 );
                if(cwiczenie.getValue()[0]<0 || cwiczenie.getValue()[0]<0) {
                    MainController.getInstance().changeView(ViewFactory.widoki.addView, model1);
                } else {
                    if(DAOSingleton.getInstance().Dodaj(cwiczenie)==0){
                        JOptionPane.showMessageDialog(null,"Zapisano Trening.","Informacja",JOptionPane.INFORMATION_MESSAGE);
                        
                        MainController.getInstance().changeView(ViewFactory.widoki.mainView);
                    } else {
                        JOptionPane.showMessageDialog(null,"Nie udało się zapisać treningu.","Error",JOptionPane.ERROR_MESSAGE+JOptionPane.OK_OPTION);
                    }
                }
                break;
        }
        //System.out.println("addController.distributionActionEvent() name="+name+" ae.getActionCommand()"+ae.getActionCommand());
    }
    
}
