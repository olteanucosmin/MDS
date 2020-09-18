import Clase.Invitatii;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class UpdateInvitatie extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idinvitatie = request.getParameter("idinvitatie");
        String rasp = request.getParameter("rasp");

        Invitatii s2 = new Invitatii();
        s2.setId_invitatie(Integer.parseInt(idinvitatie));
        s2.setRaspuns(Boolean.parseBoolean(rasp));
        int i = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            i = s2.update(con);
        } catch (Exception e) {
            System.out.println(e);
        }


        if (i == 1)
        {
            request.getRequestDispatcher("AfisareInvitatii").forward(request, response);
        } else
        {
            request.setAttribute("errMessage", "Inregistrarea a esuat");
            request.getRequestDispatcher("AfisareInvitatii").forward(request, response);
        }
    }
}
