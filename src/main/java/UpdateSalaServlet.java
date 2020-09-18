import Clase.Sali;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class UpdateSalaServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idsala = request.getParameter("idsala2");

        Sali s1 = new Sali();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            PreparedStatement updateSali = null;
            ResultSet rs;
            String updateString =("select * from sali where id_sala = ?");
            con.setAutoCommit(false);
            updateSali = con.prepareStatement(updateString);
            updateSali.setInt(1, Integer.parseInt(idsala));
            rs=updateSali.executeQuery();
            con.commit();
            while (rs.next())
            {
                s1.setId_sala(rs.getInt("id_sala"));
                s1.setCapacitate(rs.getInt("capacitate"));
                s1.setEtaj(rs.getString("etaj"));
                s1.setPret(rs.getDouble("pret"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        getServletContext().removeAttribute("idsala");
        getServletContext().removeAttribute("cap");
        getServletContext().removeAttribute("et");
        getServletContext().removeAttribute("pr");
        getServletContext().setAttribute("idsala", idsala);
        getServletContext().setAttribute("cap", s1.getCapacitate());
        getServletContext().setAttribute("et", s1.getEtaj());
        getServletContext().setAttribute("pr", s1.getPret());
        request.getRequestDispatcher("updatesala.jsp").forward(request, response);


    }
}
