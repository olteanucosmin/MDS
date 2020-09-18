<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clase.Evenimente"%>
<%@ page import="Clase.AfisInv" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Invitatii</title>
    <link rel="stylesheet" type="text/css" href="invitatii.css"/>
</head>
<body>
<h2>Invitatii</h2>
<div class="container">
    <table class="tabel">
        <tr>
            <th><b>Mesaj</b></th>
            <th><b>Gazda</b></th>
            <th><b>Data</b></th>
        </tr>
        <%
            ArrayList<AfisInv> std = (ArrayList<AfisInv>)request.getAttribute("date");
            for(AfisInv s:std){%>
        <tr>
            <td><%=s.getMesaj()%></td>
            <td><%=s.getGazda()%></td>
            <td><%=s.getDatainc()%></td>
            <td><form action="UpdateInvitatie" method="post">
                <input type="hidden" name="rasp" value="true">
                <button name="idinvitatie" type="submit" value=<%=s.getId()%>>Accepta</button></form></td>
            <td><form action="UpdateInvitatie" method="post">
                <input type="hidden" name="rasp" value="false">
                <button name="idinvitatie" type="submit" value=<%=s.getId()%>>Refuza</button></form></td>
        </tr>
        <%}%>
    </table>
</div>

</body>
</html>
