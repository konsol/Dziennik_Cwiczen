/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pk.java.konrad.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Paweł
 */
public abstract class Dekorator implements Cwiczenia {
    private String nazwa;
    private Date dataTreningu;
    protected Cwiczenia obiektDekorowany;
    int id;
    
    @Override
    public String GetNazwa(){
        return nazwa;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public int getId(){
        return id;
    }
    
    public Dekorator(Cwiczenia obiektDekorowany, String nazwa){
        this.nazwa = nazwa;
        this.obiektDekorowany = obiektDekorowany;
        this.dataTreningu = Calendar.getInstance().getTime();
    }
    
    @Override
    public Date GetDataTreningu(){
        return obiektDekorowany.GetDataTreningu();
    }
    @Override
    public void setDataTreningu(Date data){
        obiektDekorowany.setDataTreningu(data);
    }
    
    public Date GetDataCwiczenia(){
        return dataTreningu;
    }
    
    public void setDate(Date dataTreningu){
        this.dataTreningu=dataTreningu;
    }
    
    public int setObiektDekorowany(Cwiczenia obiektDekorowany){
        this.obiektDekorowany = obiektDekorowany;
        return 0;
    }
    
    @Override
    public List<Dekorator> getCwiczenia(String nazwa) {
        List<Dekorator> l = obiektDekorowany.getCwiczenia(nazwa);
        if(this.nazwa.equals(nazwa)) l.add(this);
        return l;
    }
    
    public abstract String[] getInfo();
    public abstract int[] getValue();
    public abstract void setValue1(int value);
    public abstract void setValue2(int value);
}
