package cmd.ui;

import cmd.app.App;
import cmd.utils.Result;

import java.util.Scanner;

public class CmdUI {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        App a = new App();
        while(true){
            System.out.print(a.getPath() + "> ");
	        String commandLine = sc.nextLine();
            try {
                Result r = a.command(commandLine);
                if (!r.getResultMessage().isEmpty()) {
                    System.out.println(r.getResultMessage());
                }
            }catch (IllegalAccessException e) {
                System.out.printf("cannot access this file");
            }catch (ClassNotFoundException e) {
                System.out.println("command doesn't exist");
            }catch (Exception e) {
                System.out.println("Something went wrong. " + e.getMessage());
            }
	        if(a.isExit()){
	            break;
            }
        }
    }
}
