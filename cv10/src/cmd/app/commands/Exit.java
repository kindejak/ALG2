package cmd.app.commands;

import cmd.app.App;
import cmd.app.Command;
import cmd.utils.Result;

import java.io.File;

public class Exit extends Command {

    public Exit() {
    }

    @Override
    public Result execute(File currentDir) {
        return new Result(currentDir,"End.");
    }
}
