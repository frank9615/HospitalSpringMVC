<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 22/04/2022
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Admin Page</title>
    <link href="<c:url value="/static/css/style.css" />" rel="stylesheet">
</head>
<body>
<h1>Admin Page</h1>
<h2>Users</h2>
<table id="users" >
    <th>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Username</th>
            <th>Role</th>
        </tr>
    </th>
    <tb>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.username}</td>
                <td>${user.role}</td>
            </tr>
        </c:forEach>
    </tb>
</table>

<h2>Pazienti</h2>
<table id="patients" >
    <th>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Codice Fiscale</th>
            <th>Data di Nascita</th>
            <th>Data di registrazione</th>
        </tr>
    </th>
    <tb>
        <c:forEach items="${patients}" var="patient">
            <tr>
                <td>${patient.id}</td>
                <td>${patient.name}</td>
                <td>${patient.surname}</td>
                <td>${patient.cf}</td>
                <td>${patient.birthday}</td>
                <td>${patient.registrationDate}</td>
            </tr>
        </c:forEach>
    </tb>
</table>

<h2>Triages</h2>
<table id="triages" >
    <th>
        <tr>
            <th>id</th>
            <th>Codice Fiscale Paziente</th>
            <th>Colore Triage</th>
            <th>Data triage</th>
            <th>Username Dottore</th>
            <th>Username Operatore</th>
        </tr>
    </th>
    <tb>
        <c:forEach items="${triages}" var="triage">
            <tr>
                <td>${triage.id}</td>
                <td>${triage.patient.cf}</td>
                <td>${triage.triageColor}</td>
                <td>${triage.triageDate}</td>
                <td>${triage.doctor.username}</td>
                <td>${triage.operator.username}</td>
            </tr>
        </c:forEach>
    </tb>
</table>

</body>
</html>
