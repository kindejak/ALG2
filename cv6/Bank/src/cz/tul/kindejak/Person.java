package cz.tul.kindejak;

public class Person extends Client {
    public Person(String name) {
        super(name);
    }

    @Override
    public String greet(){
        String name = super.getName();
        if (name.lastIndexOf("ova") == name.length()-3){
            return "Paní " + name;
        } else return "Pan " + name;
    }


}
