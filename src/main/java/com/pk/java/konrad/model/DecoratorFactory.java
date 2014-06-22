/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pk.java.konrad.model;

/**
 *
 * @author Paweł
 */
public class DecoratorFactory {
    private static DecoratorFactory instance = new DecoratorFactory();
    
    public static DecoratorFactory getInstance(){
        return instance;
    }
    
    public Dekorator getDecorator(String nazwa, Cwiczenia obiektDekorowany){
        Dekorator d = null;
        
        switch(nazwa){
            case "Bieg": d=new Bieg(obiektDekorowany); break;
            case "Rower": d=new Rower(obiektDekorowany); break;
            case "Pływanie": d=new Plywanie(obiektDekorowany); break;
            case "Przysiady": d=new Przysiady(obiektDekorowany); break;
            case "Pompki": d=new Pompki(obiektDekorowany); break;
            case "Skakanka": d=new Skakanka(obiektDekorowany); break;
        }
        
        return d;
    }
    
    DecoratorFactory(){}
}
