package com.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class ArithmeticExpressionSolver {

    public static void main(String[] args) {
        String inputFile = "C:\\Users\\kulde\\eclipse-workspace\\ArithmeticExpressionSolver\\src\\input"; // Replace with your input file name
        String outputFile = "C:\\Users\\kulde\\eclipse-workspace\\ArithmeticExpressionSolver\\src\\input"; // Replace with your output file name

        try {
            solveArithmeticExpressions(inputFile, outputFile);
            System.out.println("Expressions solved successfully. Check the output file.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void solveArithmeticExpressions(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String result = evaluateExpression(line.trim());
                writer.write(line + " = " + result);
                writer.newLine();
            }
        }
    }

    private static String evaluateExpression(String expression) {
        try {
            return String.valueOf(parseAndEvaluate(expression));
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    private static double parseAndEvaluate(String expression) {
        Stack<Double> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                operands.push((double) (c - '0'));
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
                    performOperation(operands, operators);
                }
                operators.push(c);
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '(') {
                    performOperation(operands, operators);
                }
                operators.pop(); // Pop the '('
            }
        }

        while (!operators.isEmpty()) {
            performOperation(operands, operators);
        }

        return operands.pop();
    }

    private static void performOperation(Stack<Double> operands, Stack<Character> operators) {
        char operator = operators.pop();
        double operand2 = operands.pop();
        double operand1 = operands.pop();

        switch (operator) {
            case '+':
                operands.push(operand1 + operand2);
                break;
            case '-':
                operands.push(operand1 - operand2);
                break;
            case '*':
                operands.push(operand1 * operand2);
                break;
            case '/':
                operands.push(operand1 / operand2);
                break;
            case '^':
                operands.push(Math.pow(operand1, operand2));
                break;
        }
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
}
