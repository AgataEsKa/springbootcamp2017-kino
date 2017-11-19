<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table id="accountTable" class="table table-bordered">
    <thead>
        <tr>
            <th>Id</th>
            <th>Email</th>
            <th>Password</th>
            <th>Reservations</th>
        </tr>
    </thead>

    <%--to już nam niepotrzene:   <--- zrobi to samo Datatables--%>
    <%--<c:forEach items="${users}" var="user">--%>
        <%--<tr>--%>
            <%--<td>${user.getId()}</td>--%>
            <%--<td>${user.email}</td>--%>
            <%--<td>${user.password}</td>--%>
            <%--<td><a href="<c:url value="/reservations/byUser?userId=${user.id}"/>">${user.reservations.size()}</a></td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>

</table>

<a href="<c:url value = "/accounts/add"/>">Dodaj użytkownika</a>

<script>
    $(document).ready(function () {
        $('#accountTable').DataTable({
            "processing": true,
            "ajax": {
                "url": "<c:url value="/accounts/ajax"/>",
                "dataSrc": ""
            },
            "columns": [
                {"data": "id"},
                {"data": "email"},
                {"data": "password"},
                {"data": "reservations"}
            ],
            "columnDefs": [
                {
                    "render": function ( data, type, row ) {
                        return "<a href=\"<c:url value="/reservations"/>/byUser2/" + row.id + "\">" + data.length +"</a>";
                    },
                    "targets": 3
                }
            ]

        });
    });
</script>

