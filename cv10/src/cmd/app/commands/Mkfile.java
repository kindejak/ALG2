package cmd.app.commands;

import cmd.app.Command;
import cmd.utils.Result;

import java.io.File;
import java.io.IOException;

public class Mkfile extends Command {
    File file;

    @Override
    public void setParameters(String[] params)  {
        file = new File(params[0]);
    }

    @Override
    public Result execute(File currentDir) throws IOException {
        file.createNewFile();
        return new Result(currentDir,"");
    }
}
