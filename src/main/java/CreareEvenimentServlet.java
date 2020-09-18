
import Clase.Evenimente;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CreareEvenimentServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idsala =  request.getParameter("idsala");
        ServletContext servletContext = getServletContext();
        String descriere = (String) servletContext.getAttribute("descriere");
        String datainc = (String) servletContext.getAttribute("datainc");
        String datafin = (String) servletContext.getAttribute("datafin");
        //String orainc = (String) servletContext.getAttribute("orainc");
        //String orafin = (String) servletContext.getAttribute("orafin");

        int idclient = (int) servletContext.getAttribute("idclient");
        int i =0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            Evenimente e = new Evenimente();
            e.setId_client(idclient);
            e.setId_sala(Integer.parseInt(idsala));
            e.setDescriere(descriere);
            e.setData_inc(Date.valueOf(datainc));
            //e.setOra_inc(Time.valueOf(orainc));
           // e.setOra_fin(Time.valueOf(orafin));
            e.setData_fin(Date.valueOf(datafin));
            i = e.insert(con);
        } catch (Exception e2) {
            System.out.println(e2);
        }
        if(i==1)
        {
            request.getRequestDispatcher("AfisareEvenServlet").forward(request, response);
        }
        else
        {
            request.setAttribute("errMessage", "Rezervarea a esuat");
            request.getRequestDispatcher("/organizare.jsp").forward(request, response);
        }

    }
}
