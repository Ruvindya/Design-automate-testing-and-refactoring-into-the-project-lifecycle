
import java.util.Scanner;

public class ExtractingHelperMethodsCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first operand: ");
        double operand1 = scanner.nextDouble();

        System.out.print("Enter the operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        System.out.print("Enter the second operand: ");
        double operand2 = scanner.nextDouble();

        double result = calculateResult(operand1, operator, operand2);

        if (result != Double.MIN_VALUE) {
            System.out.println("Result: " + result);
        }
    }

    private static double calculateResult(double operand1, char operator, double operand2) {
        double result = 0.0;

        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    System.out.println("Error: Cannot divide by zero!");
                    return Double.MIN_VALUE;
                }
                break;
            default:
                System.out.println("Error: Invalid operator!");
                return Double.MIN_VALUE;
        }

        return result;
    }
}
