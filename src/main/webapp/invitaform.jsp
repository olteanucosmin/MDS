<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Invitati client</title>
    <link rel="stylesheet" type="text/css" href="updateeven.css"/>
    <script>
        function validate()
        {
            var nume = document.form.nume.value;

            if (nume==null || nume=="")
            {
                alert("Numele trebuie completat");
                return false;
            }
        }
    </script>
</head>
<body>
<h2>Invitati client</h2>
<div class="tabel">
    <form name="form" action="InvitaFormServlet" method="post" onsubmit="return validate()" >
        <table>
            <tr>
                <td>Numele de cont al invitatului</td>
                <td><input type="text" name="nume"/></td>
            </tr>
            <tr>
                <td>Mesaj</td>
                <td><input type="text" name="mesaj"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Register" class="button"></input><input
                        type="reset" value="Reset" class="button"></input></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
