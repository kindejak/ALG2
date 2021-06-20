package cz.tul.kindejak;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Today is:");
        System.out.print("Year:");
        int year = sc.nextInt();
        System.out.print("Month:");
        int month = sc.nextInt();
        System.out.print("Day:");
        int day = sc.nextInt();
        Calendar cal = new Calendar(day,month,year);
        String choice = "";
        choice = sc.nextLine();
        while (true){
            System.out.println(cal.thisMonthToString());
            System.out.println("type p for previous month, n for next month, e for exit");
            choice = sc.nextLine();
            if (choice.equals("p")){
                cal.previousMonth();
            }
            if (choice.equals("n")){
                cal.nextMonth();
            }
            if (choice.equals("e")){
                break;
            }
        }
    }
}
