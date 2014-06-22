/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pk.java.konrad.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Paweł
 */
public class Dzien implements Cwiczenia{
    private Date data;
    
    public Dzien(){
     data = Calendar.getInstance().getTime();
    }
    
    @Override
    public String GetNazwa() {
        return "";
    }

    @Override
    public Date GetDataTreningu() {
        return data;
    }

    @Override
    public int getKalorie() {
        return 0;
    }

    @Override
    public List<Dekorator> getCwiczenia(String nazwa) {
        return new ArrayList<>();
    }

    @Override
    public void setDataTreningu(Date data) {
        this.data=data;
    }
    
}
