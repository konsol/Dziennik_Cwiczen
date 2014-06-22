/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pk.java.konrad.view;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Paweł
 */
public abstract class View extends JPanel{
    public abstract void setModel(List<Object> model);
    public abstract Object getModel();
    public abstract void dodajActionListener(ActionListener l);
}
