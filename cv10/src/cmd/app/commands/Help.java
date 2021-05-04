package cmd.app.commands;

import cmd.app.Command;
import cmd.utils.Result;

import java.io.File;

public class Help extends Command {
    @Override
    public Result execute(File currentDir) {
        StringBuffer helpText = new StringBuffer();
        helpText.append("- help – vrátí víceřádkový textový řetězec s „nápovědou“\n" +
                "- dir – vrátí víceřádkový textový řetězec s formátovaným výpisem aktuálního adresáře\n" +
                "- dir <adresář> – vrátí víceřádkový textový řetězec s formátovaným výpisem adresáře předaného v parametru, nemění aktuální adresář\n" +
                "- cd <adresář> – změna aktuálního adresáře dle para\n" +
                "- mkfile <soubor> – vytvoří nový soubor, jehož jméno bylo zadáno v parametru\n" +
                "- mkdir <adresář> - vytvoří zadaný adresář\n" +
                "- mkdirs <cesta> – vytvoří adresáře odpovídající cestě zadané v parametru\n" +
                "- rename <jm1> <jm2> – přejmenuje soubor nebo adresář\n" +
                "- pwd - vypíše adresář ve kterem se aktuáln+ nacházíte");
        return new Result(currentDir,helpText.toString());
    }
}
