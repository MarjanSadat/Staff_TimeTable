<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marjan
  Date: 2/23/18
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<form action="<c:url value="/register.do"/>" method="post">
    <table>
        <tr>
            <td>Firstname : </td>
            <td><input type="text" name="firstname"></td>
        </tr>
        <tr>
            <td>Lastname : </td>
            <td><input type="text" name="lastname"></td>
        </tr>
        <tr>
            <td>Username: </td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password : </td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Register"></td>
        </tr>
    </table>
</form>
</body>
</html>
