import Clase.Sali;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.sql.Date;

public class SelectSalaServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String descriere = request.getParameter("descriere");
        String datainc =request.getParameter("datainc");
        String datafin =request.getParameter("datafin");
        String orainc =request.getParameter("orainc");
        String orafin =request.getParameter("orafin");
        String numarpers =request.getParameter("numarpers");

        ArrayList<Sali> sali = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            PreparedStatement updateSali = null;
            ResultSet rs;
            String updateString =("select distinct * from sali s join evenimente e on s.id_sala = e.id_sala" +
                                              " where (? > e.data_fin or ? < e.data_inc) and s.capacitate >= ?");
            con.setAutoCommit(false);
            updateSali = con.prepareStatement(updateString);
            updateSali.setDate(1, Date.valueOf(datainc));
            updateSali.setDate(2, Date.valueOf(datafin));
            updateSali.setInt(3, Integer.parseInt(numarpers));
            rs=updateSali.executeQuery();
            con.commit();
            while(rs.next()) {
                Sali s = new Sali(rs.getInt("id_sala"),rs.getInt("capacitate"),rs.getString("etaj"),rs.getDouble("pret"));
                sali.add(s);
            }
        } catch (Exception e2) {
            System.out.println(e2);
        }

        getServletContext().removeAttribute("descriere");
        getServletContext().removeAttribute("datainc");
        getServletContext().removeAttribute("orainc");
        getServletContext().removeAttribute("datafin");
        getServletContext().removeAttribute("orafin");
        getServletContext().setAttribute("descriere",descriere);
        getServletContext().setAttribute("datainc",datainc);
        getServletContext().setAttribute("orainc",orainc);
        getServletContext().setAttribute("datafin",datafin);
        getServletContext().setAttribute("orafin",orafin);
        request.setAttribute("data", sali);
        RequestDispatcher rd = request.getRequestDispatcher("selectsala.jsp");
        rd.forward(request, response);

    }
}
