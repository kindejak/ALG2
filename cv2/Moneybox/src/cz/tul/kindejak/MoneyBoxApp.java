package cz.tul.kindejak;

public class MoneyBoxApp {
    public static void main(String[] args) {
        MoneyBox m1 = new MoneyBox("Alice",10,10);
        MoneyBox m2 = new MoneyBox("Bob");
        m2.insertOneCrown(2);
        m2.insertTwoCrown(3);
        m2.insertMultipleCoins("3 10");
        System.out.println(m1.getSum());
        System.out.println(m2.getSum());
        int hamburgerPrice = 39;
        System.out.println("Alice does " + (m1.doesHaveEnough(hamburgerPrice) ? "":"not") + " have enough money");
        System.out.println("Bob does " + (m2.doesHaveEnough(hamburgerPrice) ? "":"not") + " have enough money");
        m2.transferMoneyTo(m1);
        System.out.println(m1.getSum());
        System.out.println(m2.getSum());
    }
}
