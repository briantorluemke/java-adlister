<%--
  Created by IntelliJ IDEA.
  User: douglasbtorluemke
  Date: 6/4/18
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Advertisements</title>
</head>
<body>
<h1>All ads</h1>

<c:forEach var="ad" items="${ads}">
    <h1>${ad.title}</h1>
    <p>${ad.description}</p>
</c:forEach>

</body>
</html>
