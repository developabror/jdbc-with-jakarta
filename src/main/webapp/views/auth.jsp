<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/30/24
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sign up page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        form {
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }

        div {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #218838;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ccc;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
<c:set var="action_path" value="/sign-in"></c:set>
<c:set var="button_val" value="sign in"></c:set>
<c:set var="uri_to" value="/sign-up"></c:set>

<c:if test="${sign}">
    <c:set var="action_path" value="/sign-up"></c:set>
    <c:set var="button_val" value="sign up"></c:set>
    <c:set var="uri_to" value="/sign-in"></c:set>
</c:if>


<form action="${action_path}" method="post">
    <div>
        <c:if test="${sign}">
            <div>
                <input name="name" type="text" id="name" placeholder="enter name">
            </div>
        </c:if>
        <div>
            <input name="email" type="email" id="email" placeholder="enter email">
        </div>
        <div>
            <input name="password" type="password" id="password" placeholder="enter password">
        </div>
        <div class="block">
            <button type="submit"><c:out value="${button_val}"/></button>
            <a href="${uri_to}" > <c:out value="${uri_to}"></c:out></a>
        </div>
    </div>
</form>

</body>
</html>
