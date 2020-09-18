<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="home.css"/>
    <title>Home</title>
</head>
<body>
<div align="center" align="top" class="container">
    <form class="menu">
        <button type=submit formaction="AfisareCont" formmethod="post" formtarget="frame" >Detalii cont</button>
        <button type=submit formaction="AfisareEvenServlet" formmethod="post" formtarget="frame" >Evenimente</button>
        <button type=submit formaction="/organizare.jsp" formmethod="get" formtarget="frame" >Organizare eveniment</button>
        <button type=submit formaction="AfisareInvitatii" formmethod="post" formtarget="frame" >Invitatii</button>
        <button type=submit formaction="/index.jsp" formmethod="get" formtarget="_self" >Logout</button>
    </form>

</div>
<div  margin-left="auto" align="center" align="top" >
    <iframe name="frame"></iframe>
</div>

</body>
</html>

