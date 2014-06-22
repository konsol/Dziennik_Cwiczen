/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pk.java.konrad.model;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Paweł
 */
public class Skakanka extends Dekorator
{
    private int iloscSerii;
    private int czasMinuty;
    private static String[] info = {"Ilość serii:","Czas w minutach:"};


    public Skakanka(Cwiczenia obiektDekorowany) {
        super(obiektDekorowany, "Skakanka");
    }

    @Override
    public String[] getInfo() {
        return info;
    }

    @Override
    public int[] getValue() {
        int[] temp = {iloscSerii, czasMinuty};
        return temp;
    }

    @Override
    public void setValue1(int value) {
        iloscSerii=value;
    }

    @Override
    public void setValue2(int value) {
        czasMinuty=value;
    }

    @Override
    public int getKalorie() {
        return obiektDekorowany.getKalorie()+iloscSerii*czasMinuty;
    } 
}