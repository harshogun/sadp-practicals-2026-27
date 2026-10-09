package com.calculator.controller;

import java.io.IOException;

import com.calculator.model.CalculatorModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculatorController extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            double num1 = Double.parseDouble(
                    request.getParameter("num1")
            );

            double num2 = Double.parseDouble(
                    request.getParameter("num2")
            );

            String operation = request.getParameter("operation");

            CalculatorModel model = new CalculatorModel();

            model.setNum1(num1);
            model.setNum2(num2);

            switch (operation) {

                case "add":
                    model.add();
                    break;

                case "subtract":
                    model.subtract();
                    break;

                case "multiply":
                    model.multiply();
                    break;

                case "divide":
                    model.divide();
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Invalid operation"
                    );
            }

            request.setAttribute(
                    "result",
                    model.getResult()
            );

        } catch (ArithmeticException e) {

            request.setAttribute(
                    "error",
                    e.getMessage()
            );

        } catch (Exception e) {

            request.setAttribute(
                    "error",
                    "Invalid input"
            );
        }

        request.getRequestDispatcher(
                "calculator.jsp"
        ).forward(request, response);
    }
}