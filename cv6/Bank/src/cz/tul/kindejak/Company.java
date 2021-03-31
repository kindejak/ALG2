package cz.tul.kindejak;

public class Company extends Client {

    public Company(String name) {
        super(name);
    }
    @Override
    public String greet(){
        return "Firma " + super.getName();
    }
}
