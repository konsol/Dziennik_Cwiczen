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
public class Przysiady extends Dekorator
{
    private int iloscPowtorzen;
    private int iloscSerii;
    private static String[] info = {"Ilość powtórzeń:","Ilość serii:"};

    public Przysiady(Cwiczenia obiektDekorowany) {
        super(obiektDekorowany, "Przysiady");
    }

    @Override
    public String[] getInfo() {
        return info;
    }

    @Override
    public int[] getValue() {
        int[] temp = {iloscPowtorzen, iloscSerii};
        return temp;
    }

    @Override
    public void setValue1(int value) {
        iloscPowtorzen=value;
    }

    @Override
    public void setValue2(int value) {
        iloscSerii=value;
    }

    @Override
    public int getKalorie() {
        return obiektDekorowany.getKalorie()+iloscPowtorzen*iloscSerii;
    }
}