package cz.tul.kindejak;

public class Bus {
    private int capacity = 40;
    private int peopleInside = 0;
    private int lineNumber = 0;
    private String companyName = "";

    //constructors
    public Bus() {
    }

    public Bus(int capacity, int lineNumber, String companyName) {
        this.capacity = capacity;
        this.lineNumber = lineNumber;
        this.companyName = companyName;
    }
    //getters
    public int getCapacity() {
        return capacity;
    }

    public int getPeopleInside() {
        return peopleInside;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getCompanyName() {
        return companyName;
    }
    //setters
    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Bus number " + lineNumber +
                " arrived at station, bus is provided by company " + companyName +
                ", " + peopleInside +
                " out of " + capacity +
                " seats are full."
                ;
    }

    public void getOff(int peopleGettingOff){
        peopleInside -= peopleGettingOff;
    }

    public void getOn(int peopleGettingOn){
        peopleInside += peopleGettingOn;
    }

    public void everyoneGetsOff(){
        peopleInside = 0;
    }

}
