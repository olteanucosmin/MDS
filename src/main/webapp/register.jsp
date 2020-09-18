<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Register</title>
    <script>
        function validate()
        {
            var nume = document.form.nume.value;
            var prenume = document.form.prenume.value;
            var numeinst = document.form.numeinst.value;
            var maili = document.form.maili.value;
            var mailp = document.form.mailp.value;
            var nrt = document.form.nrt.value;
            var idcont = document.form.idcont.value;
            var parola = document.form.parola.value;
            var conparola= document.form.conparola.value;

            if (nume==null || nume=="")
            {
                alert("Numele trebuie completat");
                return false;
            }
            if (prenume==null || prenume=="")
            {
                alert("Prenumele trebuie completat");
                return false;
            }
            if (numeinst==null || numeinst=="")
            {
                alert("Numele institutiei trebuie completat");
                return false;
            }
            else if (maili==null || maili=="")
            {
                alert("Mailul institutiei trebuie completat");
                return false;
            }
            else if (mailp==null || mailp=="")
            {
                alert("Mailul personal trebuie completat");
                return false;
            }
            else if (nrt==null || nrt=="")
            {
                alert("Numarul de telefon trebuie completat");
                return false;
            }
            else if (idcont==null || idcont=="")
            {
                alert("Numele de utilizator trebuie completat");
                return false;
            }
            else if(parola.length<6)
            {
                alert("Parola trebuie sa aiba cel putin 6 caractere");
                return false;
            }
            else if (parola!=conparola)
            {
                alert("Confirmarea parolei trebuie sa fie identica cu parola");
                return false;
            }
        }
    </script>
    <link rel="stylesheet" type="text/css" href="updateeven.css"/>
</head>
<body>
<h2>Inregistrare client</h2>
<div class="tabel">
    <form name="form" action="RegisterServlet" method="post" onsubmit="return validate()">
        <table>
            <tr>
                <td>Nume</td>
                <td><input type="text" name="nume" /></td>
            </tr>
            <tr>
                <td>Prenume</td>
                <td><input type="text" name="prenume" /></td>
            </tr>
            <tr>
                <td>Nume institutie</td>
                <td><input type="text" name="numeinst" /></td>
            </tr>
            <tr>
                <td>Mail institutie</td>
                <td><input type="text" name="maili" /></td>
            </tr>
            <tr>
                <td>Mail personal</td>
                <td><input type="text" name="mailp" /></td>
            </tr>
            <tr>
                <td>Nr de telefon</td>
                <td><input type="text" name="nrt" /></td>
            </tr>
            <tr>
                <td>Nume de utilizator</td>
                <td><input type="text" name="idcont" /></td>
            </tr>
            <tr>
                <td>Parola</td>
                <td><input type="password" name="parola" /></td>
            </tr>
            <tr>
                <td>Confirm Parola</td>
                <td><input type="password" name="conparola" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Register" class="button">
                    <input type="reset" value="Reset" class="button"></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>