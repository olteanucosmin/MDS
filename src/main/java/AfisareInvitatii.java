import Clase.AfisInv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


public class AfisareInvitatii extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        int idclient = (int) servletContext.getAttribute("idclient");
        ArrayList<AfisInv> ev = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            PreparedStatement updateSali = null;
            ResultSet rs;
            String updateString =("select i.mesaj, c.id_cont, e.data_inc, i.id_invitatie from invitatii i join client c on (i.id_gazda = c.id_client) join evenimente e on (i.id_eveniment = e.id_eveniment) where id_invitat = ? and raspuns is null");
            con.setAutoCommit(false);
            updateSali = con.prepareStatement(updateString);
            updateSali.setInt(1, idclient);
            rs=updateSali.executeQuery();
            con.commit();
            while(rs.next()) {
                AfisInv a = new AfisInv();
                a.setGazda(rs.getString("id_cont"));
                a.setDatainc(rs.getDate("data_inc"));
                a.setMesaj(rs.getString("mesaj"));
                a.setId(rs.getInt("id_invitatie"));
                ev.add(a);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        request.setAttribute("date", ev);
        RequestDispatcher r = request.getRequestDispatcher("invitatii.jsp");
        r.forward(request, response);

    }
}
