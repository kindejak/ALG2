package cz.tul.kindejak;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Polynomial {
    //data - clenske instancni promenne (instance attributes, fields)
    //5x3 + 3x2 + 6  ulozene obracene jako pole [6 0 3 5]

    //0 1 2 3 //indexy reprezentuju exponenty
    //6 0 3 5 //hodnoty reprezentuju koeficienty u techto exponentu
    private double[] coefR;

    //constructors
    //moznosti zadani
    //[6 0 3 5] pole jiz prevracenych koeficientu
    //[5 3 0 6] pole neprevracenych koeficientu
    //6, 0, 3, 5 prevracene koeficienty
    //5, 3, 0, 6 neprevracene koeficienty

    Polynomial(double[] coefR){ //[6 0 3 5]
        this.coefR = Arrays.copyOf(coefR,coefR.length);
    }

    //tovarni metoda (factory method) pouziti vararg
    public static Polynomial getInstanceReverted(double... coefR){ //6 0 3 5
        //defenzivni kopie, aby boly privatni i hodnoty pole
        double[] coefRDefensiveCopy = Arrays.copyOf(coefR, coefR.length);
        return new Polynomial(coefRDefensiveCopy);
    }

    public static Polynomial getInstance(double... coef){ //5, 3, 0, 6
        double[] coefR = new double[coef.length];
        //revert coeficients
        for (int i = 0; i < coef.length; i++) {
            coefR[i] = coef[coef.length - 1 - i];
        }
        return new Polynomial(coefR);
    }

    //metody

    //TODO
    //5x3 + 3x2 + 6 pre x = 1; y = 5 + 3 + 6 = 14
    //pouzit Hornerovo schema
    public double computeValue(double x){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //gettre
    public double getCoefAt(int exponent){
        return coefR[exponent];
    }

    public double[] getAllCoef(){ //defenzivni kopie
        return Arrays.copyOf(coefR, coefR.length);
    }

    public int getDegree(){
        return coefR.length - 1;
    }

    //TODO vypisat matematicky spravne 5x^3 + ...
    @Override
    public String toString() {
        String str = "";
        DecimalFormat format = new DecimalFormat("0.#");
        for (int i = coefR.length-1; i >= 0; i--) {
            if(i == 0){
                str += format.format(coefR[i]);
                break;
            }
            str += format.format(coefR[i]) + "x^" + i;
            str += " + ";
        }
        return str;
    }

    //5x3 + 3x2 + 6 zderivovane bude 15x2 + 6x
    public Polynomial derivate(){
        if (coefR.length == 1){
            double[] coefD = {0.0};
            return new Polynomial(coefD);
        } else {
            double[] coefD = new double[coefR.length - 1]; //koef derivacie je o jedno mensi
            for (int i = 0; i < coefD.length; i++) {
                coefD[i] = coefR[i+1]*(i + 1);
            }
            return new Polynomial(coefD);
        }
    }

    //TODO bonus
    public double integrate(double a, double b){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) {
        double[] a = {6, 0, 3, 5};
        Polynomial p1 = Polynomial.getInstanceReverted(a);
        System.out.println(p1);
        System.out.println(p1.getCoefAt(3));
        System.out.println(p1.derivate());
    }
}

