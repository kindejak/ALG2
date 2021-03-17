package cz.tul.kindejak;

public class RaceTools {
    public static String timeHMSString(int timeInSeconds){
        int hours = timeInSeconds/3600;
        timeInSeconds = timeInSeconds % 3600;
        int minutes = timeInSeconds/60;
        timeInSeconds = timeInSeconds % 60;
        return String.format("%02d:%02d:%02d",hours,minutes,timeInSeconds);
    }
    public static String timeMSString(int timeInSeconds){
        int minutes = timeInSeconds/60;
        timeInSeconds = timeInSeconds % 60;
        return String.format("%02d:%02d",minutes,timeInSeconds);
    }
}
