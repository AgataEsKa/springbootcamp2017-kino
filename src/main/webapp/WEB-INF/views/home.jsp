<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--pobieramy komunikat w odpowiednim języku--%>
<spring:message code="welcome" />
<br />
<a href="<c:url value = "/accounts"/>">Lista użytkowników</a> | Lista rezerwacji | Lista pokoi | Lista filmów

