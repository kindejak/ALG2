package cz.tul.kindejak;

import java.util.Scanner;

public class BusApp {

    public static void main(String[] args) {
	Bus universityBus = new Bus(41,15,"DPMLJ");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.println("Station no." + (i + 1));
            System.out.println(universityBus.toString());
            System.out.println("How many people are going to get off and get on the bus?");
            int off = sc.nextInt();
            int peopleInside = universityBus.getPeopleInside();
            if (peopleInside - off < 0){
                System.out.println("Only " + peopleInside + " people were in the bus and could get off.");
                universityBus.getOff(peopleInside);
            } else {
                universityBus.getOff(off);
            }

            peopleInside = universityBus.getPeopleInside();
            int seats = universityBus.getCapacity();
            int on = sc.nextInt();
            if (peopleInside + on > seats){
                int max = seats - peopleInside;
                System.out.println("Only " + max + " people were able to get on the bus.");
                universityBus.getOn(max);
            } else {
                universityBus.getOn(on);
            }

        }
        int peopleInside = universityBus.getPeopleInside();
        universityBus.everyoneGetsOff();
        System.out.println("Terminal station");
        System.out.println(peopleInside + " people got off the bus.");
        System.out.println(universityBus.toString());
    }
}
