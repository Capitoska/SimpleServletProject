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
    Тестовый пробник на вставку данных в БД.
</head>
<body>
<form method="post" action="<c:url value='/InsertData'/>">
    <label><input type="text" name="name"></label>Имя<br>
    <label><input type="text" name="login"></label>Логин<br>
    <label><input type="text" name="password"></label>Пароль<br>
    <label><input type="text" name="phone"></label>Телефон<br>
    <input type="submit" value="Ok" name="Ok"><br>
</form>
</body>
</html>
