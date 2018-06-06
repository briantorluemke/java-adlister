<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<div class="container">
    <form action="/ads/delete" method="post">
        <div class="form-group">
            <h1>Type the Ad ID to remove it from the database.</h1>
            <label for="title">Ad ID</label>
            <input id="title" name="delete" class="form-control" type="text">
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>