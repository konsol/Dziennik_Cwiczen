/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pk.java.konrad.controller;

import com.pk.java.konrad.view.ViewFactory;
import java.awt.event.ActionEvent;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import junit.framework.TestCase;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 *
 * @author Paweł
 */
public class MainControllerTest extends TestCase {
    
    public MainControllerTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    /**
     * Test of getInstance method, of class MainController.
     */
    public void testGetInstance() {
        System.out.println("getInstance");
        ViewFactory vf = new ViewFactory();
        MainController.viewFactoryStatic=vf;
        MainController result = MainController.getInstance();
        assertNotNull(result);
        MainController result2 = MainController.getInstance();
        assertEquals(result2, result);
    }

    /**
     * Test of registerController method, of class MainController.
     */
    public void testRegisterController() {
        System.out.println("registerController");
        Controller c = mock(AddController.class);
        doNothing().when(c).distributionActionEvent(anyString(),any(ActionEvent.class),anyObject());
        String name = "mockAddControler";
        MainController instance = MainController.getInstance();
      
        instance.registerController(c, name);
        
        instance.distributionActionEvent(name, null, null);
        verify(c).distributionActionEvent(eq(name),any(ActionEvent.class),anyObject());
    }

    /**
     * Test of distributionActionEvent method, of class MainController.
     */
    public void testDistributionActionEvent() {
        System.out.println("distributionActionEvent");
        
        MainController instance = MainController.getInstance();
        
        String name1 = "mockControler1";
        String name2 = "mockControler2";
        Object eventSource = new Object();
        ActionEvent ae = new ActionEvent(eventSource, 1, "comand");
        
        Controller c1 = mock(AddController.class);
        doNothing().when(c1).distributionActionEvent(anyString(),any(ActionEvent.class),anyObject());
        instance.registerController(c1, name1);
        
        Controller c2 = mock(AddController.class);
        doNothing().when(c2).distributionActionEvent(anyString(),any(ActionEvent.class),anyObject());
        instance.registerController(c2, name2);
        
        instance.distributionActionEvent(name1, ae, null);
        verify(c1).distributionActionEvent(eq(name1),eq(ae),anyObject());
        
        instance.distributionActionEvent(name2, ae, null);
        verify(c2).distributionActionEvent(eq(name2),eq(ae),anyObject());
    }
}
