package com.company.task2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Person[] person = new Person[8];
        person[0] = new Person("Bakyt", "Sydykov");
        person[1] = new Person("Syimyk", "Boposhew");
        person[2] = new Person("Aidana", "Kaypjanova");
        person[3] = new Person("Altynai", "Dubekova");
        person[4] = new Person("Azamat", "Kenjebekov");
        person[5] = new Person("Amir", "Saidov");
        person[6] = new Person("Bakyt", "Sydykov");
        person[7] = new Person("Erlan", "Joldoshev");

        LinkedList<Person> people = new LinkedList<>(Arrays.asList(person));

        duplicationList(people, person);
    }

    public static void duplicationList (LinkedList<Person> people, Person[] personArray){
        boolean str = false;
        for (int i = 0; i < people.size() - 1; i++) {
            if (personArray[i].equals(personArray[i+1])){
                try {
                    str = personArray[i].equals(personArray[i+1]);
                } catch (Exception e) {
                    System.out.println("Есть дублирующиеся элементы.");
                }
            }
        }
    }
}
