package cmd.app.commands;

import cmd.app.Command;
import cmd.utils.Result;

import java.io.File;

public class Cd extends Command {
    private File dirAdress;

    @Override
    public void setParameters(String[] params) {
        dirAdress = new File(params[0]);
        dirAdress = dirAdress.getAbsoluteFile();
    }

    @Override
    public Result execute(File currentDir) {
        if (dirAdress.exists() && dirAdress.isDirectory()){
            currentDir = dirAdress;
            currentDir = currentDir.getAbsoluteFile();
        }
        return new Result(currentDir,"");
    }
}
