package cmd.app.commands;

import cmd.app.Command;
import cmd.utils.Result;

import java.io.File;
import java.io.IOException;

public class Pwd extends Command {
    @Override
    public Result execute(File currentDir) throws IOException {
        return new Result(currentDir,currentDir.toString());
    }
}
