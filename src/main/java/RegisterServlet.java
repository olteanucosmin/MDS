import Clase.Client;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String id_c = request.getParameter("idcont");
        String par = request.getParameter("parola");
        String nume_inst = request.getParameter("numeinst");
        String nume_cl = request.getParameter("nume");
        String pren_cl = request.getParameter("prenume");
        String nr_t = request.getParameter("nrt");
        String mail_i = request.getParameter("maili");
        String mail_p = request.getParameter("mailp");
        int i = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            Client c = new Client();
            c.setId_cont(id_c);
            c.setParola(par);
            c.setNume_institutie(nume_inst);
            c.setNume_client(nume_cl);
            c.setPrenume_client(pren_cl);
            c.setNr_tel(nr_t);
            c.setMail_inst(mail_i);
            c.setMail_pers(mail_p);
            i = c.insert(con);
        } catch (Exception e2) {
            System.out.println(e2);
        }
        if(i==1)
        {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("errMessage", "Inregistrarea a esuat");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }

    }
}
