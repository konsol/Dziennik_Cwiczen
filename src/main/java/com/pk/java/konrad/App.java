package com.pk.java.konrad;

import com.pk.java.konrad.controller.AddController;
import com.pk.java.konrad.controller.MainController;
import com.pk.java.konrad.controller.MainViewController;
import com.pk.java.konrad.controller.StatController;
import com.pk.java.konrad.view.ViewFactory;
import java.util.Date;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[]args) 
    {
        //utworzenie fabryki widoków
        ViewFactory f = new ViewFactory();
        //przekazanie fabryki do statycznej zmiennej klasy MainControler gdzie będzie użyta w metodzie getInstance
        MainController.viewFactoryStatic = f;
        
        //utworzenie obiektu MainControllera
        MainController c = MainController.getInstance();
        
        //dodanie pozostałych kontrolerów do mainControllera
        c.registerController(new MainViewController(), MainViewController.nazwa);
        c.registerController(new StatController(), StatController.nazwa);
        c.registerController(new AddController(), AddController.nazwa);
        
    }
}
