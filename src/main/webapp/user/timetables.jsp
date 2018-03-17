<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marjan
  Date: 3/10/18
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
admin time tables
<br>


<table border="1">
    <tr>
        <td>id</td>
        <td>in</td>
        <td>out</td>
    </tr>
    <c:forEach items="${userTimetables}" var="time">
        <tr>
            <td><c:out value="${time.id}"/></td>
            <td><c:out value="${time.entry}"/></td>
            <td><c:out value="${time.exit}"/></td>
        </tr>
    </c:forEach>
</table>


<br>
<a href="<c:url value="/logout.do"/>">Logout</a>
</body>
</html>
