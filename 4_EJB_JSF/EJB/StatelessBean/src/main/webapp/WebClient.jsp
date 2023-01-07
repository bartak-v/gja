
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- Adapted from http://www.roseindia.net/ejb/examples-of-StatelessBean.shtml --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="javax.naming.*"%>
<%@ page import="net.roseindia.ejb3.stateless.example.CalculatorRemote"%>
<html>
    <head>
        <title>Calculator</title>
    </head>
    <body>
        <%!   private CalculatorRemote calculator = null;
            float result = 0;

            public void jspInit() {
                try {
                    

                    InitialContext ic = new InitialContext();
// the calculator bean is retrieved from context
                    calculator = (CalculatorRemote) ic.lookup(CalculatorRemote.class.getName());
                    System.out.println("Loaded Calculator Bean");

                } catch (Exception ex) {
                    System.out.println("Error:" + ex.getMessage());
                }
            }

            public void jspDestroy() {
                calculator = null;
            }
        %>


        <%

            try {
                String s1 = request.getParameter("num1");
                String s2 = request.getParameter("num2");
                String operation = request.getParameter("operation");

                System.out.println(operation);
                boolean error = false;

                if (s1 == null || s1.equals("") || s2 == null || s2.equals("") || operation == null) {
        %>
        <p>
            <b>Operation was not selected!</b>
        <p>
            <%
            } else {

                Float num1 = Float.parseFloat(s1);
                Float num2 = Float.parseFloat(s2);

                switch (operation) {
                    case "add":
                        result = calculator.add(num1.floatValue(), num2.floatValue());
                        break;

                    case "sub":
                        result = calculator.subtract(num1.floatValue(), num2.floatValue());
                        break;

                    case "div":
                        result = calculator.division(num1.floatValue(), num2.floatValue());
                        break;

                    case "mul":
                        result = calculator.multiply(num1.floatValue(), num2.floatValue());
                        break;
                    default:
                        error = true;
                }

                if (error) {
            %>

        <p>
            <b>Form was not filled in properly.</b>
        <p>
            <%
            } else {
            %>
        <p>
            <b>The result is:</b> <%= result%>
        <p>
            <%
                        }
                    }
                } // end of try
                catch (Exception e) {
                    e.printStackTrace();
                    //result = "Not valid";
                }
            %>
    </body>
</html>