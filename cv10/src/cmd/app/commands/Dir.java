package cmd.app.commands;

import cmd.app.Command;
import cmd.utils.Result;

import java.io.File;

public class Dir extends Command {
    File dirAdress;
    boolean parameterExist = false;

    @Override
    public void setParameters(String[] params) {
        dirAdress = new File(params[0]);
        parameterExist = true;
    }

    @Override
    public Result execute(File currentDir) {
        if(!parameterExist){
            dirAdress = currentDir;
        }
        File[] fileList = dirAdress.listFiles();

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
