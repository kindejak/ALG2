package cz.tul.kindejak;


public abstract class Client implements Comparable<Client> {
    private String name;
    private Account[] accounts = new Account[5];
    private int accountCounter = 0;

    public Client(String name) {
        this.name = name;
        accountCounter = 0;
    }

    protected String getName() {
        return name;
    }

    @Override
    public int compareTo(Client o) {
        if (this.totalDeposit() > o.totalDeposit()){
            return 1;
        } else if (this.totalDeposit() == o.totalDeposit()){
            return 0;
        } else {
            return -1;
        }
    }

    public boolean addAccount(int deposit){
        if (accountCounter < 5){
            Account a = new Account(deposit);
            accounts[accountCounter] = a;
            accountCounter++;
            return true;
        } else {
            return false;
        }
    }

    public double totalDeposit(){
        double totalDeposit = 0;
        for (int i = 0; i < accountCounter; i++) {
            totalDeposit += accounts[i].getDeposit();
        }
        return totalDeposit;
    }

    public String greet(){
        return "";
    }
}
