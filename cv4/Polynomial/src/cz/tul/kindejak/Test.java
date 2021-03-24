package cz.tul.kindejak;

public final class Test {

    public static void main(String[] args) {
        double[] a = {6, 1, 3, 5};
        Polynomial p1 = Polynomial.getInstanceReverted(a);
        System.out.println(p1.toString());
        double[] n = {5, 2, 2};
        Polynomial p2 = Polynomial.getInstance(n);
        Polynomial p3 = p2.derivate();
        System.out.println(p3.toString());
        Polynomial p4 = PolynomialTools.sum(p1,p2);
        System.out.println(p4.toString());
    }
}
