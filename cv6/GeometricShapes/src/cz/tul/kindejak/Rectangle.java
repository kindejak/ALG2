package cz.tul.kindejak;

public class Rectangle extends Shape {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double calculateArea(){
        return a*b;
    }


    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    @Override
    public double getArea() {
        return calculateArea();
    }
}
