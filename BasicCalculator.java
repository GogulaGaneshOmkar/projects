import java.util.Scanner;

class Calculator {

    // Method for addition
    public double add(double a, double b) {
        return a + b;
    }

    // Method for subtraction
    public double subtract(double a, double b) {
        return a - b;
    }

    // Method for multiplication
    public double multiply(double a, double b) {
        return a * b;
    }

    // Method for division
    public double divide(double a, double b) {

        if (b == 0) {
            System.out.println("Error: Cannot divide by zero.");
            return 0;
        }

        return a / b;
    }
}

public class BasicCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("===== BASIC CALCULATOR =====");

        // User input
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        // Display operations
        System.out.println("\nSelect Operation");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        System.out.print("Enter your choice (1-4): ");
        int choice = sc.nextInt();

        double result;

        // Perform operation
        switch (choice) {

            case 1:
                result = calc.add(num1, num2);
                System.out.println("Addition Result = " + result);
                break;

            case 2:
                result = calc.subtract(num1, num2);
                System.out.println("Subtraction Result = " + result);
                break;

            case 3:
                result = calc.multiply(num1, num2);
                System.out.println("Multiplication Result = " + result);
                break;

            case 4:
                result = calc.divide(num1, num2);
                System.out.println("Division Result = " + result);
                break;

            default:
                System.out.println("Invalid Choice!");
        }

        sc.close();
    }
}