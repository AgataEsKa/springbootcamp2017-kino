<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: acacko
  Date: 05.11.17
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="icon" href="<c:url value="/resources/favicon.png"/>" type="image/x-icon"/>

    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"/>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
</head>
<body>
<%--pobieramy komunikat w odpowiednim języku--%>
<spring:message code="welcome" />
<br />
<a href="<c:url value = "/accounts"/>">Lista użytkowników</a> | Lista rezerwacji | Lista pokoi | Lista filmów
</body>
</html>
