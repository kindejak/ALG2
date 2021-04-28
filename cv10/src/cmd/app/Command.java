package cmd.app;

import cmd.utils.Executable;
import cmd.utils.Result;

import java.io.File;
import java.io.IOException;

public abstract class Command implements Executable {
    @Override
    public void setParameters(String[] params) {

    }

    @Override
    public Result execute(File currentDir) throws IOException {
        return null;
    }
}
