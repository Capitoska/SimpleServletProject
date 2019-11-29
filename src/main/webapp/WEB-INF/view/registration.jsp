<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 11/5/2019
  Time: 2:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h2>Создание нового пользователя</h2><br/>

<form method="post" action="<c:url value='/registration'/>">
    <label><input type="text" name="name"></label>Имя<br>
    <label><input type="text" name="login"></label>Логин<br>
    <label><input type="text" name="password"></label>Пароль<br>
    <label><input type="text" name="age"></label>Возраст<br>
    <label><input type="text" name="phone"></label>Номер<br>
    <input type="submit" value="Ok" name="Ok"><br>
</form>

</body>
</html>
