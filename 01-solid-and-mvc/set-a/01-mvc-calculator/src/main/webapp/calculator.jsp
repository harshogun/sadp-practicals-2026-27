<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>MVC Calculator</title>

    <style>
        body {
            font-family: Arial;
            background: #f2f2f2;
            text-align: center;
            margin-top: 100px;
        }

        .calculator {
            background: white;
            width: 350px;
            margin: auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px gray;
        }

        input {
            width: 90%;
            padding: 10px;
            margin: 10px;
        }

        button {
            padding: 10px 20px;
            margin: 5px;
            font-size: 18px;
        }

        .result {
            margin-top: 20px;
            font-size: 22px;
        }
    </style>
</head>

<body>

<div class="calculator">

    <h2>MVC Calculator</h2>

    <form action="calculate" method="post">

        <input
            type="number"
            step="any"
            name="num1"
            placeholder="Enter first number"
            required
        >

        <input
            type="number"
            step="any"
            name="num2"
            placeholder="Enter second number"
            required
        >

        <br>

        <button type="submit" name="operation" value="add">
            +
        </button>

        <button type="submit" name="operation" value="subtract">
            -
        </button>

        <button type="submit" name="operation" value="multiply">
            *
        </button>

        <button type="submit" name="operation" value="divide">
            /
        </button>

    </form>

    <%
        Object result = request.getAttribute("result");

        if (result != null) {
    %>

        <div class="result">
            Result: <%= result %>
        </div>

    <%
        }

        Object error = request.getAttribute("error");

        if (error != null) {
    %>

        <div class="result">
            Error: <%= error %>
        </div>

    <%
        }
    %>

</div>

</body>
</html>