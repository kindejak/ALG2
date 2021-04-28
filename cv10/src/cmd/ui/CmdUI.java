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
                System.out.println(r.getResultMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong. " + e.getMessage());
            }
	        if(a.isExit()){
	            break;
            }
        }
    }
}
