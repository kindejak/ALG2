package cz.tul.kindejak;
/**
 * MoneyBox
 */
public class MoneyBox {
    public String name;
    public int oneCrownsCoins;
    public int twoCrownsCoins;
    //constructors
    public MoneyBox(String name){
        this.name = name;
        this.oneCrownsCoins = 0;
        this.twoCrownsCoins = 0;
    }
    public MoneyBox(String name,int oneCrownsCoins, int twoCrownsCoins){
        this.name = name;
        this.oneCrownsCoins = oneCrownsCoins;
        this.twoCrownsCoins = twoCrownsCoins;
    }
    
    public void changeName(String newName) {
        name = newName;
    }
    public void insertOneCrown(int count) {
        oneCrownsCoins += count*1;
    }
    public void insertTwoCrown(int count) {
        twoCrownsCoins += count*1;
    }
    public void insertMultipleCoins(String crownString) {
        if (crownString.contains(" ")){
            String[] splitString = new String[2];
            splitString = crownString.split(" ",2);
            oneCrownsCoins += Integer.parseInt(splitString[0]);
            twoCrownsCoins += Integer.parseInt(splitString[1]);
        }
    }

    public int getSum() {
        return oneCrownsCoins + 2*twoCrownsCoins;
    }
    public String getInfo() {
        return name + "has in their money box " + getSum() + "CZK " + oneCrownsCoins + "x1 CZK " + twoCrownsCoins + "x2 CZK";
    }

    public boolean doesHaveEnough(int value) {
        return (getSum()-value) >= 0;
    }

    public int withdrawAll() {
        int sum = getSum();
        oneCrownsCoins = 0;
        twoCrownsCoins = 0;
        return sum;
    }

    public void transferMoneyTo(MoneyBox reciever){
        reciever.oneCrownsCoins += this.oneCrownsCoins;
        reciever.twoCrownsCoins += this.twoCrownsCoins;
        oneCrownsCoins = 0;
        twoCrownsCoins = 0;
    }
}