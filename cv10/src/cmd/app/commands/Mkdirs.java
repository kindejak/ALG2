package cmd.app.commands;

import cmd.app.Command;
import cmd.utils.Result;

import java.io.File;
import java.io.IOException;

public class Mkdirs extends Command {
    String dirName;

    @Override
    public void setParameters(String[] params)  {
        dirName = params[0];
    }

    @Override
    public Result execute(File currentDir) throws IOException {
        File dir = new File(currentDir.toString() + "\\" + dirName);
        dir.mkdirs();
        return new Result(currentDir,"");
    }
}
