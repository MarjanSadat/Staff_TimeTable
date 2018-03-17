<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marjan
  Date: 2/23/18
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="<c:url value="/login.do"/>" method="post">
    <table>
        <tr>
            <td>username : </td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>password : </td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Login"></td>
        </tr>
    </table>
</form>


<a href="<c:url value="/register.do"/>" style="text-decoration: none;list-style: none;color: black;">Register</a>

</body>
</html>
