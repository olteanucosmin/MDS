package Clase;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;

public class Evenimente {
    private int id_eveniment;
    private int id_client;
    private int id_sala;
    private Date data_inc;
    private Date data_fin;
    private String descriere;
    private Time ora_inc;
    private Time ora_fin;

    public Evenimente() {

    }

    public Evenimente(int id, int cl, int sl, Date inc, Date fin, String desc, Time ora_i, Time ora_f) {
        id_eveniment =id;
        id_client=cl;
        id_sala=sl;
        data_inc=inc;
        data_fin=fin;
        descriere = desc;
        ora_inc = ora_i;
        ora_fin = ora_f;
    }

    public int getId_client(){
        return id_client;
    }

    public void setId_client(int id_client){
        this.id_client=id_client;
    }

    public int getId_sala(){
        return id_sala;
    }

    public void setId_sala(int id_sala){
        this.id_sala=id_sala;
    }

    public java.util.Date getData_inc(){
        return data_inc;
    }

    public void setData_inc(Date data_inc){
        this.data_inc=data_inc;
    }

    public java.util.Date getData_fin(){
        return data_fin;
    }

    public void setData_fin(Date data_fin){
        this.data_fin=data_fin;
    }

    public String getDescriere() { return descriere; }

    public Time getOra_inc() { return ora_inc; }

    public Time getOra_fin() { return ora_fin; }

    public void setDescriere(String descriere) { this.descriere = descriere; }

    public void setOra_inc(Time ora_inc) { this.ora_inc = ora_inc; }

    public void setOra_fin(Time ora_fin) { this.ora_fin = ora_fin; }

    /// Select Clase.Evenimente
    public ArrayList<Evenimente> select (Connection con){

        try {
            ArrayList<Evenimente> evenimente = new ArrayList<>();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from evenimente");
            while(rs.next()) {
                Evenimente e = new Evenimente(rs.getInt("id_eveniment"),rs.getInt("id_client"),rs.getInt("id_sala"),rs.getDate("data_inc"),rs.getDate("data_fin"),rs.getString("descriere"),rs.getTime("ora_inc"),rs.getTime("ora_fin"));
                evenimente.add(e);
            }
            return evenimente;
        }catch(Exception e){ System.out.println(e);}
        return null;
    }

    /// Update Clase.Evenimente
    public int update (Connection con){

        int i =0;
        try {
            PreparedStatement updateEvenimente = null;
            String updateString =
                    "update " + "proiect.evenimente " +
                            "set id_sala = ?, id_client = ?, descriere = ?, data_inc = ?, ora_inc = ? , ora_fin = ?, data_fin = ? where id_eveniment = ?";
            con.setAutoCommit(false);
            updateEvenimente = con.prepareStatement(updateString);
            updateEvenimente.setInt(1,this.id_sala);
            updateEvenimente.setInt(2,this.id_client);
            updateEvenimente.setString(3,this.descriere);
            updateEvenimente.setDate(4,this.data_inc);
            updateEvenimente.setTime(5,this.ora_inc);
            updateEvenimente.setTime(6,this.ora_fin);
            updateEvenimente.setDate(7,this.data_fin);
            updateEvenimente.setInt(8,this.id_eveniment);
            i=updateEvenimente.executeUpdate();
            con.commit();
        }catch(Exception e){ System.out.println(e);}
        return i;
    }

    ///Insert Clase.Evenimente
    public int insert (Connection con){
        int i=0;
        try {
            PreparedStatement updateEvenimente = null;
            String updateString = "insert into Evenimente(id_client,id_sala,descriere,data_inc,data_fin,ora_inc,ora_fin) values (?,?,?,?,?,?,?)";
            con.setAutoCommit(false);
            updateEvenimente = con.prepareStatement(updateString);
            updateEvenimente.setInt(1,this.id_client);
            updateEvenimente.setInt(2,this.id_sala);
            updateEvenimente.setString(3,this.descriere);
            updateEvenimente.setDate(4, this.data_inc);
            updateEvenimente.setDate(5, this.data_fin);
            updateEvenimente.setTime(6, this.ora_inc);
            updateEvenimente.setTime(7,this.ora_fin);
            i=updateEvenimente.executeUpdate();
            con.commit();
        }catch(Exception e){ System.out.println(e);}
        return i;
    }

    ///Delete Clase.Evenimente
    public int delete(Connection con){
        int i=0;
        try{
            PreparedStatement updateEvenimente = null;
            String updateString = "delete from evenimente where id_eveniment = ?";
            con.setAutoCommit(false);
            updateEvenimente = con.prepareStatement(updateString);
            updateEvenimente.setInt(1,this.id_eveniment);
            i = updateEvenimente.executeUpdate();
            con.commit();
        }catch(Exception e){ System.out.println(e);}
        return i;
    }

    public int getId_eveniment() {
        return id_eveniment;
    }

    public void setId_eveniment(int id_eveniment) {
        this.id_eveniment = id_eveniment;
    }
}
