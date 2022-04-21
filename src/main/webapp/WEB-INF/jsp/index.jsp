<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Simple Index Test</title>
</head>
<body>
<h1>${message}</h1>
<p><spring:message code="index.p.test"/></p>
<br/>
</body>
</html>