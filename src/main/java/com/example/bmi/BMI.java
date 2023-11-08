package com.example.bmi;

public class BMI {
    double w;
    double l;


    public double getW() {
        return w;
    }

    public double getL() {
        return l;
    }

    public void setW(double w) {
        this.w = w;
    }

    public void setL(double l) {
        this.l = l;
    }

    public double BmiCalc(){
        return w/((l/100)*(l/100));
    }

    public String toString() {
        return ("Индекс массы тела = " + String.format("%.3f", BmiCalc()));
    }
}
