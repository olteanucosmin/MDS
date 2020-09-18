<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="updateeven.css"/>
</head>
<body>
<h2>Update Sala</h2>
<form name="form" action="UpdateFormSalaServlet" method="post">
    <table align="center">
        <tr>
            <td>Capacitate</td>
            <td><input type="text" name="capacitate"/></td>
        </tr>
        <tr>
            <td>Etaj</td>
            <td><input type="text" name="etaj"/></td>
        </tr>
        <tr>
            <td>Pret</td>
            <td><input type="text" name="pret"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update" class="button"></input><input
                    type="reset" value="Reset" class="button"></input></td>
        </tr>
    </table>
</form>
</body>
</html></html>
