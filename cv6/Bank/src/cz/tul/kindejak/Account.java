package cz.tul.kindejak;

public class Account {
    private double deposit;

    public Account() {
        this.deposit = 0;
    }

    public Account(double deposit) {
        this.deposit = deposit;
    }

    public double getDeposit() {
        return deposit;
    }

    public void depositMoney(int value){
        deposit += value;
    }
    public boolean withdraw(int value){
        if (deposit-value < 0){
            return false;
        } else {
            deposit += value;
            return true;
        }
    }

    @Override
    public String toString() {
        return "Account deposit=" + deposit;
    }
}
