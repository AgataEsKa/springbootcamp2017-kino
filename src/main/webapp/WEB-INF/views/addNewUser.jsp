<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<h2><spring:message code="user.add"/></h2>

<div class="col-lg-12">

    <c:url value="/accounts/save" var="postUrl"/>
    <form:form modelAttribute="userForm" action="${postUrl}" method="post">
        <%--<form:errors path="*" element="div" />--%>
        <table class="table table-responsive table-bordered">
            <tr>
                <td>Email</td>
                <td>
                    <form:input path="email"/>
                    <form:errors path="email"/>
                </td>
            </tr>
            <tr>
                <td><spring:message code="password"/></td> <!-- internacjonalizacja pola -->
                <td>
                    <form:password path="password"/>
                    <form:errors path="password"/>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Wyślij"/></td>
            </tr>
        </table>
    </form:form>
</div>

