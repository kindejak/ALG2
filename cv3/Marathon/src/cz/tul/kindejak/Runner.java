package cz.tul.kindejak;

public class Runner {
    private final int number;
    private final int timeInSeconds;

    public Runner(int number, int timeInSeconds) {
        this.number = number;
        this.timeInSeconds = timeInSeconds;
    }

    public int getNumber() {
        return number;
    }

    public int getTimeInSeconds() {
        return timeInSeconds;
    }


    public int timeDifferance(Runner diffRunner){
        return Math.abs(diffRunner.timeInSeconds - timeInSeconds);
    }

    public double averageKmH(Race race){
        float time = (float) (timeInSeconds-race.getStartTime())/3600;
        return  race.getLength()/time;
    }

    public double averageTimePerKm(Race race){
        return (timeInSeconds-race.getStartTime())/ race.getLength();
    }
}
