package org.example.src;

public class Sistema {
    private double a, b, c;
    private double a2, b2, c2;
    private double d, dx, dy;

    public Sistema(double a, double b, double c, double a2, double b2, double c2) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.a2 = a2;
        this.b2 = b2;
        this.c2 = c2;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getA2() {
        return a2;
    }

    public void setA2(double a2) {
        this.a2 = a2;
    }

    public double getB2() {
        return b2;
    }

    public void setB2(double b2) {
        this.b2 = b2;
    }

    public double getC2() {
        return c2;
    }

    public void setC2(double c2) {
        this.c2 = c2;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public void calcolaD(){
        setD((a * b2) - (a2 * b));
    }
    public void calcolaDx(){
        setDx((c * b2) - (b * c2));
    }
    public void calcolaDy(){
        setDy((a * c2) - (a2 * c));
    }

    @Override
    public String toString() {
        return "Sistema{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", a2=" + a2 +
                ", b2=" + b2 +
                ", c2=" + c2 +
                ", d=" + d +
                ", dx=" + dx +
                ", dy=" + dy +
                '}';
    }
}
