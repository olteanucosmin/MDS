import Clase.Evenimente;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class UpdateEvenServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ideveniment = request.getParameter("ideveniment2");

        Evenimente ev1 = new Evenimente();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            PreparedStatement updateSali = null;
            ResultSet rs;
            String updateString =("select * from evenimente where id_eveniment = ?");
            con.setAutoCommit(false);
            updateSali = con.prepareStatement(updateString);
            updateSali.setInt(1, Integer.parseInt(ideveniment));
            rs=updateSali.executeQuery();
            con.commit();
            while (rs.next())
            {
                ev1.setId_eveniment(rs.getInt("id_eveniment"));
                ev1.setId_client(rs.getInt("id_client"));
                ev1.setId_sala(rs.getInt("id_sala"));
                ev1.setDescriere(rs.getString("descriere"));
                ev1.setData_inc(rs.getDate("data_inc"));
                ev1.setOra_inc(rs.getTime("ora_inc"));
                ev1.setOra_fin(rs.getTime("ora_fin"));
                ev1.setData_fin(rs.getDate("data_fin"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        getServletContext().removeAttribute("ideveniment");
        getServletContext().removeAttribute("idsal");
        getServletContext().removeAttribute("idcl");
        getServletContext().removeAttribute("desc");
        getServletContext().removeAttribute("datai");
        getServletContext().removeAttribute("orai");
        getServletContext().removeAttribute("oraf");
        getServletContext().removeAttribute("dataf");
        getServletContext().setAttribute("ideveniment", ideveniment);
        getServletContext().setAttribute("idsal", ev1.getId_sala());
        getServletContext().setAttribute("idcl", ev1.getId_client());
        getServletContext().setAttribute("desc", ev1.getDescriere());
        getServletContext().setAttribute("datai", ev1.getData_inc());
        getServletContext().setAttribute("orai", ev1.getOra_inc());
        getServletContext().setAttribute("oraf", ev1.getOra_fin());
        getServletContext().setAttribute("dataf", ev1.getData_fin());
        request.getRequestDispatcher("updateeven.jsp").forward(request, response);


    }
}
