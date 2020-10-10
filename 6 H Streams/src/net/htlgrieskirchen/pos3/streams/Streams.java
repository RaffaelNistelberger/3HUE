package net.htlgrieskirchen.pos3.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Streams {

    public double average(int[] numbers) {
        return Arrays.stream(numbers).asDoubleStream().average().getAsDouble();
    }

    public List<String> upperCase(String[] strings) {
        return Arrays.stream(strings).map(String::toUpperCase).collect(Collectors.toList());
    }

    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        try {
            return weapons.stream().min(Comparator.comparing(Weapon::getDamage)).get();
        } catch (NoSuchElementException n) {
            return null;
        }

    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        try {
            return weapons.stream().max(Comparator.comparing(Weapon::getMinStrength)).get();
        } catch (NoSuchElementException n) {
            return null;
        }
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return weapons.stream().filter(s -> s.getDamageType() == DamageType.MISSILE).collect(Collectors.toList());
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        try {
            return weapons.stream().max((Weapon o1, Weapon o2) -> o1.getName().length() - o2.getName().length()).get();
        } catch (NoSuchElementException n) {
            return null;
        }
    }

    public List<String> toNameList(List<Weapon> weapons) {
//        return weapons.stream().map((s) -> s.getName()).collect(Collectors.toList());
        return weapons.stream().map(Weapon::getName).collect(Collectors.toList());
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        return weapons.stream().mapToInt(Weapon::getSpeed).toArray();
    }

    public int sumUpValues(List<Weapon> weapons) {
//        return weapons.stream().mapToInt((s) -> s.getValue()).sum();
        return weapons.stream().mapToInt(Weapon::getValue).sum();
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
//        return weapons.stream().mapToLong((s) -> s.hashCode()).sum();
        return weapons.stream().mapToInt(Weapon::hashCode).sum();
//        return weapons.stream()
//                .map(Weapon::hashCode)
//                .reduce(Integer::sum)
//                .orElse(0);
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        return weapons.stream().map((s) -> s).collect(Collectors.toList());
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
//        weapons.stream().map((Weapon s) -> s.setValue();
        weapons.stream().forEach(v -> v.setValue((int) (v.getValue() * 1.1)));
    }

}
