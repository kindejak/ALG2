package cmd.app.commands;

import cmd.app.Command;
import cmd.utils.Result;

import java.io.File;
import java.io.IOException;

public class Cd extends Command {
    private String dirName;

    @Override
    public void setParameters(String[] params) {
        dirName = params[0];
    }

    @Override
    public Result execute(File currentDir) throws IOException {
        switch (dirName) {
            case ".":
                break;
            case "..":
                currentDir = currentDir.getParentFile();
                break;
            default:
                File dir = new File(currentDir.toString() + "\\" + dirName);
                if (!dir.exists()){
                    throw new java.io.IOException("dir doesn't exist");
                } else {
                    currentDir = dir;
                }
        }
        return new Result(currentDir,"");
    }
}
