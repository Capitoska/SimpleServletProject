<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<h2>Здравствуйте, вы зашли на начальную страницу. Вы можете зарегистрироваться или авторизоваться </h2><br/>


<%--TODO ПРОБЛЕМА ВЁРСТКИ решить проблему с файлами JPS страничек. Не работает почему-то.--%>
<%--<img src="/images/kitten_cat.png" width="320" height="252">--%>
<img src="http://effects1.ru/png/kartinka/1/koty/1/kitten_cat_4-320.png">

<%--//todo ПРОБЛЕМА ВЁРСТКИ. сделать в одну строку --%>
<div class="container">
    <div class="box">

        <form method="get" action="<c:url value='/authorization'/>">
            <input type="submit" value="Авторизоваться"><br>
        </form>

        <form method="get" action="<c:url value='/registration'/>">
            <input type="submit" value="Зарегистрироваться"><br>
        </form>

    </div>
</div>

</body>
</html>