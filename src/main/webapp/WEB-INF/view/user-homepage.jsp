<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 11/29/2019
  Time: 2:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>Привет юзер</h4>

<form method="get" action="<c:url value='/logout'/>">
    <input type="submit" value="Выйти с аккаунта"><br>
</form>

</body>
</html>
