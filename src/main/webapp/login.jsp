<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="updateeven.css"/>
</head>
<body>
<h2>Login</h2>
<div class="tabel">
    <form action="<%=request.getContextPath()%>/LoginServlet" method="post">
        <table>
            <tr>
                <td>Nume de utilizator</td>
                <td><input type="text" name="idcont" placeholder="Nume utilizator" /></td>
            </tr>
            <tr>
                <td>Parola</td>
                <td><input type="password" name="parola" placeholder="Parola" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Login" class="button"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>