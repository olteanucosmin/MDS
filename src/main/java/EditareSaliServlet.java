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

public class EditareSaliServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        ArrayList<Sali> sali = new ArrayList<>();
        Sali s = new Sali();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            sali = s.select(con);

        } catch (Exception e) {
            System.out.println(e);
        }

        request.setAttribute("date", sali);
        RequestDispatcher r = request.getRequestDispatcher("AddSala.jsp");
        r.forward(request, response);

    }
}
