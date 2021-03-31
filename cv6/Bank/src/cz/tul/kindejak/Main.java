package cz.tul.kindejak;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
		Person p1 = new Person("Pekar");
		Person p2 = new Person("Sevcova");
    	Company c1 = new Company("Skoda");
    	p1.addAccount(1000);
    	p1.addAccount(500);
    	p2.addAccount(1200);
    	c1.addAccount(120);
    	Client[] clients = {p1,p2,c1};
    	printArr(clients);

    	System.out.printf("%nAfter sorting: %n");
    	Arrays.sort(clients);
		printArr(clients);
    }

    public static void printArr(Client[] clients){
		for (int i = 0; i < clients.length; i++) {
			System.out.println(clients[i].greet() +
					" Total deposit: " +
					clients[i].totalDeposit());

		}
	}
}
