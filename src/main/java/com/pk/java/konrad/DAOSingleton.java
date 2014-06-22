/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pk.java.konrad;

import com.pk.java.konrad.model.Cwiczenia;
import com.pk.java.konrad.model.DecoratorFactory;
import com.pk.java.konrad.model.Dekorator;
import com.pk.java.konrad.model.Dzien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Paweł
 */
public class DAOSingleton {
    SimpleDateFormat odczyt, zapis, tylkodata;
    //private HashMap<Integer, Cwiczenia> arCwiczenia;
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement insert = null;
    
    private static DAOSingleton instance = null;
   
    private DAOSingleton() throws SQLException 
    {
        this.odczyt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        this.zapis = new SimpleDateFormat("yyyy MM dd HH mm ss");
        this.tylkodata = new SimpleDateFormat("yyyyMMdd");
        //arCwiczenia = new HashMap<>();
        connect = DriverManager.getConnection("jdbc:mysql://localhost/konrad?user=konrad&password=konrad");
        statement = connect.createStatement();
        insert = connect.prepareStatement("INSERT INTO `cwiczenia`(typ, data, val1, val2, idPoprzednie) VALUES ( "+
                    "(select id from typcwiczenia where typ=?), STR_TO_DATE(?,'%Y %m %d %H %i %s'), " +
                    "?, ?, ? )", Statement.RETURN_GENERATED_KEYS);
        
        //System.out.println(GetDataNajwczesniejsza("Przysiady"));
    }
    
    @Override
    protected void finalize() throws Throwable{
        connect.close();
        super.finalize();
    }
    
    public static DAOSingleton getInstance() 
    {
       if(instance == null) 
       {
           try {
               instance = new DAOSingleton();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Nie udało się połączyć z bazą danych","Error",JOptionPane.ERROR_MESSAGE+JOptionPane.OK_OPTION);
               Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
               System.exit(0);
           }
       }
       return instance;
    }
    
    private Cwiczenia odczyt(int id) throws SQLException, ParseException{
        if(id==0) return new Dzien();
        
        String query = "SELECT cwiczenia.id, typcwiczenia.typ, data, val1, val2, idPoprzednie FROM cwiczenia JOIN typcwiczenia ON cwiczenia.typ=typcwiczenia.id WHERE cwiczenia.id="+id;
        resultSet = statement.executeQuery(query);
        resultSet.first();
        
        String typ = resultSet.getString("typ");
        Date data = odczyt.parse(resultSet.getString("data"));
        int val1 = resultSet.getInt("val1");
        int val2 = resultSet.getInt("val2");
        int poprzednie = resultSet.getInt("idPoprzednie");
        
        Cwiczenia c = odczyt(poprzednie);
        Dekorator d = DecoratorFactory.getInstance().getDecorator(typ, c);
        d.setValue1(val1);
        d.setValue2(val2);
        d.setDate(data);
        
        return d;
    }
    
    private int[] maxIdOnDay(Date od, Date doo) throws SQLException{
        Date doo2 = new Date(doo.getTime() + (1000 * 60 * 60 * 24));
        String query = "SELECT max(id) id FROM ( " +
                "SELECT id, DATE_FORMAT(`data`,'%Y%m%d') data1 FROM `cwiczenia` where data " +
                "BETWEEN STR_TO_DATE('"+zapis.format(od)+"','%Y %m %d %H %i %s') and STR_TO_DATE('"+zapis.format(doo2)+"','%Y %m %d %H %i %s')" +
            ") tab Group by data1";
        System.out.println(query);
        ArrayList<Integer> l= new ArrayList<>();
        resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            l.add(resultSet.getInt("id"));
        }
        System.out.println(l);
        int[] array = new int[l.size()];
        for(int i = 0; i < l.size(); i++) array[i] = l.get(i);
        return array;
    }
    
    private int maxIdOnDay(Date data) throws SQLException{
        String query = "select max(id) id from cwiczenia where DATE_FORMAT(`data`,'%Y%m%d')='"+ tylkodata.format(data) +"'";
        resultSet = statement.executeQuery(query);
        if (resultSet.next())
            return resultSet.getInt("id");
        else return 0;
    }
    
    public ArrayList<Cwiczenia> GetListaCwiczen(String A_Nazwa, Date od, Date doo)
    {
        int[] maxId;
        Cwiczenia c;
        ArrayList<Cwiczenia> lista;
        try{
            c = new Dzien();
            lista = new ArrayList<>();
            maxId = maxIdOnDay(od, doo);
            for(int i=0; i<maxId.length; i++){
                System.out.println("maxid = "+maxId[i]);
                c = odczyt(maxId[i]);
                List<Dekorator> l = c.getCwiczenia(A_Nazwa);
                lista.addAll(l);
            }
            return lista;
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public String[] GetCwiczeniaInfo(String nazwa)
    {
        String[] tabInfo = new String[2];
        
        switch(nazwa)
        {
            case "Bieg":
                tabInfo[0] = "km";
                tabInfo[1] = "min";
                break;
            case "Pływanie":
                tabInfo[0] = "m";
                tabInfo[1] = "min";
                break;
            case "Skakanka":
                tabInfo[0] = "serie";
                tabInfo[1] = "min";
                break;
            case "Rower":
                tabInfo[0] = "km";
                tabInfo[1] = "min";
                break;
            case "Pompki":
                tabInfo[0] = "powtórzenia";
                tabInfo[1] = "serie";
                break;
            case "Przysiady":
                tabInfo[0] = "powtórzenia";
                tabInfo[1] = "serie";
                break;
        }
        
        return tabInfo;
    }
    
    private void zapisDoBazy(int idPoprzednie, Dekorator d) throws SQLException{
        insert.setString(1, d.GetNazwa());
        insert.setString(2, zapis.format(d.GetDataCwiczenia()));
        insert.setInt(3, d.getValue()[0]);
        insert.setInt(4, d.getValue()[1]);
        insert.setInt(5, idPoprzednie);
        insert.executeUpdate();
      
        resultSet = insert.getGeneratedKeys();
        if (resultSet.next()) {
            d.setId((int) resultSet.getLong(1));
        } else {
            throw new SQLException("Creating user failed, no generated key obtained.");
        }
    }
    
    public int Dodaj(Dekorator cwiczenie)
    {
        int idPoprzedni;
        try {
            idPoprzedni = maxIdOnDay(cwiczenie.GetDataCwiczenia());
            zapisDoBazy(idPoprzedni, cwiczenie);
        } catch (SQLException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
        
        return 0;
    }
    
    public Date GetDataNajwczesniejsza(String nazwaCwiczenia)
    {
        try{
            Date data;
            String query = "select min(data) min from cwiczenia where typ = (select id from typcwiczenia where typ = '"+nazwaCwiczenia+"')";
            resultSet = statement.executeQuery(query);

            if(resultSet.next() && resultSet.getString("min")!=null){
                data = odczyt.parse(resultSet.getString("min"));
            }
            else data = Calendar.getInstance().getTime();

            return data;
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Date GetDataNajpozniejsza(String nazwaCwiczenia)
    {   
        try{
            Date data;
            String query = "select max(data) max from cwiczenia where typ = (select id from typcwiczenia where typ = '"+nazwaCwiczenia+"')";
            resultSet = statement.executeQuery(query);

            if(resultSet.next() && resultSet.getString("max")!=null){
                data = odczyt.parse(resultSet.getString("max"));
            }
            else data = Calendar.getInstance().getTime();

            return data;
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    
    
}
