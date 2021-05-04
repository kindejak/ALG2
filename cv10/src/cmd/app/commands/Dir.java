package cmd.app.commands;

import cmd.app.Command;
import cmd.utils.Result;

import java.io.File;

public class Dir extends Command {
    private String dirName;
    private boolean parameterExist = false;

    @Override
    public void setParameters(String[] params) {
        parameterExist = true;
        if(params[0].startsWith("./")){
            dirName = params[0].substring(2);
        } else {
            dirName = params[0];
        }
    }

    @Override
    public Result execute(File currentDir) {
        File[] fileList;
        if(parameterExist){
            File dir = new File(dirName);
            if (!dir.isAbsolute()){
                dir = new File(currentDir.toString() + "\\" + dirName);
            }
            fileList  = new File(dirName).listFiles();
        } else {
            fileList = currentDir.listFiles();
        }


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
