<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<table>
    <tr>
        <td>ID</td>
        <td>FirstName</td>
        <td>LastName</td>
        <td>UserName</td>
        <td>Password</td>
    </tr>
    <c:forEach items="${usersTos}" var="u">
        <tr>
            <td><c:out value="${u.id}"/></td>
            <td><c:out value="${u.firstname}"/></td>
            <td><c:out value="${u.lastname}"/></td>
            <td><c:out value="${u.username}"/></td>
            <td><c:out value="${u.password}"/></td>
        </tr>
    </c:forEach>
</table>


<a href="<c:url value="/logout.do"/>">Logout</a>
</body>
</html>
