<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clase.Evenimente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Evenimente</title>
    <link rel="stylesheet" type="text/css" href="evenimente.css"/>
</head>
<body>
<h2>Evenimente</h2>
<div class="container">
    <table class="tabel">
        <tr>
            <th>Sala</th>
            <th>Descriere</th>
            <th>Data inceperii</th>
            <th>Ora inceperii</th>
            <th>Data incheierii</th>
            <th>Ora incheierii</th>
            <th>Optiuni</th>
        </tr>
        <%
            ArrayList<Evenimente> std = (ArrayList<Evenimente>)request.getAttribute("date");
            for(Evenimente s:std){%>
        <tr>
            <td><%=s.getId_sala()%></td>
            <td><%=s.getDescriere()%></td>
            <td><%=s.getData_inc()%></td>
            <td><%=s.getOra_inc()%></td>
            <td><%=s.getData_fin()%></td>
            <td><%=s.getOra_fin()%></td>
            <td><form action="StergereEvenimentServlet" method="post">
                <button name="ideveniment" type="submit" value=<%=s.getId_eveniment()%>>Stergere</button></form>
                <form action="UpdateEvenServlet" method="post">
                    <button name="ideveniment2" type="submit" value=<%=s.getId_eveniment()%>>Modificare</button></form>
                <form action="InvitaServlet" method="post">
                    <button name="ideveniment3" type="submit" value=<%=s.getId_eveniment()%>>Invita client</button></form></td>
        </tr>
        <%}%>
    </table>
</div>

</body>
</html>