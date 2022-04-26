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
    <title>Operator Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value="/static/js/patientRegistration.js" />"></script>
</head>
<body>
    <h1>Operator Page</h1>
    <p> Welcome ${user}</p>
    <h3>Registrazione Paziente</h3>
    <div name="addPatient">
        <form id="registrationForm" action="/savePatient">
            Codice Fiscale: <br>
            <input type="text" id="cf" name="cf"  value ="">
            <br>
            First name:<br>
            <input type="text" id="name" name="name" value="" >
            <br>
            Last name:<br>
            <input type="text" id="surname" name="surname" value="" >
            <br>
            Data di nascita:<br>
            <input type="date" id="birthday" name="birthday"  >
            <br><br>
            <input id="submitButton" type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
