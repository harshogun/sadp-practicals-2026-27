package com.calculator.model;

public class CalculatorModel {

    private double num1;
    private double num2;
    private double result;

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResult() {
        return result;
    }

    public void add() {
        result = num1 + num2;
    }

    public void subtract() {
        result = num1 - num2;
    }

    public void multiply() {
        result = num1 * num2;
    }

    public void divide() {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        result = num1 / num2;
    }
}