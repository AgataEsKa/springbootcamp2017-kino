<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Rezerwacje usera ${user.email}</h1>
<table class="table table-bordered table-striped table-hover border-primary" style="border-color: black">
    <tr>
        <th>Id</th>
        <th>Status</th>
        <th>Film</th>
    </tr>
    <tr>
    <c:forEach items="${userReservations}" var="reservation" >
        <td>${reservation.id}</td>
        <td>${reservation.status}</td>
        <td>${reservation.show.movie.title}</td>
    </c:forEach>
    </tr>
</table>
