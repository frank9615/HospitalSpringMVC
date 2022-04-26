<%--
  Created by IntelliJ IDEA.
  User: fra
  Date: 26/04/22
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" action="addTriage" modelAttribute="newTriage" >

    <form:label path="cf">Codice Fiscale Paziente </form:label>
    <form:input  path="cf" type="text" />
    <form:errors path="cf" />
    <br/>
    <form:label path="notes">Note dell'operatore</form:label>
    <form:textarea path="notes"  rows="4" cols="50" />
    <form:errors path="notes" />
    <br/>


    <form:label path="triageColor">Triage Color</form:label>
    <form:select path="triageColor" >
        <form:option value="RED">Rosso</form:option>
        <form:option value="YELLOW">Giallo</form:option>
        <form:option value="GREEN">Verde</form:option>
        <form:option value="WHITE">Bianco</form:option>
        <form:option value="BLACK">Nero</form:option>
    </form:select><br>
    <form:errors path="triageColor" cssClass="text-danger"/>

    <form:label path="doctor_id">Dottore incaricato</form:label>
    <form:select path="doctor_id" >
        <c:forEach items="${doctors}" var="doctor">
            <form:option value="${doctor.id}">${doctor.name} ${doctor.surname}</form:option>
        </c:forEach>
    </form:select><br>
    <form:errors path="doctor_id" cssClass="text-danger"/>

    <input type="submit" value="Submit" />
</form:form>

</body>
</html>
