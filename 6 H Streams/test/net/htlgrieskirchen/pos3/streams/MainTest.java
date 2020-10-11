/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.streams;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raffa
 */
public class MainTest {

    public MainTest() {
    }

    /**
     * Test of init method, of class Main.
     */
//    @Test
//    public void testInit() {
//        System.out.println("init");
//        Main instance = new Main();
//        instance.init();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of main method, of class Main.
//     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        Main.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of sortedByDamage method, of class Main.
     */
    @Test
    public void testSortedByDamage() {
        Main m = new Main();
        System.out.println("sortedByDamage");
        List<Weapon> myList = m.readCsv();
        Main instance = new Main();
        List<Weapon> expResult = m.readCsv();
        m.sortedByDamage(expResult);
        List<Weapon> result = instance.sortedByDamage(myList);
        assertEquals(expResult.get(4).toString(), result.get(4).toString());

    }

    /**
     * Test of readCsv method, of class Main.
     */
//    @Test
//    public void testReadCsv() {
//        System.out.println("readCsv");
//        Main instance = new Main();
//        List<Weapon> expResult = null;
//        List<Weapon> result = instance.readCsv();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of sortedByName method, of class Main.
     */
    @Test
    public void testSortedByName() {
        Main m = new Main();
        System.out.println("sortedByName");
        List<Weapon> myList = m.readCsv();
        Main instance = new Main();
        List<Weapon> expResult = m.readCsv();
        m.sortedByName(expResult);
        List<Weapon> result = instance.sortedByName(myList);
        assertEquals(expResult.get(3).toString(), result.get(3).toString());

    }

    /**
     * Test of printByLambda method, of class Main.
     */
//    @Test
//    public void testPrintByLambda() {
//        System.out.println("printByLambda");
//        List<Weapon> myList = null;
//        Main instance = new Main();
//        instance.printByLambda(myList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of printByLambdaInTabelle method, of class Main.
     */
//    @Test
//    public void testPrintByLambdaInTabelle() {
//        System.out.println("printByLambdaInTabelle");
//        List<Weapon> myList = null;
//        Main instance = new Main();
//        instance.printByLambdaInTabelle(myList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of intArrayRandom method, of class Main.
     */
//    @Test
//    public void testIntArrayRandom() {
//        System.out.println("intArrayRandom");
//        Main instance = new Main();
//        instance.intArrayRandom();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of stringArrayRandom method, of class Main.
     */
//    @Test
//    public void testStringArrayRandom() {
//        System.out.println("stringArrayRandom");
//        Main instance = new Main();
//        instance.stringArrayRandom();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of aufgabeVier method, of class Main.
//     */
//    @Test
//    public void testAufgabeVier() {
//        System.out.println("aufgabeVier");
//        Main instance = new Main();
//        instance.aufgabeVier();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of aufgabeDrei method, of class Main.
//     */
//    @Test
//    public void testAufgabeDrei() {
//        System.out.println("aufgabeDrei");
//        List<Integer> list = null;
//        List<String> stringList = null;
//        Main instance = new Main();
//        instance.aufgabeDrei(list, stringList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
