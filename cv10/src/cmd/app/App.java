package cmd.app;

import cmd.utils.Executable;
import cmd.utils.Result;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class App {
    private boolean exit;
    private File path;

    public App() {
        this.path =  new File(System.getProperty("user.dir"));
        this.exit = false;
    }

    public boolean isExit() {
        return exit;
    }

    public void setPath(File path) {
        this.path = path;
    }

    public File getPath() {
        return new File(path.getAbsolutePath());
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }


    public Result command(String commandLine) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        String[] commandLineSplit = commandLine.split(" ");

        String commandString = commandLineSplit[0];
        commandString = commandString.substring(0, 1).toUpperCase() + commandString.substring(1);

        String[] params = new String[commandLineSplit.length-1];
        for (int i = 1; i < commandLineSplit.length; i++) {
            params[i-1] = commandLineSplit[i];
        }
        if (commandString.equalsIgnoreCase("exit")){
            exit = true;
        }

        Command command = (Command) Class.forName(Executable.COMMANDPACKAGE + "." + commandString).newInstance();
        if(commandLineSplit.length > 1){
            command.setParameters(params);
        }
        Result r = command.execute(path);
        setPath((r.getCurrentDir().getAbsoluteFile()));
        //System.setProperty( "user.dir", r.getCurrentDir().getAbsoluteFile().toString());
        return r;
    }
}
