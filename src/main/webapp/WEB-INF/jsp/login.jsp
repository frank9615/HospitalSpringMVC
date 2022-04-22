<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hospital Login</title>
</head>
<body>
<h1>Login</h1>
<c:url var = "loginUrl" value ="/login" />
<form action ="${loginUrl}" method="POST" >
    <c:if test="${param.error != null}">
        <!-- I parametri vengono passati da configure del file SecurityConfig -->
        <p><spring:message code ="login.form.errmsg"></spring:message></p>
    </c:if>

    <c:if test="${param.forbidden != null}">
        <p><spring:message code ="login.form.forbidden"></spring:message></p>
    </c:if>

    <c:if test="${param.forbidden != null}">
        <p><spring:message code ="login.form.logout"></spring:message></p>
    </c:if>
    <!-- Attenzione che i parametri di username e password devono combaciare con i parametri inseriti dentro il config -->
    <label for="username" />
    <input type="text" id="username" name=username" placeholder="username" required />
    <label for="password" />
    <input type="password" id="password" name="password" required />
    <!-- Richiesto nel caso in cui il cross origin è disabilitato/abilitato -->
    <!--<input type="hidden" name="${_csrf.parametername}" value="${_csfr.token}" />-->

    <input type="submit" value="Login" />

</form>

<br/>
</body>
</html>