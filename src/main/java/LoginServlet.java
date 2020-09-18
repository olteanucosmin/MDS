import Clase.Client;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idcont = request.getParameter("idcont");
        String parola = request.getParameter("parola");
        int idclient = 0;
        Client c = new Client();
        ArrayList<Client> clienti = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            clienti=c.select(con);
        } catch (Exception e2) {
            System.out.println(e2);
        }
        boolean succes = false;
        for (Client element : clienti)
        {
            if (element.getId_cont().equals(idcont) && element.getParola().equals(parola))
            {
                idclient = element.getId_client();
                succes = true;
                break;
            }
        }

        if(succes)
        {
             getServletContext().removeAttribute( "idclient");
             getServletContext().setAttribute( "idclient", idclient );
             if (idcont.equals("admin"))
             {
                 response.sendRedirect("homeadmin.jsp");
             }
             else
             {
                 response.sendRedirect("home.jsp");
             }
        }
        else
        {
            HttpSession session = request.getSession();
            session.setAttribute("idclient", idclient);
            response.sendRedirect("login.jsp");
        }
    }
}

