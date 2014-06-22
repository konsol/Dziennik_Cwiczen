/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pk.java.konrad.controller;

import com.pk.java.konrad.DAOSingleton;
import com.pk.java.konrad.view.ViewFactory;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Paweł
 */
public class StatController implements Controller{
    
    public static String nazwa = "stat";

    @Override
    public void distributionActionEvent(String name, ActionEvent ae, Object model) {
        //HashMap<String, Object> model = new HashMap<>();
        switch(ae.getActionCommand()){
            case "Wstecz":
                MainController.getInstance().changeView(ViewFactory.widoki.mainView);
                break;
            case "Pokaż Statystyki":
                ArrayList<Object> model1 = new ArrayList<>();
                ArrayList<Object> l = (ArrayList<Object>)model;
                Date Od = (Date)l.get(0);
                Date Do = (Date)l.get(1);
                if (l.get(0)==null || l.get(1)==null){
                    model1.add(l.get(0)==null);
                    model1.add(l.get(1)==null);
                    MainController.getInstance().changeView(ViewFactory.widoki.statSelectView, model1);
                } else {
                    model1.add(DAOSingleton.getInstance().GetListaCwiczen((String)l.get(2), Od, Do));
                    model1.add((String)l.get(2));
                    model1.add(DAOSingleton.getInstance().GetCwiczeniaInfo((String)l.get(2))[0]);
                    model1.add(DAOSingleton.getInstance().GetCwiczeniaInfo((String)l.get(2))[1]);
                    MainController.getInstance().changeView(ViewFactory.widoki.statView, model1);
                }
                
                break;
        }
        //System.out.println("statController.distributionActionEvent() name="+name+" ae.getActionCommand()"+ae.getActionCommand());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
