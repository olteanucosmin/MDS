import Clase.Evenimente;

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


public class AfisareEvenServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        int idclient = (int) servletContext.getAttribute("idclient");
        ArrayList<Evenimente> ev = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            PreparedStatement updateSali = null;
            ResultSet rs;
            String updateString =("select * from evenimente where id_client = ?");
            con.setAutoCommit(false);
            updateSali = con.prepareStatement(updateString);
            updateSali.setInt(1, idclient);
            rs=updateSali.executeQuery();
            con.commit();
            while(rs.next()) {
                Evenimente e = new Evenimente(rs.getInt("id_eveniment"),rs.getInt("id_client"),rs.getInt("id_sala"),rs.getDate("data_inc"),rs.getDate("data_fin"),rs.getString("descriere"),rs.getTime("ora_inc"),rs.getTime("ora_fin"));
                ev.add(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        request.setAttribute("date", ev);
        RequestDispatcher r = request.getRequestDispatcher("evenimente.jsp");
        r.forward(request, response);

    }
}

