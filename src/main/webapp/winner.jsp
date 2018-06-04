<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Guessing Game!</title>
</head>
<body>

<p>${value}</p>
<a href="/guess">Try again?</a>
<c:if test="${empty param.loser}">
    <form action="guess" method="GET">
        <p>Cli</p>
        <input type="submit" value="Play Again?" name="reset">
    </form>
</c:if>

</body>
</html>