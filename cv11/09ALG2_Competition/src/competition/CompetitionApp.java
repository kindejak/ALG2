package competition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author JV
 */
public class CompetitionApp {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Competition comp = new Competition();
        String path = "data" + File.separator;
        try{
            while(true){
                try{
                    System.out.println("Zadej soubor registrace");
                    comp.loadRegistration(path + sc.next(),",",true);
                    System.out.println("cas startu:");
                    comp.setMassStartTime(sc.nextInt(),sc.nextInt());
                    System.out.println("Zadej soubor cile");
                    comp.loadFinish(path + sc.next(),",",true);
                    System.out.println(comp.getResults());
                    break;
                }catch(FileNotFoundException e){
                    System.out.println("Zadali jste neexistujici soubor");
                }
            }
            comp.saveResults(path + "results.txt");
        }catch (IOException e){
            //Logger.getLogger(CompetitionApp.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Nastal problem" + e.getMessage());
        }    
    }
}
