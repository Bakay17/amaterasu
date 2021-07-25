package com.exam3.task3;

public class Backpack {
    private int round;
    private int flat;
    private int cylindrical;
    final int SIZE = 40;

    public Backpack(int round, int flat, int cylindrical) {
        this.round = round;
        this.flat = flat;
        this.cylindrical = cylindrical;
    }

    public Backpack(){
    }


    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public int getCylindrical() {
        return cylindrical;
    }

    public void setCylindrical(int cylindrical) {
        this.cylindrical = cylindrical;
    }

    public int getSIZE() {
        return SIZE;
    }

    @Override
    public String toString() {
        int sum = getRound() + getFlat() + getCylindrical();
        if (sum > SIZE) return String.format("Рюкзак переполнен, больше %s.(%s)", SIZE, sum);
        else return String.format("Ваш рюкзак готов.(%s)", sum);
    }
}
