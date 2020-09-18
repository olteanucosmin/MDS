import Clase.Evenimente;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class StergereEvenimentServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ideveniment = request.getParameter("ideveniment");

        Evenimente ev = new Evenimente();
        int i = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            ev.setId_eveniment(Integer.parseInt(ideveniment));
            i = ev.delete(con);
        } catch (Exception e) {
            System.out.println(e);
        }

        if (i == 1)
        {
            request.getRequestDispatcher("AfisareEvenServlet").forward(request, response);
        } else
        {
            request.setAttribute("errMessage", "Inregistrarea a esuat");
            request.getRequestDispatcher("AfisareEvenServlet").forward(request, response);
        }
    }
}
