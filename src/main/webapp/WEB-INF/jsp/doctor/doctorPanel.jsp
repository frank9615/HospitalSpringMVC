<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 22/04/2022
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Doctor Page</title>
    <link href="<c:url value="/static/css/style.css" />" rel="stylesheet">
</head>
<body>
<h1>Doctor Page</h1>
<p> Welcome ${currentUser}</p><br>

<p> Pazienti Assegnati </p>

<table id="triages" >
    <th>
        <tr>
            <th>Id</th>
            <th>Note</th>
            <th>Id paziente</th>
            <th>Codice fiscale</th>
            <th>Nome</th>
            <th>Cognome</th>
            <th>Data di nascita</th>
            <th>Colore Associato</th>
            <th>Data</th>
        </tr>
    </th>
    <tb>
    <c:forEach items="${triages}" var="triage">
        <tr>
            <td>${triage.id}</td>
            <td>${triage.notes}</td>
            <td>${triage.patient.id}</td>
            <td>${triage.patient.cf}</td>
            <td>${triage.patient.name}</td>
            <td>${triage.patient.surname}</td>
            <td>${triage.patient.birthday}</td>
            <td>${triage.triageColor}</td>
            <td>${triage.triageDate}</td>
        </tr>
    </c:forEach>
    </tb>
</table>


</body>
</html>
