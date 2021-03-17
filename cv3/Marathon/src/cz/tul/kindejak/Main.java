package cz.tul.kindejak;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    final static int RUNNERNUM = 0;
    final static int RUNNERTIME = 1;
    final static int STARTTIME = 9*3600 + 30*60; //starts in 9:30:00
    final static double RACELENGTH = 42.125;


    public static void main(String[] args) {
        int[][] runnersArr = loadArr();
        Race marathon = new Race(RACELENGTH,STARTTIME,runnersArr);
        System.out.println(marathon.toString());

    }

    public static int[][] loadArr(){
        int runnersCount = sc.nextInt();
        int[][] runnersArr = new int[runnersCount][2];
        for (int i = 0; i < runnersCount; i++) {
            runnersArr[i][RUNNERNUM] = sc.nextInt();
            runnersArr[i][RUNNERTIME] = sc.nextInt()*3600 + sc.nextInt()*60 + sc.nextInt();
        }
        return runnersArr;
    }


}
