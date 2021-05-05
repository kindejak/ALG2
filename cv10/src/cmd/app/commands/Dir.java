package cmd.app.commands;

import cmd.app.Command;
import cmd.utils.Result;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class Dir extends Command {
    private String dirName;
    private boolean parameterZeroExist = false;
    private String extensionString = "";

    @Override
    public void setParameters(String[] params) {
        if(params[0].equals("-e")){
            extensionString = params[1];
            return;
        }
        parameterZeroExist = true;
        if(params[0].startsWith("./")){
            dirName = params[0].substring(2);
        } else {
            dirName = params[0];
        }
    }

    @Override
    public Result execute(File currentDir) {
        if(parameterZeroExist){
            File dir = new File(dirName);
            if (!dir.isAbsolute()){
                dir = new File(currentDir.toString() + "\\" + dirName);
            }
            currentDir  = new File(dirName);
        }

        File[] fileList = currentDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(extensionString);
            }
        });


        StringBuffer text = new StringBuffer();
        for(File file : fileList){
            if (file.isDirectory()){
                text.append("📁 ");
            }
            text.append(file.getName() + "\n");
        }
        return new Result(currentDir,text.toString());
    }

}
