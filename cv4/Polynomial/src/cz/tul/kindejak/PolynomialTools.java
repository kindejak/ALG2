package cz.tul.kindejak;

public final class PolynomialTools {

    private PolynomialTools(){ //aby nebylo mozne vytvorit objekt, neni jej potreba

    }

    //6 0 3 5      5x3 + 3x2      + 6
    //1 3 6              6x2 + 3x + 1
    //7 3 9 5      5x3 + 9x2 + 3x + 7

    public static Polynomial sum(Polynomial a, Polynomial b) {
        double[] array;
        if (a.getDegree() >= b.getDegree()) {
            array = a.getAllCoef();
            for (int i = 0; i < b.getAllCoef().length; i++) {
                array[i] += b.getCoefAt(i);
            }
        } else {
            array = b.getAllCoef();
            for (int i = 0; i < a.getAllCoef().length; i++) {
                array[i] += a.getCoefAt(i);
            }
        }
        return new Polynomial(array);
    }
    //TODO
    public static Polynomial multiply(Polynomial a, Polynomial b){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO bonus
    public static Polynomial sumAll(Polynomial... polynoms){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //TODO bonus
    public static Polynomial multiplyAll(Polynomial... polynoms){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) {
        Polynomial p1 = Polynomial.getInstance(5, 3, 0, 6);
        Polynomial p2 = Polynomial.getInstance(6, 3, 1);
        System.out.println(PolynomialTools.sum(p1, p2));
    }
}
