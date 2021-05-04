package cmd.app.commands;

import cmd.app.Command;
import cmd.utils.Result;

import java.io.File;
import java.io.IOException;

public class Cd extends Command {
    private String dirName;
    private boolean parameterExist = false;

    @Override
    public void setParameters(String[] params) {
        parameterExist = true;
        if(params[0].startsWith("./")){
            dirName = params[0].substring(2);
        } else {
            dirName = params[0];
        }
    }

    @Override
    public Result execute(File currentDir) throws IOException {
        if (!parameterExist){
            currentDir =  new File(System.getProperty("user.dir"));
            return new Result(currentDir,"");
        }
        File dir = new File(dirName);
        if (!dir.isAbsolute()){
            dir = new File(currentDir.toString() + "\\" + dirName);
        }
        switch (dirName) {
            case ".":
                break;
            case "..":
                if (!dir.exists()){
                    throw new java.io.IOException("dir doesn't exist");
                } else {
                    currentDir = currentDir.getParentFile();
                }
                break;
            default:
                if (!dir.exists()){
                    throw new java.io.IOException("dir doesn't exist");
                } else {
                    currentDir = dir;
                }
        }
        return new Result(currentDir,"");
    }
}
