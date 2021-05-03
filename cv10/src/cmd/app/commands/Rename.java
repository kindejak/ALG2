package cmd.app.commands;

import cmd.app.Command;
import cmd.utils.Result;

import java.io.File;
import java.io.IOException;

public class Rename extends Command {
    private String oldFileName;
    private String newFileName;

    @Override
    public void setParameters(String[] params)  {
        oldFileName = params[0];
        newFileName = params[1];
    }

    @Override
    public Result execute(File currentDir) throws IOException {
        File oldFile = new File(currentDir.toString() + "\\" + oldFileName);
        File newFile = new File(currentDir.toString() + "\\" + newFileName);
        if (newFile.exists())
            throw new java.io.IOException("file exists");
        if (!oldFile.renameTo(newFile)) {
            throw new java.io.IOException("renaming file was not successful");
        }
        return new Result(currentDir, "");
    }
}
