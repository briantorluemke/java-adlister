<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="partials/header.jsp"%>
<%@ include file="partials/navbar.jsp"%>
<%@ include file="partials/footer.jsp"%>
<html style="height: 100%">
<head>
    <title><%= "some title" %></title>
</head>
<body style="background-color: darkorange">
    <c:if test="true">
        <h1>Variable names should be very descriptive</h1>
    </c:if>
    <c:if test="false">
        <h1>single letter variable names are good</h1>
    </c:if>
</body>
</html>