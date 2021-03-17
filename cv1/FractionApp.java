import java.util.Scanner;

public class FractionApp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        /*
         String fraction = sc.nextLine();
        System.out.println(fraction);
        Fraction f1 = new Fraction(fraction);
        System.out.println("Numerator: " + f1.getNumerator());
        System.out.println("Denominator: " + f1.getDenominator());
        System.out.println("Fraction in String: " + f1.toString());
        f1.simplify();
        System.out.println("Simplified " + f1.toString());

        System.out.println("Enter numerator: ");
        int num1  = sc.nextInt();
        System.out.println("Enter denominator: ");
        int num2  = sc.nextInt();

        Fraction f = new Fraction(num1,num2);
        System.out.println("Numerator: " + f.getNumerator());
        System.out.println("Denominator: " + f.getDenominator());
        System.out.println("Fraction in String: " + f.toString());
        f.simplify();
        System.out.println("Simplified " + f.toString()); 
        Fraction result = FractionTools.sub(f1, f);
        System.out.println(result.toString());
        */
        
        String problem = sc.nextLine();
        Fraction result = calculateProblem(problem);
        System.out.println(result.toString());
        
        
    }

    public static Fraction calculateProblem(String mathProblem) {
        String[] splitMathProblem = mathProblem.split(" ",3);
        Fraction a = new Fraction(splitMathProblem[0]);
        String operation = splitMathProblem[1];
        Fraction b = new Fraction(splitMathProblem[2]);
        Fraction result = new Fraction(1,1);
        switch (operation) {
            case "+":
                result = FractionTools.add(a, b);
                break;
            case "-":
                result = FractionTools.sub(a, b);
                break;
            case "*":
                result = FractionTools.multiply(a, b);
                break;
            case "/":
                result = FractionTools.div(a, b);
                break;
            default:
                System.out.println("wrong input");
        }
        return result;
    }
}
