/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pk.java.konrad.view;

import static com.pk.java.konrad.view.MainJFrame.HEIGHT;
import static com.pk.java.konrad.view.MainJFrame.WIDTH;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Paweł
 */
public class MainJFrame extends JFrame{
    public static final int WIDTH = 420;
    public static final int HEIGHT = 320;
    private View widokWyswietlany;
    
    public MainJFrame(View widokPoczatkowy){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        this.setResizable(false);
        
        widokWyswietlany=widokPoczatkowy;
            
        this.add(widokWyswietlany);
        this.getContentPane().add(widokWyswietlany);
    }
    
    public View getActualView(){
        return widokWyswietlany;
    }
    
    public void Wyswietl(View vidok){
        getContentPane().remove(widokWyswietlany);
        getContentPane().add(vidok);
        
        widokWyswietlany = vidok;
        revalidate();
        repaint();
    }
}
