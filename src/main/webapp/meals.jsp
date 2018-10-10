<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ page import="java.util.concurrent.TimeUnit" %><%--
  Created by IntelliJ IDEA.
  User: gkuz
  Date: 10.10.2018
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Meal</title>
    <style>
        .normal {color: lawngreen;}
        .exceed {color: red;}
    </style>
</head>
<body>
<table border="1" cellpadding="6" cellspacing="0">
    <tr>
        <th>Дата</th>
        <th>Описание</th>
        <th>Калории</th>
    </tr>
    <c:forEach items="${mealList}" var="meal">
        <jsp:useBean id="meal" scope="page" type = "ru.javawebinar.topjava.model.MealWithExceed"/>
        <tr class="${meal.exceed ? 'exceed' : 'normal'}">
            <td>
                <%=TimeUtil.toString(meal.getDateTime())%>
            </td>
            <td>"${meal.description}"</td>
            <td>"${meal.calories}"</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
