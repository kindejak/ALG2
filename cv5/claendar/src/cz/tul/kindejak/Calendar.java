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
    
    public String daysThisMonth(){
        StringBuilder str = new StringBuilder();
        int dayNum = 1;
        for (int i = 0; i < daysInMonth[month-1]; i++) {
            str.append(i+1);
            if ((i+1) < 10){
                str.append("  ");
            } else {
                str.append(" ");
            }
            if ((i+1) % 7 == 0){
                str.append("\n");
            }
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return "Calendar{}";
    }

    public static void main(String[] args) {
        Calendar cal = new Calendar(24,3,2021);
        System.out.println(cal.daysThisMonth());
    }
}
