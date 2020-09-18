import Clase.Sali;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class UpdateFormSalaServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String capacitate = request.getParameter("capacitate");
        String etaj = request.getParameter("etaj");
        String pret = request.getParameter("pret");
        ServletContext servletContext = getServletContext();
        String idsala = (String) servletContext.getAttribute("idsala");
        int cap = (int) servletContext.getAttribute("cap");
        String et = (String) servletContext.getAttribute("et");
        double pr = (double) servletContext.getAttribute("pr");

        Sali s2 = new Sali();
        s2.setId_sala(Integer.parseInt(idsala));
        int i=0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            if (capacitate == null || capacitate == "")
            {
                s2.setCapacitate(cap);
            }
            else {
                s2.setCapacitate(Integer.parseInt(capacitate));
            }
            if (etaj == null || etaj =="")
           {
                s2.setEtaj(et);
            }
            else{
                s2.setEtaj(etaj);
            }
           if (pret == null|| pret =="")
           {
                s2.setPret(pr);
           }
           else{
                s2.setPret(Double.parseDouble(pret));
           }
            i=s2.update(con);
        }catch (Exception e) {
            System.out.println(e);
        }


        if (i == 1)
        {
            request.getRequestDispatcher("EditareSaliServlet").forward(request, response);
        } else
        {
            request.setAttribute("errMessage", "Inregistrarea a esuat");
            request.getRequestDispatcher("UpdateSalaServlet").forward(request, response);
        }
    }
}
