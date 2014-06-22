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
public class Rower extends Dekorator
{
    private int iloscKm;
    private int czasMinuty;
    private static String[] info = {"Ilość przejechanych km:","Czas w minutach:"};

    public Rower(Cwiczenia obiektDekorowany) {
        super(obiektDekorowany, "Rower");
    }

    @Override
    public String[] getInfo() {
        return info;
    }

    @Override
    public int[] getValue() {
        int[] temp = {iloscKm, czasMinuty};
        return temp;
    }

    @Override
    public void setValue1(int value) {
        iloscKm=value;
    }

    @Override
    public void setValue2(int value) {
        czasMinuty=value;
    }

    @Override
    public int getKalorie() {
        return obiektDekorowany.getKalorie()+iloscKm*czasMinuty;
    }
}
