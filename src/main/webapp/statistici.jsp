<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="Clase.AfisStat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Statistici</title>
    <link rel="stylesheet" type="text/css" href="statistici.css"/>
</head>
<body>
<div class="container">
    <h2>Cea mai folosita sala</h2>
    <table class="tabel">
        <tr>
            <th>Id-ul salii</th>
            <th>Numarul evenimentelor</th>
        </tr>
        <%
            ArrayList<AfisStat> std1 = (ArrayList<AfisStat>)request.getAttribute("date1");
            for(AfisStat s:std1){%>
        <tr>
            <td><%=s.getId()%></td>
            <td><%=s.getCount()%></td>
        </tr>
        <%}%>
    </table>
    <h2>Cel mai lung eveniment</h2>
    <table class="tabel">
        <tr>
            <th><b>Id-ul Evenimentului</b></th>
            <th><b>Descriere</b></th>
            <th><b>Nr de zile</b></th>
        </tr>
        <%
            ArrayList<AfisStat> std2 = (ArrayList<AfisStat>)request.getAttribute("date2");
            for(AfisStat s:std2){%>
        <tr>
            <td><%=s.getId()%></td>
            <td><%=s.getDesc()%></td>
            <td><%=s.getCount()%></td>
        </tr>
        <%}%>
    </table>
    <h2>Top activitate clienti</h2>
    <table class="tabel">
        <tr>
            <th><b>Id-ul clientului</b></th>
            <th><b>Nume</b></th>
            <th><b>Nr de rezervari</b></th>
        </tr>
        <%
            ArrayList<AfisStat> std3 = (ArrayList<AfisStat>)request.getAttribute("date3");
            for(AfisStat s:std3){%>
        <tr>
            <td><%=s.getId()%></td>
            <td><%=s.getNume()%></td>
            <td><%=s.getCount()%></td>
        </tr>
        <%}%>
    </table>
</div>

</body>
</html>
