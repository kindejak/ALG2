package cz.tul.kindejak;

import java.util.ArrayList;

public class ShapesApp {

    public static void main(String[] args) {
	Circle c1 = Circle.createInstanceR(2);
	Rectangle r1 = new Rectangle(2,3);
	Circle c2 = Circle.createInstanceD(4.5);

	System.out.println("1st try");
	double area = c1.getArea() + c2.getArea() + r1.calculateArea();
	System.out.printf("%f == %s %s %s",area,c1.toString(),r1.toString(),c2.toString());
		ArrayList geomShape2 = new ArrayList();
		geomShape2.add(c1);
		geomShape2.add(r1);
		geomShape2.add(c2);
		double area2 = 0;
		for (int i = 0; i < geomShape2.size(); i++) {
			if (geomShape2.get(i) instanceof Circle){
				area2 = area2 + ((Circle) geomShape2.get(i)).getArea();
			} else if(geomShape2.get(i) instanceof Rectangle){
				area2 = area2 + ((Rectangle) geomShape2.get(i)).calculateArea();
			}
		}
		System.out.println("2nd try");
		System.out. println(area2);

		ArrayList geomShape3 = new ArrayList();
		geomShape3.add(c1);
		geomShape3.add(c2);
		geomShape3.add(r1);
		double area3 = 0;
		for (int i = 0; i < geomShape3.size(); i++) {
			area3 = area3 + (geomShape3.get(i)).getArea();
		}
    }
}
