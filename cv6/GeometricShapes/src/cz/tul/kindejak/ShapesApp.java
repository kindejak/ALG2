package cz.tul.kindejak;

import java.util.*;

/**
 *
 * @author JV
 */
public class ShapesApp {
    public static Scanner sc = new Scanner(System.in);
    public static List<Shape> shapes = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = readChoice(Integer.MAX_VALUE);
            switch (choice) {
                case 0:
                    break;
                case 1:
                    clearObjects();
                    break;
                case 2:
                    addSquare();
                    break;
                case 3:
                    addRectangle();
                    break;
                case 4:
                    addCircle();
                    break;
                case 5:
                    getAllObjectsInfo();
                    break;
                case 6:
                    computeArea();
                    break;
                case 7:
                    findWithMaxArea();
                    break;
                case 8:
                    getObjectInfo();
                    break;
                case 9: 
                    sortByArea();
                default:
                    System.out.println("Chybna volba");
            }
        } while (choice != 0);

    }

    private static void displayMenu() {
        System.out.println("");
        System.out.println("1. Nova sada");
        System.out.println("2. Pridej ctverec");
        System.out.println("3. Pridej obdelnik");
        System.out.println("4. Pridej kruh");
        System.out.println("5. Vypis geometricke utvary");
        System.out.println("6. Vypocti celkovou plochu");
        System.out.println("7. Vypis utvar s najvetsi plochou");
        System.out.println("8. Vypis plochu vybraneho utvaru");
        System.out.println("9. Setrid");
        System.out.println("0. Konec programu");
    }

    private static int readChoice(int maxChoice) {
        System.out.println("Tvoje volba: ");
        int choice = sc.nextInt();
        if (choice >= 0 && choice <= maxChoice){
            return choice;
        } else {
            return -1;
        }
    }

    private static void clearObjects() {
        shapes = new ArrayList<>();
    }

    private static void addSquare() {
        System.out.println("Strana a: ");
        int a = sc.nextInt();
        Square s = new Square(a);
        shapes.add(s);
    }

    private static void addRectangle() {
        System.out.println("Strana a a b: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        Rectangle r = new Rectangle(a,b);
        shapes.add(r);
    }

    private static void addCircle() {
        System.out.println("Polomer r: ");
        int r = sc.nextInt();
        Circle c = new Circle(r);
        shapes.add(c);
    }

    private static void getAllObjectsInfo() {
        int i = 0;
        for (Shape s : shapes) {
            System.out.println(i + ". " + s.toString());
            i++;
        }
    }

    private static void computeArea() {
        double area = 0;
        for (Shape s : shapes) {
            area += s.computeArea();
        }
        System.out.println(area);
    }
    private static void findWithMaxArea() {
        Shape maxAreaShape = shapes.get(0);
        for (Shape s : shapes) {
            if(s.computeArea() > maxAreaShape.computeArea()){
               maxAreaShape = s;
            }
        }
        System.out.println(maxAreaShape.toString());
        System.out.println(maxAreaShape.computeArea());
    }
    
    //zobrazi vsechny, necha vybrat a o vybranem zobrazit info
    private static void getObjectInfo() {
        getAllObjectsInfo();
        int choice = readChoice(shapes.size()-1);
        System.out.println(shapes.get(choice).toString());
    }
    
    //zobrazi objekty setridene podle plochy
    private static void sortByArea() {
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return Double.compare(o1.computeArea(),o2.computeArea());
            }
        });
    }
}
