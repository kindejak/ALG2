package cz.tul.kindejak;

public class Calendar {
    private int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
    private int day,month,year;
    public static final String BG_WHITE = "\u001B[47m";
    public static final String RESET_COLOR = "\u001B[0m";

    public Calendar(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public String thisMonthToString(){
        StringBuilder str = new StringBuilder();
        int placedChars = 0;
        int startingDay = getDay(1,month,year) - 1;
        if (startingDay == -1){
            startingDay = 6;
        }
        str.append(" mo tu we th fr sa su\n");
        for (int i = 1; i < startingDay; i++) {
            str.append("   ");
            placedChars++;
        }
        for (int i = 1; i < daysInMonth[month-1]+1; i++) {

            if (i < 10){
                str.append("  ");
            } else {
                str.append(" ");
            }
            if (i == day){
                str.append(BG_WHITE + i + RESET_COLOR);
            } else {
                str.append(i);
            }
            placedChars++;
            if (placedChars % 7 == 0){
                str.append("\n");
            }
        }
        return str.toString();
    }

    public String nextMonth(){
        day = 1;
        if (month >= 12){
            month = 1;
            year++;
        } else {
            month++;
        }
        return thisMonthToString();
    }

    public String previousMonth(){
        day = 1;
        if (month <= 1){
            month = 12;
            year--;
        } else {
            month--;
        }
        return thisMonthToString();
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
        Calendar cal = new Calendar(1,5,2021);
        for (int i = 0; i < 7; i++) {
            System.out.println(getDay(i,5,2021));
        }
        System.out.println(cal.thisMonthToString());
        System.out.println(cal.nextMonth());
    }
}
