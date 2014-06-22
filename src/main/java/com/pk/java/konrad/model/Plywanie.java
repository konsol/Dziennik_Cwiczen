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
public class Plywanie extends Dekorator
{
    int iloscM;
    int czasMinuty;
    private static String[] info = {"Ilość przepłyniętych m:","Czas w minutach:"};


    public Plywanie(Cwiczenia obiektDekorowany) {
        super(obiektDekorowany, "Pływanie");
    }

    @Override
    public String[] getInfo(){
        return info;
    }

    @Override
    public int[] getValue() {
        int[] temp = {iloscM, czasMinuty};
        return temp;
    }

    @Override
    public void setValue1(int value) {
        this.iloscM=value;
    }

    @Override
    public void setValue2(int value) {
        this.czasMinuty=value;
    }

    @Override
    public int getKalorie() {
        return obiektDekorowany.getKalorie()+iloscM*czasMinuty;
    }
   
}
