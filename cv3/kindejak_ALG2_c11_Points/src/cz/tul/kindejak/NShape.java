package cz.tul.kindejak;

import java.util.Arrays;


/**
 * @author Jakub Kindermann
 */

public class NShape {
    //data
    private Point[] shape;

    //constructor
    public NShape(Point[] shape){
        this.shape = Arrays.copyOf(shape,shape.length);
    }

    public NShape(double[][] shape){
        Point p;
        this.shape = new Point[shape.length];
        for (int i = 0; i < shape.length; i++) {
            p = new Point(shape[i][0],shape[i][1]);
            this.shape[i] = p;
        }
    }

    public double perimeter(){
        double perim = 0;
        for (int i = 0; i < shape.length - 1; i++) {
            perim += shape[i].getDistanceTo((shape[i+1]));
        }
        perim = perim + shape[shape.length - 1].getDistanceTo(shape[0]);
        return perim;
    }

    public double area(){
        double area = 0;
        for (int i = 0; i < shape.length - 1; i++) {
            area = area + (shape[i].getX()*shape[i+1].getY() - shape[i+1].getX()*shape[i].getY());
        }
        area = area + (shape[shape.length - 1].getX()*shape[0].getY() - shape[0].getX()*shape[shape.length - 1].getY());
        return 0.5*Math.abs(area);
    }
}
