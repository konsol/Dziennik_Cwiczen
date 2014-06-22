/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pk.java.konrad.model;

import junit.framework.TestCase;

/**
 *
 * @author Paweł
 */
public class DecoratorFactoryTest extends TestCase {
    
    public DecoratorFactoryTest(String testName) {
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
     * Test of getInstance method, of class DecoratorFactory.
     */
    public void testGetInstance() {
        System.out.println("getInstance");
        DecoratorFactory result = DecoratorFactory.getInstance();
        assertNotNull(result);
        DecoratorFactory result2 = DecoratorFactory.getInstance();
        assertEquals(result2, result);
    }

    /**
     * Test of getDecorator method, of class DecoratorFactory.
     */
    public void testGetDecorator() {
        System.out.println("getDecorator");
        String nazwa = "Bieg";
        Cwiczenia obiektDekorowany = new Dzien();
        DecoratorFactory instance = new DecoratorFactory();
        Dekorator result = instance.getDecorator(nazwa, obiektDekorowany);
        assertEquals( result.getClass(), new Bieg(obiektDekorowany).getClass() );
        assertEquals( result.obiektDekorowany, obiektDekorowany);
        
        obiektDekorowany=result;
        result = instance.getDecorator(nazwa, obiektDekorowany);
        assertEquals( result.obiektDekorowany, obiektDekorowany);
    }
    
}
