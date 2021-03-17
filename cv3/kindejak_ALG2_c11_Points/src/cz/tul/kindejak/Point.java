package cz.tul.kindejak;

/**
 * @author Jakub Kindermann
 */

public class Point {

    private double x;
    private double y;


    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        Point p = new Point(3,4);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDistanceTo(Point b){
        return Math.sqrt((b.getX()-this.x)*(b.getX()-this.x)+(b.getY()-this.y)*(b.getY()-this.y));
    }

    public static double getDistanceBetween(Point a, Point b){
        return Math.sqrt((b.x-a.x)*(b.x-a.x)+(b.y-a.y)*(b.y-a.y));
    }
}
