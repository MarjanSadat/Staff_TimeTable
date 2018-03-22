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
    <link rel="stylesheet" href="<c:url value="/common/main.css"/>">
</head>
<body>
<%--<jsp:include page="/common/header.jsp"/>--%>

<a href="/user/profile.do">Profile</a><br>
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
<br>
<br>

<table border="1">
    <tr>
        <td>Id</td>
        <td>Firstname</td>
        <td>Lastname</td>
        <td>Username</td>
        <td>Password</td>
    </tr>

    <c:forEach items="${userList}" var="list">
        <%--<c:if test="${list.getUsername() ne 'admin'} ">--%>
        <tr>

            <%--/user/{id}/userTime.do--%>
            <td>
                <a href="/user/<c:out value='${list.id}'/>/userTime.do">
                    <c:out value="${list.id}"/>
                </a>
            </td>
            <td><c:out value="${list.firstname}"/></td>
            <td><c:out value="${list.lastname}"/></td>
            <td><c:out value="${list.username}"/></td>
            <td><c:out value="${list.password}"/></td>
        </tr>
        <%--</c:if>--%>
    </c:forEach>

</table>


<br>
<a href="<c:url value="/logout.do"/>">Logout</a>
</body>
</html>
