import java.util.Scanner;

public class CalculatorEnum {
    enum Operator {
        ADDITION('+'),
        SUBTRACTION('-'),
        MULTIPLICATION('*'),
        DIVISION('/');

        private char symbol;

        Operator(char symbol) {
            this.symbol = symbol;
        }

        public char getSymbol() {
            return symbol;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first operand: ");
        double operand1 = scanner.nextDouble();

        System.out.print("Enter the operator (+, -, *, /): ");
        char operatorSymbol = scanner.next().charAt(0);
        Operator operator = getOperator(operatorSymbol);

        if (operator == null) {
            System.out.println("Error: Invalid operator!");
            return;
        }

        System.out.print("Enter the second operand: ");
        double operand2 = scanner.nextDouble();

        double result = calculateResult(operand1, operator, operand2);

        if (result != Double.MIN_VALUE) {
            System.out.println("Result: " + result);
        }
    }

    private static Operator getOperator(char operatorSymbol) {
        for (Operator op : Operator.values()) {
            if (op.getSymbol() == operatorSymbol) {
                return op;
            }
        }
        return null;
    }

    private static double calculateResult(double operand1, Operator operator, double operand2) {
        double result = 0.0;

        switch (operator) {
            case ADDITION:
                result = operand1 + operand2;
                break;
            case SUBTRACTION:
                result = operand1 - operand2;
                break;
            case MULTIPLICATION:
                result = operand1 * operand2;
                break;
            case DIVISION:
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    System.out.println("Error: Cannot divide by zero!");
                    return Double.MIN_VALUE;
                }
                break;
        }

        return result;
    }
}
