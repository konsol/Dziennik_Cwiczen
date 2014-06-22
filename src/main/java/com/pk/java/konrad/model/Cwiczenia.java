/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pk.java.konrad.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Paweł
 */
public interface Cwiczenia{
    public String GetNazwa();
    public Date GetDataTreningu();
    public void setDataTreningu(Date data);
    public int getKalorie();
    public List<Dekorator> getCwiczenia(String nazwa);
}
