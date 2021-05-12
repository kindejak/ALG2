package competition;

import javax.naming.OperationNotSupportedException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.util.Comparator;

/**
 *
 * @author JV
 */
public class Runner implements Comparable<Runner>{
    private String firstName;
    private String lastName;
    private char gender;
    private LocalDate born;
    private String club;
    private String nationality;
    
    private int number;
    private LocalTime startTime;
    private LocalTime finishTime;

    public static final Comparator<Runner> COMP_DOB = (Runner r1, Runner r2) -> r1.born.compareTo(r2.born);

    public Runner(String firstName, String lastName, char gender, LocalDate born, String club, String nationality, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.born = born;
        this.club = club;
        this.nationality = nationality;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBorn() {
        return born;
    }

    public String getClub() {
        return club;
    }

    public String getNationality() {
        return nationality;
    }

    public int getNumber() {
        return number;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(LocalTime finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public String toString() {
        String s = String.format("%10s %10s %s %s %20s %3s %d", firstName, lastName, gender,born.format(DateTimeFormatter.ISO_LOCAL_DATE), club, nationality, number);
        if (startTime != null){
            s = s + String.format(" %10s ", startTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
            if (finishTime != null){
                 LocalTime runningTime = LocalTime.ofNanoOfDay(Duration.between(startTime,finishTime).toNanos());
                s = s + String.format(" %-15s %-15s", finishTime.format(DateTimeFormatter.ISO_LOCAL_TIME), runningTime);

            }
        }
        return s;
    }

    @Override
    public int compareTo(Runner o) {
        return this.number - o.number;
    }


    public static void main(String[] args) {
        Runner r = new Runner("Alice","Mala",'F',LocalDate.parse("3/21/2000", Competition.dtf),"SK Liberec","CZE",2);
        System.out.println(r);
        r.setStartTime(LocalTime.of(1,20,0));
        r.setFinishTime(LocalTime.of(2,15,0));
        System.out.println(r.toString());
    }
    
    
}
