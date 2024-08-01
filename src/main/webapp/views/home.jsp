<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/30/24
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<c:choose>
    <c:when test="${exists}">
        welcome to home page dear <c:out value="${user.getName()}" />
    </c:when>
    <c:otherwise>
        <h2><c:out value="${message}" /></h2>
<a href="/sign-in">sign in</a>
    </c:otherwise>
</c:choose>
</body>
</html>
