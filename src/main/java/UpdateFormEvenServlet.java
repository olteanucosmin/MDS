import Clase.Evenimente;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class UpdateFormEvenServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String descriere = request.getParameter("descriere");
        String datainc = request.getParameter("datainc");
        String orainc = request.getParameter("orainc");
        String orafin = request.getParameter("orafin");
        String datafin = request.getParameter("datafin");
        ServletContext servletContext = getServletContext();
        String ideveniment = (String) servletContext.getAttribute("ideveniment");
        int idsal = (int) servletContext.getAttribute("idsal");
        int idcl = (int) servletContext.getAttribute("idcl");
        String desc = (String) servletContext.getAttribute("desc");
        Date datai = (Date) servletContext.getAttribute("datai");
        Time orai = (Time) servletContext.getAttribute("orai");
        Time oraf = (Time) servletContext.getAttribute("oraf");
        Date dataf = (Date) servletContext.getAttribute("dataf");

        Evenimente s2 = new Evenimente();
        s2.setId_eveniment(Integer.parseInt(ideveniment));
        s2.setId_sala(idsal);
        s2.setId_client(idcl);
        int i=0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            if (descriere == null || descriere == "")
            {
                s2.setDescriere(desc);
            }
            else {
                s2.setDescriere(descriere);
            }
            if (datainc == null || datainc =="")
            {
                s2.setData_inc(datai);
            }
            else{
                s2.setData_inc(Date.valueOf(datainc));
            }
            if (orainc == null|| orainc =="")
            {
                s2.setOra_inc(orai);
            }
            else{
                s2.setOra_inc(Time.valueOf(orainc));
            }
            if (orafin == null|| orafin =="")
            {
                s2.setOra_fin(oraf);
            }
            else{
                s2.setOra_fin(Time.valueOf(orafin));
            }
            if (datafin == null || datafin =="")
            {
                s2.setData_fin(dataf);
            }
            else{
                s2.setData_fin(Date.valueOf(datafin));
            }
            i=s2.update(con);
        }catch (Exception e) {
            System.out.println(e);
        }


        if (i == 1)
        {
            request.getRequestDispatcher("AfisareEvenServlet").forward(request, response);
        } else
        {
            request.setAttribute("errMessage", "Inregistrarea a esuat");
            request.getRequestDispatcher("UpdateEvenServlet").forward(request, response);
        }
    }
}
