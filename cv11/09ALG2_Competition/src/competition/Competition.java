package competition;

import io.TextFileReader;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author JV
 */
public class Competition {
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
    static DateTimeFormatter time = DateTimeFormatter.ofPattern("H:mm:ss.S");
    private List<Runner> runners;
    
    public Competition(){
        runners = new ArrayList<>();
    }

    public void setMassStartTime(int hours, int minutes){
        LocalTime startTime = LocalTime.of(hours, minutes);
        for (Runner runner : runners){
            runner.setStartTime(startTime);
        }
    }
    
    public void loadRegistration(String registrationFile,String separator,boolean header) throws FileNotFoundException, IOException {
        TextFileReader in = new TextFileReader();
        List<String[]> data = in.readFile(new File(registrationFile),separator,header);
        registrationDataToRunners(data);
    }

    private void registrationDataToRunners(List<String[]> data){
        int number;
        LocalDate born;
        String firstName, lastName, club, nationality;
        char gender;
        Runner r;
        for (String[] parts : data) {
            number = Integer.parseInt(parts[0]);
            gender = parts[2].charAt(0);
            born = LocalDate.parse(parts[3], dtf);
            club = parts[4];
            nationality = parts[5];
            String[] firstLast = parts[1].split(" ");
            firstName = firstLast[1];
            lastName = firstLast[0];
            r = new Runner(firstName, lastName, gender, born, club, nationality, number);
            runners.add(r);
        }
    }

    public void loadFinish(String finishFile,String separator,boolean header) throws FileNotFoundException, IOException {
        TextFileReader in = new TextFileReader();
        List<String[]> data = in.readFile(new File(finishFile),separator,header);
        finishDataToRunners(data);
    }

    private void finishDataToRunners(List<String[]> data) {
        LocalTime finish;
        int number;
        for (String[] parts : data){
            number = Integer.parseInt(parts[0]);
            finish = LocalTime.parse(parts[1],time);
            for (Runner runner : runners){
                if (runner.getNumber() == number){
                    runner.setFinishTime(finish);
                }
            }
        }
    }



    private String printRunners(){
        StringBuilder sb = new StringBuilder();
        for (Runner runner : runners) {
            sb.append(runner).append("\n");
        }
        return sb.toString();
    }
    
    public String getResults(){
        Collections.sort(runners);
        return printRunners();
    }
    
    public void saveResults(String resultFile) throws IOException{
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(resultFile), true)))){
            pw.println("Vysledkova listina");
            getResults();
            String s;
            for (Runner runner : runners) {
                s = String.format("%d %s %s",runner.getNumber(), runner.getFirstName(), runner.getLastName());
                pw.println(s);
            }
        }
    }

    public void saveToBinaryFile(File resultFile) throws IOException {
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(resultFile)));
            for (Runner runner : runners){
                dos.writeInt(runner.getNumber());
                dos.writeUTF(runner.getFirstName());
                int length = runner.getLastName().length();
                dos.writeInt(length);
                for (int i = 0; i < length; i++){
                    dos.writeChar(runner.getLastName().charAt(i));
                }
                dos.writeLong(runner.getRunningTime().toNanoOfDay());
            }

    }
}
