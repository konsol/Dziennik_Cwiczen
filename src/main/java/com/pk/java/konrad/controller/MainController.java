/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pk.java.konrad.controller;

import com.pk.java.konrad.DAOSingleton;
import com.pk.java.konrad.view.MainJFrame;
import com.pk.java.konrad.view.View;
import com.pk.java.konrad.view.ViewFactory;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.List;
/**
 *
 * @author Paweł
 */
public class MainController implements Controller{
    
    private DAOSingleton dao;
    private ViewFactory viewFactory;
    private MainJFrame mainJFrame;
    
    public static ViewFactory viewFactoryStatic;
    private static MainController instance;
    
    HashMap<String, Controller> controllers;
    
    private MainController(ViewFactory viewFactory){
        this.viewFactory=viewFactory;
        dao=DAOSingleton.getInstance();
        mainJFrame = new MainJFrame(viewFactory.getVew(ViewFactory.widoki.mainView));
        controllers = new HashMap<>();
    }
    
    public void registerController(Controller c, String name){
        controllers.put(name, c);
    }
    
    @Override
    public void distributionActionEvent(String name, ActionEvent ae, Object model){
        Controller c = controllers.get(name);
        model = mainJFrame.getActualView().getModel();
        c.distributionActionEvent(name,ae,model);
    }
    
    public void changeView(ViewFactory.widoki view, List<Object> model){
        View w = viewFactory.getVew(view);
        w.setModel(model);
        mainJFrame.Wyswietl(w);
    }
    
    public void changeView(ViewFactory.widoki view){
        mainJFrame.Wyswietl(viewFactory.getVew(view));
    }
    
    public static MainController getInstance(){
        if(instance == null) instance=new MainController(viewFactoryStatic);
        return instance;
    }
}
