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
    private boolean recursion = false;

    @Override
    public void setParameters(String[] params) {
        if(params[0].equals("-e")){
            extensionString = params[1];
            return;
        }
        if(params[0].equals("-r")){
            recursion = true;
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
        if (recursion){
            return new Result(currentDir,recursive(currentDir.getAbsolutePath()));
        }
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

    private String recursive(String path){
        StringBuilder sb = new StringBuilder();
        File[] filesList = new File(path).listFiles();
        if (filesList == null) return sb.toString();

        for (File file : filesList) {
            sb.append("–").append(file.getName()).append("\n");
            if (file.isDirectory()) {
                sb.append("–").append(recursive(file.getAbsolutePath()));
            }
        }
        return sb.toString();
    }

}
