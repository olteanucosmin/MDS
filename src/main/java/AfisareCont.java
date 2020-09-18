import Clase.Client;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


public class AfisareCont extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        int idclient = (int) servletContext.getAttribute("idclient");
        Client c = new Client();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            PreparedStatement updateclient = null;
            ResultSet rs;
            String updateString = ("select * from client where id_client = ?");
            con.setAutoCommit(false);
            updateclient = con.prepareStatement(updateString);
            updateclient.setInt(1, idclient);
            rs = updateclient.executeQuery();
            con.commit();
            while (rs.next()) {
                c.setNume_client(rs.getString("nume_client"));
                c.setPrenume_client(rs.getString("prenume_client"));
                c.setId_cont(rs.getString("id_cont"));
                c.setNume_institutie(rs.getString("nume_institutie"));
                c.setMail_inst(rs.getString("mail_inst"));
                c.setMail_pers(rs.getString("mail_pers"));
                c.setNr_tel(rs.getString("nr_tel"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        request.setAttribute("date", c);
        RequestDispatcher r = request.getRequestDispatcher("detaliicont.jsp");
        r.forward(request, response);
    }
}
