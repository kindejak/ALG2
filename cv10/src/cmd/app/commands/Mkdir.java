package cmd.app.commands;

import cmd.app.Command;
import cmd.utils.Result;

import java.io.File;
import java.io.IOException;

public class Mkdir extends Command {
    File dir;

    @Override
    public void setParameters(String[] params)  {
        dir = new File(params[0]);
    }

    @Override
    public Result execute(File currentDir) throws IOException {
        dir.mkdir();
        return new Result(currentDir,"");
    }
}
