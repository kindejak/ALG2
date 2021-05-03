package cmd.app.commands;

import cmd.app.Command;
import cmd.utils.Result;

import java.io.File;
import java.io.IOException;

public class Mkfile extends Command {
    private String fileName;

    @Override
    public void setParameters(String[] params)  {
        fileName = params[0];
    }

    @Override
    public Result execute(File currentDir) throws IOException {
        File file = new File(currentDir.toString() + "\\" + fileName);
        file.createNewFile();
        return new Result(currentDir,"");
    }
}
