<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clase.Sali"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Adaugare Sali</title>
    <script>
        function validate()
        {
            var capacitate = document.form.capacitate.value;
            var etaj = document.form.etaj.value;
            var pret = document.form.pret.value;

            if (capacitate==null || capacitate=="")
            {
                alert("Capacitatea trebuie completata");
                return false;
            }
            if (etaj==null || etaj=="")
            {
                alert("Etajul trebuie completat");
                return false;
            }
            if (pret==null || pret=="")
            {
                alert("Pretul trebuie completat");
                return false;
            }
        }
    </script>
    <link rel="stylesheet" type="text/css" href="addsala.css"/>
</head>
<body>
<h2>Adaugare sala</h2>
<div class="container">
    <table class="tabel">
        <tr>
            <th class="cap">Numar sala</th>
            <th class="cap">Capacitate</th>
            <th class="cap">Etaj</th>
            <th class="cap">Pret</th>
            <th class="cap">Optiuni</th>
        </tr>
        <%
            ArrayList<Sali> std = (ArrayList<Sali>)request.getAttribute("date");
            for(Sali s:std){%>
        <tr>
            <td class="rand"><%=s.getId_sala()%></td>
            <td class="rand"><%=s.getCapacitate()%></td>
            <td class="rand"><%=s.getEtaj()%></td>
            <td class="rand"><%=s.getPret()%></td>
            <td class="rand"><form action="StergereSalaServlet" method="post" >
                <button name="idsala" type="submit" value="<%=s.getId_sala()%>" >Stergere</button></form>
                <form action="UpdateSalaServlet" method="post" >
                    <button name="idsala2" type="submit" value="<%=s.getId_sala()%>" >Modificare</button></form></td>
        </tr>
        <%}%>
    </table>
</div>
<div class="form">
    <form name="form" action="AdaugareSalaServlet" method="post" >
        <table align="center">
            <tr>
                <td>Capacitate(Numar persoane)</td>
                <td><input type="text" name="capacitate"/></td>
            </tr>
            <tr>
                <td>Etaj</td>
                <td><input type="text" name="etaj" /></td>
            </tr>
            <tr>
                <td>Pret(Lei / Ora)</td>
                <td><input type="text" name="pret"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Submit" class="button"></input>
                    <input type="reset" value="Reset" class="button"></input></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>