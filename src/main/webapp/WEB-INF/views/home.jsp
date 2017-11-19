<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--pobieramy komunikat w odpowiednim języku--%>
<spring:message code="welcome" />
<br />
<a href="<c:url value = "/accounts"/>">Lista użytkowników</a> | Lista rezerwacji | Lista pokoi | Lista filmów

<sec:authorize access="hasRole('ROLE_ADMIN')">
    JESTEM ADMINEM <br />
</sec:authorize>

<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
    <%--<sec:authentication property=""--%>
    JESTEM ALBO ADMINEM ALBO USEREM <br />
</sec:authorize>