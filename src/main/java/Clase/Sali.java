package Clase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Sali {

    private int id_sala;
        private int capacitate;
        private String etaj;
        private double pret;

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }


    public String toString() {
        return String.valueOf(capacitate) + "," + etaj + "," + String.valueOf(pret) +"\n";
    }

    public Sali(){}

    public Sali(int id, int cap, String et, double pr) {
        id_sala=id;
        capacitate=cap;
        etaj=et;
        pret=pr;
    }

    public int getCapacitate(){
            return capacitate;
        }

    public void setCapacitate(int capacitate){
            this.capacitate=capacitate;
        }

    public String getEtaj(){
            return etaj;
        }

    public void setEtaj(String etaj){
            this.etaj=etaj;
        }

    public double getPret(){
            return pret;
        }

    public void setPret(double pret){
            this.pret=pret;
        }

    /// Select Clase.Sali
    public ArrayList<Sali> select(Connection con){
        try {
            ArrayList<Sali> sali = new ArrayList<>();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from sali");
            while(rs.next()) {
                Sali s = new Sali(rs.getInt("id_sala"), rs.getInt("capacitate"),rs.getString("etaj"),rs.getDouble("pret"));
                sali.add(s);
            }
            return sali;
        }catch(Exception e){ System.out.println(e);}

        return null;
    }


    // Update Clase.Sali
    public int update (Connection con){
        int i = 0;
        try{
            PreparedStatement updateSali = null;
            String updateString =
                    "update " + "proiect.Sali " +
                            "set capacitate=?, etaj=? ,pret = ? where id_sala = ?";
            con.setAutoCommit(false);
            updateSali = con.prepareStatement(updateString);
            updateSali.setInt(1,this.capacitate);
            updateSali.setString(2,this.etaj);
            updateSali.setDouble(3,this.pret);
            updateSali.setInt(4,this.id_sala);
            i = updateSali.executeUpdate();
            con.commit();
        }catch(Exception e){ System.out.println(e);}
        return i;
    }

    //Insert Clase.Sali
    public int insert (Connection con){
        int i = 0;
        try {
            PreparedStatement updateSali = null;
            String updateString = "insert into Sali(capacitate,etaj,pret) values (?,?,?)";
            con.setAutoCommit(false);
            updateSali = con.prepareStatement(updateString);
            updateSali.setInt(1,this.capacitate);
            updateSali.setString(2,this.etaj);
            updateSali.setDouble(3,this.pret);
            i = updateSali.executeUpdate();
            con.commit();
        }catch(Exception e){ System.out.println(e);}
        return i;
    }

    //Delete Clase.Sali
    public int delete(Connection con){
        int i =0;
        try{
            PreparedStatement updateSali = null;
            String updateString = "delete from sali where id_sala = ?";
            con.setAutoCommit(false);
            updateSali = con.prepareStatement(updateString);
            updateSali.setInt(1,this.id_sala);
            i=updateSali.executeUpdate();
            con.commit();
        }catch(Exception e){ System.out.println(e);}
        return i;

    }

    public int getId_sala() {
        return id_sala;
    }
}
