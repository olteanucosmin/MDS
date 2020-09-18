<%@page import="Clase.Sali"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="Clase.Sali" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sali libere</title>
    <link rel="stylesheet" type="text/css" href="selectsala.css"/>
</head>
<body>
<h1>Sali libere</h1>
<div class="container">
    <form name="form" action="CreareEvenimentServlet" method="post" >
        <table class="tabel">
            <tr>
                <th>Capacitate</th>
                <th>Etaj</th>
                <th>Pret</th>
            </tr>

            <%
                ArrayList<Sali> std = (ArrayList<Sali>)request.getAttribute("data");
                for(Sali s:std){%>

            <tr>
                <td><%=s.getCapacitate()%></td>
                <td><%=s.getEtaj()%></td>
                <td><%=s.getPret()%></td>
                <td><input type="radio" value="<%=s.getId_sala()%>" name="idsala"></input></td>

            </tr>
            <%}%>
            <tr>
                <td></td>
                <td><input type="submit" value="Finalizare" class="button"></input></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
