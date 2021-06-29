package com.company.task1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] numbers = new int[30];
        HashSet<Integer> integers = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rnd.nextInt(100) + 1;
        }

        System.out.println(Arrays.toString(numbers));

        List<Integer> list = new ArrayList<>(integers);

        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                if (numbers[i] % 5 == 0) {
                    list.add(0, numbers[i]);
                    count++;
                } else {
                    list.add(count, numbers[i]);
                }
                integers.add(numbers[i]);
            }
        }

        integers = new HashSet<>(list);

        System.out.println("\nЧетные числа:\n" + integers);
        System.out.println("\nСортровка(сначало % 5 == 0):\n" + list);
    }
}
