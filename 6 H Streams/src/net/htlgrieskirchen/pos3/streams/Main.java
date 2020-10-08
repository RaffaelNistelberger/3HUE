/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.streams;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
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
    public static void main(String[] args) {
        Main m = new Main();
        List<Weapon> list = m.readCsv();
        m.sortedByName(list);
        m.printByLambdaInTabelle(list);
        m.stringArrayRandom();
        m.aufgabeVier();
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
        System.out.println("-----------------------------------------------------------------");

        Printable tablePrint = (w) -> {
            System.out.printf("%-20s", " | " + w.getName());
            System.out.printf("%-9s", " | " + w.getCombatType());
            System.out.printf("%-11s ", " | " + w.getDamageType());
            System.out.printf("%-6s", " | " + w.getDamage());
            System.out.printf("%-3s", " | " + w.getSpeed());
            System.out.printf("%-6s", " | " + w.getMinStrength());
            System.out.printf("%-7s %n", " | " + w.getValue());
            System.out.println("+---------------------------------------------------------------+");
        };
        myList.forEach(w -> tablePrint.print(w));
        System.out.println("-----------------------------------------------------------------");
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
        byte[] b = new byte[10];
        for (int i = 0; i < arr.length; i++) {
            new Random().nextBytes(b);
            arr[i] = new String(b, Charset.forName("UTF-8"));
        }
        Arrays.stream(arr).forEach((n) -> System.out.println(n));
    }

    public void aufgabeVier() {
        final int result = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter((s) -> s % 2 == 1).map((s) -> s * s).sum();
        System.out.println(result);
    }
}
