
import java.util.Scanner;

class Calculator {
    public static double calculateResult(double operand1, char operatorSymbol, double operand2) {
        switch (operatorSymbol) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new IllegalArgumentException("Error: Cannot divide by zero!");
                }
            default:
                throw new IllegalArgumentException("Error: Invalid operator!");
        }
    }
}

public class SeparateCalculatorClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first operand: ");
        double operand1 = scanner.nextDouble();

        System.out.print("Enter the operator (+, -, *, /): ");
        char operatorSymbol = scanner.next().charAt(0);

        System.out.print("Enter the second operand: ");
        double operand2 = scanner.nextDouble();

        try {
            double result = Calculator.calculateResult(operand1, operatorSymbol, operand2);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
