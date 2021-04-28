package cmd.utils;

import java.io.File;
import java.io.IOException;

public interface Executable {
    String COMMANDPACKAGE = "cmd.app.commands";

    void setParameters(String[] params) throws IOException;

    Result execute(File currentDir) throws IOException;

}
