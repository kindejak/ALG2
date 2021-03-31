package cz.tul.kindejak;

public abstract class Shape {

    protected String name = "Geometric object";

    public double getArea() {
        return 0;
    }

    public String getShapeName(){
        return this.getClass().getSimpleName();
    }
}
