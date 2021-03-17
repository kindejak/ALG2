public class FractionTools {
    
    public static Fraction add(Fraction a, Fraction b) {
        Fraction c = new Fraction(0,0);
        c.setNumerator(a.getNumerator()*b.getDenominator() + a.getDenominator()*b.getNumerator());  
        c.setDenominator(a.getDenominator()*b.getDenominator());
        c.simplify();
        return c;
    }

    public static Fraction sub(Fraction a, Fraction b) {
        Fraction c = new Fraction(0,0);
        c.setNumerator(a.getNumerator()*b.getDenominator() - a.getDenominator()*b.getNumerator());  
        c.setDenominator(a.getDenominator()*b.getDenominator());
        c.simplify();
        return c;
    }

    public static Fraction multiply(Fraction a, Fraction b) {
        Fraction c = new Fraction(0,0);
        c.setNumerator(a.getNumerator()*b.getNumerator());  
        c.setDenominator(a.getDenominator()*b.getDenominator());
        c.simplify();
        return c;
    }

    public static Fraction div(Fraction a, Fraction b) {
        Fraction c = new Fraction(0,0);
        c.setNumerator(a.getNumerator()*b.getDenominator());  
        c.setDenominator(a.getDenominator()*b.getNumerator());
        c.simplify();
        return c;
    }
}