package cmd.utils;

import java.io.File;

public class Result {
    private File currentDir;
    private String resultMessage;

    public File getCurrentDir() {
        return currentDir;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public Result(File currentDir, String resultMessage) {
        this.currentDir = currentDir;
        this.resultMessage = resultMessage;
    }
}
