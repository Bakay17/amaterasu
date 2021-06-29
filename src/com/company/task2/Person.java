package com.company.task2;

public class Person {
    private String name;
    private String soname;

    public Person(String name, String soname) {
        this.name = name;
        this.soname = soname;
    }

    public Person(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoname() {
        return soname;
    }

    public void setSoname(String soname) {
        this.soname = soname;
    }

    @Override
    public String toString() {
        return name + " " + soname;
    }
}
