<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${wrong==true}">
    <p class="alert-danger">HEH! No co TY! Spring Security jest nie do pokonania!</p>
</c:if>

<form action="<c:url value="/login"/>" method="post">
    <label for="username">Username</label>:
    <input type="text" id="username" name="username" autofocus="autofocus" /> <br />
    <label for="password">Password</label>:
    <input type="password" id="password" name="password" /> <br />
    <input type="submit" value="Log in" />
</form>
