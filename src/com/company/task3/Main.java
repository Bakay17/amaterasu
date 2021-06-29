package com.company.task3;

public class Main {
    public static void main(String[] args) {
        Backpack[] backpacks = new Backpack[3];
        backpacks[0] = new Backpack(20, 1, 1);
        backpacks[1] = new Backpack(50, 1, 1);
        backpacks[2] = new Backpack(13, 1, 1);

        int count = 1;
        for (Backpack backpack : backpacks) {
            System.out.println(count + " " + backpack.toString());
            count++;
        }

        // не очень понял это задание
    }
}
