import Clase.Invitatii;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class InvitaFormServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nume = request.getParameter("nume");
        String mesaj = request.getParameter("mesaj");
        ServletContext servletContext = getServletContext();
        int idclient = (int) servletContext.getAttribute("idclient");
        String ideveniment = (String) servletContext.getAttribute("ideveniment");

        int idinv = 0;
        Invitatii inv = new Invitatii();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            PreparedStatement updateSali = null;
            ResultSet rs;
            String updateString =("select distinct id_client from client where id_cont = ?");
            con.setAutoCommit(false);
            updateSali = con.prepareStatement(updateString);
            updateSali.setString(1, nume);
            rs=updateSali.executeQuery();
            con.commit();
            while (rs.next())
            {
                idinv = rs.getInt("id_client");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        int i=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            inv.setId_eveniment(Integer.parseInt(ideveniment));
            inv.setId_gazda(idclient);
            inv.setId_invitat(idinv);
            inv.setMesaj(mesaj);
            i=inv.insert(con);
        } catch (Exception e) {
            System.out.println(e);
        }

        if (i == 1)
        {
            request.getRequestDispatcher("AfisareEvenServlet").forward(request, response);
        } else
        {
            request.setAttribute("errMessage", "Inregistrarea a esuat");
            request.getRequestDispatcher("UpdateEvenServlet").forward(request, response);
        }
    }
}
