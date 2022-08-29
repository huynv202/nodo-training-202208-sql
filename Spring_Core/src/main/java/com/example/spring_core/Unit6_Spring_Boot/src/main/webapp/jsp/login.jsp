<%--
  Created by IntelliJ IDEA.
  User: huyan
  Date: 29/08/2022
  Time: 11:40 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<tiles:insertDefinition name="template" >
    <tiles:putAttribute name="body">
        <h1>Login</h1>
        <c:if test="${!empty error}">
            <div style="color:red" class="error">${error}</div>
        </c:if>
        <form action="/j_spring-security_check" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <p><input type="text" name="username" id="username" placeholder="Username" /></p>
            <p> <input type="password" name="password"  id="password" placeholder="Password"/></p>
            <p>  <input type="submit" value="Login" /></p>
        </form>
    </tiles:putAttribute>
</tiles:insertDefinition>

</body>
</html>
