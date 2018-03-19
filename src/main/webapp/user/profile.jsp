<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marjan
  Date: 3/10/18
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form action="/user/profile.do" method="post">
    firstname: <input type="text" name="firstname" value="<c:out value="${userProfile.firstname}"/>"><br>
    lastname: <input type="text" name="lastname"  value="<c:out value="${userProfile.lastname}"/>"><br>
    username: <input type="text" name="username"  value="<c:out value="${userProfile.username}"/>"><br>
    password: <input type="text" name="password" value="<c:out value="${userProfile.password}"/>">
    <input type="submit" value="save">
</form>

</body>
</html>
