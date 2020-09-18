<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="Clase.Client" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Detalii Cont</title>
    <link rel="stylesheet" type="text/css" href="detcont.css"/>
</head>
<body>
<h2>Detalii Cont</h2>
<table class="tabel">
    <%
        Client c = (Client)request.getAttribute("date");
    %>
    <tr>
        <th>Nume</th>
        <td><%=c.getNume_client()%></td>
    </tr>
    <tr>
        <th>Prenume</th>
        <td><%=c.getPrenume_client()%></td>
    </tr>
    <tr>
        <th>Nume de cont</th>
        <td><%=c.getId_cont()%></td>
    </tr>
    <tr>
        <th>Institutie</th>
        <td><%=c.getNume_institutie()%></td>
    </tr>
    <tr>
        <th>Mail Institutional</th>
        <td><%=c.getMail_inst()%></td>
    </tr>
    <tr>
        <th>Mail personal</th>
        <td><%=c.getMail_pers()%></td>
    </tr>
    <tr>
        <th>Nr de telefon</th>
        <td><%=c.getNr_tel()%></td>
    </tr>
</table>
</body>
</html>
