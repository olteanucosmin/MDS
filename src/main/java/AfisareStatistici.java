import Clase.AfisStat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AfisareStatistici extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<AfisStat> sal = new ArrayList<>();
        ArrayList<AfisStat> ev = new ArrayList<>();
        ArrayList<AfisStat> cl = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select id_sala, count(id_sala) as nr_ev from evenimente group by id_sala having count(id_sala) ="
                                              +"(select max(nrap) from (select count(id_sala) as nrap from evenimente group by id_sala) evenimente)");
            while(rs.next()) {
               AfisStat a = new AfisStat();
               a.setId(rs.getInt("id_sala"));
               a.setCount(rs.getInt("nr_ev"));
                sal.add(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select id_eveniment, descriere, datediff(data_fin,data_inc) as nr_zile from evenimente where datediff(data_fin, data_inc) ="
                                                +" (select max(datediff(data_fin,data_inc)) from evenimente)" );
            while(rs.next()) {
                AfisStat a = new AfisStat();
                a.setId(rs.getInt("id_eveniment"));
                a.setDesc(rs.getString("descriere"));
                a.setCount(rs.getInt("nr_zile"));
                ev.add(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "rootpass");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select e.id_client, c.nume_client, c.prenume_client, count(e.id_client) as nr_rez "
                                                +"from evenimente e join proiect.client c on e.id_client = c.id_client "+
                                                 "group by id_client order by count(e.id_client) desc" );
            while(rs.next()) {
                AfisStat a = new AfisStat();
                a.setId(rs.getInt("id_client"));
                a.setNume(rs.getString("nume_client") + " " + rs.getString("prenume_client"));
                a.setCount(rs.getInt("nr_rez"));
                cl.add(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        request.setAttribute("date1", sal);
        request.setAttribute("date2", ev);
        request.setAttribute("date3", cl);
        RequestDispatcher r = request.getRequestDispatcher("statistici.jsp");
        r.forward(request, response);
    }
}
