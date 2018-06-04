<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Guessing Game!</title>
</head>
<body>

<p>Go higher!</p>
<form method="POST" action="guess">
    <p> Number <input type="number" name="guess" value="${choice}" size="50"> </p>
    <p> <input type="submit" value="Submit" name="B1"> </p>
</form>


</body>
</html>