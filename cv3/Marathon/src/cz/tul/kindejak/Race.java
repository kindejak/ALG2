package cz.tul.kindejak;

public class Race {
    double length;
    int startTime;
    Runner[] runners;
    final static int TIMEUNDER  = 2*3600 + 7*60; //time under 2:07:00


    public Race(double length, int startTime, int[][] runners) {
        this.length = length;
        this.startTime = startTime;
        Runner[] runnerArr = new Runner[runners.length];
        for (int i = 0; i < runners.length; i++) {
            Runner tmp = new Runner(runners[i][0],runners[i][1]);
            runnerArr[i] = tmp;
        }
        this.runners = runnerArr;
        sortRunners();
    }

    public double getLength() {
        return length;
    }

    public int getStartTime() {
        return startTime;
    }

    public Runner[] getRunners() {
        return runners;
    }

    public int getRunnerCount() {
        return runners.length;
    }

    @Override
    public String toString() {
        String str =  runnersUnderTime(TIMEUNDER) + " runners run under " + RaceTools.timeHMSString(TIMEUNDER) + System.lineSeparator();
        if (getRunnerCount() >= 3){
            str += "Numbers of the first three runners:" + runners[0].getNumber() + " " + runners[1].getNumber() + " " + runners[2].getNumber() + System.lineSeparator();
        } else {
            str +="Numbers of the first runner" + runners[0].getNumber() + System.lineSeparator();
        }
        str += "First and last runner differance: " + RaceTools.timeHMSString(runners[0].timeDifferance(runners[runners.length-1])) + System.lineSeparator();
        str += "First runners average time per kilometer " + RaceTools.timeMSString((int) runners[0].averageTimePerKm(this)) + System.lineSeparator();
        str += String.format("First runners average speed %.2f km/h %n",runners[0].averageKmH(this));
        return str;
    }

    public void sortRunners() {
        Runner[] a = runners;
        boolean sorted = false;
        Runner temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].getTimeInSeconds() > a[i+1].getTimeInSeconds()) {
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
    public int runnersUnderTime(int time){
        time = time + startTime;
        for (int i = 0; i < runners.length; i++) {
            if (runners[i].getTimeInSeconds() >= time){
                return i;
            }
        }
        return runners.length;
    }

    public static void bubbleSort(int[] a) {

    }
}
