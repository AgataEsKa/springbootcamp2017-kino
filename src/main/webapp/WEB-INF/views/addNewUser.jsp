<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: acacko
  Date: 18.11.17
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie nowego usera</title>
    <link rel="icon" href="<c:url value="/resources/favicon.png"/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"/>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
<body>
<div class="container-fluid">
    <div class="row">

        <h2>Dodaj nowego usera</h2>

        <div class="col-lg-12">

            <c:url value="/accounts/save" var="postUrl"/>
            <form:form modelAttribute="userForm" action="${postUrl}" method="post">
                <%--<form:errors path="*" element="div" />--%>
                <table class="table table-responsive table-bordered">
                    <tr>
                        <td>Email</td>
                        <td>
                            <form:input path="email"  />
                            <form:errors path="email" />
                        </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>
                            <form:input path="password"/>
                            <form:errors path="password" />
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Wyślij"/></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
