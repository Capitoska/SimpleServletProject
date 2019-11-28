<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 11/6/2019
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    Введите логин и пароль для авторизации. Пожалуйста, введите верные значения.
</head>
<body>

<form method="post" action="<c:url value='/authorization'/>">
    <h4><c:out value="${requestScope.answer}"/></h4>
    <label><input type="text" name="login"></label>Логин<br>
    <label><input type="text" name="password"></label>Пароль<br>
    <input type="submit" value="Ok" name="Ok"><br>
</form>
</body>
</html>
