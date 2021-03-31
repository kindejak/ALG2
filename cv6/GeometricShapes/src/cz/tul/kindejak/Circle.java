package cz.tul.kindejak;


public class Circle extends Shape{
    private double r;

    private Circle(double r) {
        this.r = r;
    }
    public static Circle createInstanceD(double d){
        return new Circle(d/2);
    }
    public static Circle createInstanceR(double r){
        return new Circle(r);
    }

    public double getR() {
        return r;
    }

    @Override
    public double getArea(){
        return Math.PI*r*r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "r=" + r +
                '}';
    }


}
