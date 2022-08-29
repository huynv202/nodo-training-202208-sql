<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Spring Boot</title>
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="center">
    <tr>
        <td height="30">Welcome to Java Spring Clazz</td>
        <td>
            <tiles:insertAttribute name="body" />
        </td>
    </tr>
    <tr>
        <td>
          <a href="/user/home">Trang chu</a>
            <sec:authorize access="!hasAnyRole('ROLE_USER')">
            <a href="/login">Đăng nhập</a>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_USER')">
                    <a href="/user/home">USer</a>
                    <a href="javascript:document.getElementById('logout').submit()">Đăng xuất</a>
                </sec:authorize>
            <p>
            <form action="/j_spring_security_logout"id="logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}">
        </form>
            </p>
        </td>
</table>
</body>
</html>
