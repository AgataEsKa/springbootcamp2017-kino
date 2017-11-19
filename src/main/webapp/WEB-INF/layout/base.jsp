<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Kino</title>
    <link rel="icon" href="<c:url value="/resources/favicon.png"/>" type="image/x-icon"/>

    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"/>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/jq-3.2.1/dt-1.10.16/datatables.min.css"/>

    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/jq-3.2.1/dt-1.10.16/datatables.min.js"></script>

    <tiles:insertAttribute name="css"/>
</head>
<body>
<div class="container-fluid">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">System KINO</a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value = "/accounts"/>">Użytkownicy</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Rezerwacje</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Seanse</a>
                </li>

            </ul>
            <ul class="navbar-nav ml-auto float-right">
                <li class="nav-item active">
                        <sec:authorize access="isAnonymous()">
                            <a class="nav-link" href="<c:url value="/login"/>">Logowanie</a>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <a class="nav-link" href="<c:url value="/logout"/>">Wyloguj</a>
                        </sec:authorize>
                </li>
            </ul>

        </div>
    </nav>
    <div class="jumbotron">
        <div class="row">
            <div class="col-sm-12">
                <tiles:insertAttribute name="body"/>
            </div>
        </div>
    </div>
</div>

<tiles:insertAttribute name="footer"/>

</body>
</html>
