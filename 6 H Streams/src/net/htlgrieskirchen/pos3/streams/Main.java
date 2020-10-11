/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author raffa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    List<Integer> intList = new ArrayList<>();
    List<String> stringList = new ArrayList<>();

    public void init() {
        intList.add(1);
        intList.add(2);
        intList.add(-3);
        intList.add(-2);
        intList.add(-8);
        intList.add(5);
        intList.add(4);
        intList.add(-4);
        intList.add(3);
        intList.add(0);
        intList.add(null);

        stringList.add("abcd");
        stringList.add("abysdgasdfasdfasdfasdcd");
        stringList.add("abasdfasdfcd");
        stringList.add("a");
        stringList.add("d a");

    }

    public static void main(String[] args) {
        Main m = new Main();
        List<Weapon> list = m.readCsv();
        m.sortedByName(list);
        m.printByLambdaInTabelle(list);
        m.stringArrayRandom();
        m.aufgabeVier();

        m.init();

        m.aufgabeDrei(m.intList, m.stringList);

    }

    public List<Weapon> sortedByDamage(List<Weapon> myList) {
        myList.sort(new Comparator<Weapon>() {
            @Override
            public int compare(Weapon o1, Weapon o2) {

                return Integer.compare(o2.getDamage(), o1.getDamage());
            }
        });

        return myList;
    }

    public List<Weapon> readCsv() {
        List<Weapon> list = new ArrayList<>();
        try {
            list = Files.lines(new File("weapons.csv").toPath())
                    .skip(1)
                    .map(s -> s.split(";"))
                    .map(s -> new Weapon(
                    s[0],
                    CombatType.valueOf(s[1]),
                    DamageType.valueOf(s[2]),
                    Integer.parseInt(s[3]),
                    Integer.parseInt(s[4]),
                    Integer.parseInt(s[5]),
                    Integer.parseInt(s[6])
            ))
                    .collect(Collectors.toList());

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Weapon> sortedByName(List<Weapon> myList) {
        myList.sort(new Comparator<Weapon>() {
            @Override
            public int compare(Weapon o1, Weapon o2) {
                if ((o1.getCombatType().toString().compareTo(o2.getCombatType().toString()) == 0)) {
                    if ((o1.getDamageType().toString().compareTo(o2.getDamageType().toString()) == 0)) {
                        return o1.getName().compareTo(o2.getName());
                    } else {
                        return o1.getDamageType().toString().compareTo(o2.getDamageType().toString());
                    }
                } else {
                    return o1.getCombatType().toString().compareTo(o2.getCombatType().toString());
                }
            }
        });

        return myList;
    }

    public void printByLambda(List<Weapon> myList) {
        Printable printable = w -> System.out.println(w.getName() + " [" + w.getDamageType() + " = " + w.getDamage() + "]");
        for (int i = 0; i < myList.size(); i++) {
            printable.print(myList.get(i));
        }

    }

    public void printByLambdaInTabelle(List<Weapon> myList) {
        System.out.printf("%-20s", " | " + "Name");
        System.out.printf("%-13s", " | " + "CombatType");
        System.out.printf("%-13s ", " | " + "DamageType");
        System.out.printf("%-9s", " | " + "Damage");
        System.out.printf("%-8s", " | " + "Speed");
        System.out.printf("%-10s", " | " + "Lenghth");
        System.out.printf("%-7s %n", " | " + "Value");
        System.out.println("------------------------------------------------------------------------------------");

        Printable tablePrint = (w) -> {
            System.out.printf("%-20s", " | " + w.getName());
            System.out.printf("%-13s", " | " + w.getCombatType());
            System.out.printf("%-13s ", " | " + w.getDamageType());
            System.out.printf("%-9s", " | " + w.getDamage());
            System.out.printf("%-8s", " | " + w.getSpeed());
            System.out.printf("%-10s", " | " + w.getMinStrength());
            System.out.printf("%-7s", " | " + w.getValue());
            System.out.printf("%s %n", " |");
            System.out.println("+----------------------------------------------------------------------------------+");
        };
        myList.forEach(w -> tablePrint.print(w));

//        String[] column = {"Name", "CombatType", "DamageType", "Damage", "Speed", "Strength", "Value"};
//        DefaultTableModel tableModel = new DefaultTableModel(column, 0);
//        JTable table = new JTable(tableModel);
//
//        for (int i = 0; i < myList.size(); i++) {
//            Object[] obj = {myList.get(i).getName(), myList.get(i).getCombatType(), myList.get(i).getDamageType(), myList.get(i).getDamage(), myList.get(i).getSpeed(), myList.get(i).getMinStrength(), myList.get(i).getValue()};
//            //Weapon w = new Weapon(myList.get(i).getName(), myList.get(i).getCombatType(), myList.get(i).getDamageType(), myList.get(i).getDamage(), myList.get(i).getSpeed(), myList.get(i).getMinStrength(), myList.get(i).getValue());
//            tableModel.addRow(obj);
//
//        }
//        tableModel.addColumn(column);
    }

    public void intArrayRandom() {
        int[] arr = new int[10000];
        int max = 100;
        int min = 0;
        int range = max - min + 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * range) + min;
        }
    }

    public void stringArrayRandom() {
        String[] arr = new String[10];
        String alpahbet = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
        String[] tmp = alpahbet.split(",");
        for (int i = 0; i < 10; i++) {
            String line = "";
            for (int j = 0; j < 10; j++) {
                int random = (int) (Math.random() * tmp.length + -1);
                line += tmp[random];
            }
            arr[i] = line;
        }
        Arrays.stream(arr).forEach((n) -> System.out.println(n));

    }

    public void aufgabeVier() {
        final int result = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter((s) -> s % 2 == 1).map((s) -> s * s).sum();
        System.out.println(result);
    }

    public void aufgabeDrei(List<Integer> list, List<String> stringList) {
        final Predicate<Integer> isEven = e -> e % 2 == 0;
        final Predicate<Integer> numberIsZero = e -> e == 0;
        final Predicate<Integer> isPositive = e -> e > 0;
        final Predicate<Integer> isNull = e -> e == null;
        final Predicate<String> isShortWord = e -> e.length() < 4;

        try {

            list.stream().filter(isEven.and(isPositive)).forEach((s) -> System.out.println(s));
            list.stream().filter(isEven.negate().and(isPositive)).forEach((s) -> System.out.println(s));

            stringList.stream().filter(isShortWord).forEach((s) -> System.out.println(s));
            list.stream().filter(numberIsZero).forEach((s) -> System.out.println(s));
            list.stream().filter(isNull).forEach((s) -> System.out.println("isNull == true"));

        } catch (NullPointerException n) {

        }
    }
}
