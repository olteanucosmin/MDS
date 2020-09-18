<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="updateeven.css"/>
</head>
<body>
<h2>Update Eveniment</h2>
<div class="tabel">
    <form name="form" action="UpdateFormEvenServlet" method="post">
        <table>
            <tr>
                <td>Descriere</td>
                <td><input type="text" name="descriere"/></td>
            </tr>
            <tr>
                <td>Data de incepere</td>
                <td><input type="date" name="datainc"/></td>
            </tr>
            <tr>
                <td>Ora de incepere</td>
                <td><input type="time" name="orainc"/></td>
            </tr>
            <tr>
                <td>Ora de incheiere</td>
                <td><input type="time" name="orafin"/></td>
            </tr>
            <tr>
                <td>Data de incheiere</td>
                <td><input type="date" name="datafin"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update" class="button"/><input
                        type="reset" value="Reset" class="button"/></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
