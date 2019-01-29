package com.example.yi.myapplication;

public class Service {
    public String name;
    public double rate;

    public Service() {}

    public Service(String name, double rate) {

        this.name = name;
        this.rate = rate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getName() {

        return name;
    }

    public double getRate() {
        return rate;
    }

    public String toString(){
        return name+"\n$"+rate+"/hour";
    }


}
