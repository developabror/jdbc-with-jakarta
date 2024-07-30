<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>app main page</title>
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
<h1>this is main page</h1>
<br/>
<a href="/sign-up">cabinet</a>
</body>
</html>