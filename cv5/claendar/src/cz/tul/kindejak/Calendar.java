package cz.tul.kindejak;

public class Calendar {
    private static int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
    int day,month,year;
    int firstDayOfMonth;

    public Calendar(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public String thisMonthToString(){
        StringBuilder str = new StringBuilder();
        int startingDay = getDay(1,month,year);
        for (int i = 1; i < (6 + startingDay) % 7; i++) {
            str.append("   ");
        }
        for (int i = 1; i < daysInMonth[month-1]+1; i++) {

            if (i < 10){
                str.append("  ");
            } else {
                str.append(" ");
            }
            str.append(i);
            if ((7 - startingDay)+2 == i || (i>10 &&  i % 7 == (7 - startingDay+2)%7)){
                str.append("\n");
            }
        }
        return str.toString();
    }

    public static int getDay(int day, int month, int year) {
        // https://cs.wikipedia.org/wiki/Algoritmus_pro_v%C3%BDpo%C4%8Det_dne_v_t%C3%BDdnu
        if (month < 3) {
            month = month + 12;
        }
        int k = year % 100;
        int j = year / 100;
        return ((day + (((month + 1) * 26) / 10) +
        k + (k / 4) + (j / 4)) + (5 * j)) % 7;
    }

    @Override
    public String toString() {
        return "Calendar{}";
    }

    public static void main(String[] args) {
        Calendar cal = new Calendar(1,4,2021);
        System.out.println(cal.thisMonthToString());
    }
}
