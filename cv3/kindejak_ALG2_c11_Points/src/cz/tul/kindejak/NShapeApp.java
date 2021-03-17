package cz.tul.kindejak;

import java.util.Scanner;

public class NShapeApp {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double[][] array = loadPoints2();
        NShape shape = new NShape(array);
        System.out.println("Perimeter: " + shape.perimeter());
        System.out.println("Area: " + shape.area());
    }

    public static Point[] loadPoints1(){
        System.out.println("Enter number of points.");
        int n = sc.nextInt();
        Point[] array = new Point[n];
        System.out.println("Enter x and y of each point.");
        for (int i = 0; i < n; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            Point p = new Point(x,y);
            array[i] = p;
        }
        return array;

    }

    public static double[][] loadPoints2(){
        System.out.println("Enter number of points.");
        int n = sc.nextInt();
        double[][] array = new double[n][2];
        System.out.println("Enter x and y of each point.");
        for (int i = 0; i < n; i++) {
            array[i][0] = sc.nextDouble();
            array[i][1] = sc.nextDouble();
        }
        return array;

    }
}
