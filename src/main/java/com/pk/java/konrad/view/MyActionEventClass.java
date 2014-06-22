/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pk.java.konrad.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.pk.java.konrad.controller.MainController;

/**
 *
 * @author Paweł
 */
public class MyActionEventClass implements ActionListener{
    
    private String nazwaKontrolera;
    
    public MyActionEventClass(String nazwaKontrolera){
        this.nazwaKontrolera=nazwaKontrolera;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        MainController.getInstance().distributionActionEvent(nazwaKontrolera, ae,null);
    }
    
}
