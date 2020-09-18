<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bine ati venit!</title>
    <link rel="stylesheet" type="text/css" href="index.css"/>
</head>
<body>
<div class="container">
    <form action="/login.jsp" method="get">
        <input type="submit" value="Login"
               name="Submit" id="frm1_submit" class="button"/>
    </form>
    <form action="/register.jsp" method="get">
        <input type="submit" value="Creare cont"
               name="Submit" id="frm2_submit" class="button"/>
    </form>
</div>
</body>
</html>
