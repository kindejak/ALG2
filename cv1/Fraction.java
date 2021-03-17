public class Fraction {
    private int numerator;
    private int denominator;
    
    /**
     * 
     * @param fracString
     */

     //constructors
    public Fraction(String fracString) {
        String[] splitFracString = new String[2];
        if (fracString.contains("/")){
            splitFracString = fracString.split("/",2);
        } else if (fracString.contains(" ")){
            splitFracString = fracString.split(" ",2);
        } else {
            splitFracString[0] = fracString;
            splitFracString[1] = "1";
        }
        numerator = Integer.parseInt(splitFracString[0]);
        denominator = Integer.parseInt(splitFracString[1]);
    }

    public Fraction(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }


    //setters
    public void setNumerator(int numerator){
        this.numerator = numerator;
    }
    public void setDenominator(int denominator){
        this.denominator = denominator;
    }

    //getters
    public int getNumerator() {
        return numerator;
    }
    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        if (denominator == 0){
            return "NaN";
        }
        if (denominator == 1) {
            return numerator + "";
        }
        return numerator + "/" + denominator;
    }

    /**
     * simplifies fraction to it's smallest size
     */
    public void simplify(){
        int divisor = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator = (numerator / divisor);
        denominator =  (denominator / divisor);
    }

    
    private int gcd(int a, int b) {
        //Euclidean_algorithm - finding greatest common divisor https://en.wikipedia.org/wiki/Euclidean_algorithm
        int c;
        if (a < b) {
            int tmp;
            tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) {
          c = b;
          b = a % b;
          a = c;
        }
        return a;
      }

     /*
    public static void main(String[] args) {
        Fraction f = new Fraction(8,4);
        Fraction f1 = new Fraction("3/6");
        System.out.println(f.getFractionInString());
        System.out.println(f1.getFractionInString());
        f.simplify();
        f1.simplify();
        System.out.println(f.getFractionInString());
        System.out.println(f1.getFractionInString());
        
    }
    */
}
