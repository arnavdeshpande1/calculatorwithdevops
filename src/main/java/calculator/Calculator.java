package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {

    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public Calculator() {
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double number1, number2;
        do {
            System.out.println("Enter 1 to find Square root of a number");
            System.out.println("Enter 2 to find Factorial of a number");
            System.out.println("Enter 3 to find Power of a number");
            System.out.println("Enter 4 to find natural logarithm of a number");
            System.out.println("Enter 5 to exit");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }

            switch (choice) {
                case 1:
                    // do factorial
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Factorial of "+number1+" is : " + calculator.factorial(number1));
                    System.out.println("\n");

                    break;
                case 2:
                    // find square root
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Square root of "+number1+" is : " + calculator.squreroot(number1));
                    System.out.println("\n");


                    break;
                case 3:
                    // find power
                    System.out.print("Enter the first number : ");
                    number1 = scanner.nextDouble();
                    System.out.print("Enter the second number : ");
                    number2 = scanner.nextDouble();
                    System.out.println(number1+ " raised to power "+number2+" is : " + calculator.powerfunction(number1, number2));
                    System.out.println("\n");
                    break;
                case 4:
                    // find natural log
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Natural log of "+number1+" is : " + calculator.naturalLogarithm(number1));
                    System.out.println("\n");

                    break;
                default:
                    System.out.println("Exiting....");
                    return;
            }
        } while (true);
    }


    public double factorial(double number1) {
        logger.info("[fact] - " + number1);
        double result = fact(number1);
        logger.info("[result - fact] - " + result);
        return result;
    }



    public double squreroot(double number1) {
        logger.info("[squre root] - " + number1);
        double result = Math.sqrt(number1);
        logger.info("[result - squre root] - " + result);
        return result;
    }


    public double powerfunction(double number1, double number2) {
        logger.info("[power - " + number1 + " raised to] " + number2);
        double result = Math.pow(number1,number2);
        logger.info("[result - power] - " + result);
        return result;
    }

    public double naturalLogarithm(double number1) {
        logger.info("[natural logarithm] - " + number1);
        double result = 0;
        try {

            if (number1 <0 ) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            }
            else {
                result = Math.log(number1);
            }
        } catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - LOG] - Finding log of negative numbers is invalid" + error.getLocalizedMessage());
        }
        logger.info("[result - natural logarithm] - " + result);
        return result;
    }
    public double fact(double num) {
        double facto = 1;
        for(int i = 1; i <= num; ++i)
        { facto *= i;   }
        return  facto;
    }
}
