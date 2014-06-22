/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pk.java.konrad.view;

import com.pk.java.konrad.controller.AddController;
import com.pk.java.konrad.controller.MainViewController;
import com.pk.java.konrad.controller.StatController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Paweł
 */
public class ViewFactory {
    
    public static enum widoki {mainView, addView, statView, statSelectView};
    private MainView mainView;
    private AddView addView;
    private StatView statView;
    private StatSelectView statSelectView;
    
    public View getVew(widoki w){
        switch(w)
        {
            case mainView:
                if(mainView == null) mainView = makeMainView();
                return mainView;
            case addView:
                if(addView == null) addView = makeAddView();
                return addView;
            case statView:
                if(statView == null) statView = makeStatView();
                return statView;
            case statSelectView:
                if(statSelectView == null) statSelectView = makeStatSelectView();
                return statSelectView;
        }
        
        return null;
    }
    
    private MainView makeMainView(){
        MainView view = new MainView();
        MyActionEventClass l = new MyActionEventClass(MainViewController.nazwa);
        view.dodajActionListener(l);
        List<Object> model = new ArrayList<>();
        model.add(true);
        view.setModel(model);
        return view;
    }
    
    private AddView makeAddView(){
        AddView view = new AddView();
        MyActionEventClass l = new MyActionEventClass(AddController.nazwa);
        view.dodajActionListener(l);
        return view;
    }
    
    private StatView makeStatView(){
        StatView view = new StatView();
        MyActionEventClass l = new MyActionEventClass(StatController.nazwa);
        view.dodajActionListener(l);
        return view;
    }
    
    private StatSelectView makeStatSelectView(){
        StatSelectView view = new StatSelectView();
        MyActionEventClass l = new MyActionEventClass(StatController.nazwa);
        view.dodajActionListener(l);
        return view;
    }
    
    public ViewFactory(){
    }
}
