package Clase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Invitatii {

    private int id_invitatie;
    private String mesaj;
    private int id_eveniment;
    private int id_gazda;
    private int id_invitat;
    private boolean raspuns;

    public void setId_invitatie(int id_invitatie) {
        this.id_invitatie = id_invitatie;
    }

    public int getId_invitatie() {
        return id_invitatie;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public void setId_eveniment(int id_eveniment) {
        this.id_eveniment = id_eveniment;
    }

    public void setId_gazda(int id_gazda) {
        this.id_gazda = id_gazda;
    }

    public void setId_invitat(int id_invitat) {
        this.id_invitat = id_invitat;
    }

    public void setRaspuns(boolean raspuns) {
        this.raspuns = raspuns;
    }

    public String getMesaj() {
        return mesaj;
    }

    public int getId_eveniment() {
        return id_eveniment;
    }

    public int getId_gazda() {
        return id_gazda;
    }

    public int getId_invitat() {
        return id_invitat;
    }

    public boolean isRaspuns() {
        return raspuns;
    }

    public Invitatii() {}

    public Invitatii(String mesaj, int id_eveniment, int id_gazda, int id_invitat, boolean raspuns) {
        this.mesaj = mesaj;
        this.id_eveniment = id_eveniment;
        this.id_gazda = id_gazda;
        this.id_invitat = id_invitat;
        this.raspuns = raspuns;
    }

    public String toString() {
        return mesaj + "," + String.valueOf(id_eveniment) + "," + String.valueOf(id_gazda) + "," + String.valueOf(id_invitat) + "," + raspuns;
    }

    /// Select invitatii
    public void select(Connection con) {

        try {
            ArrayList<Invitatii> invitatii = new ArrayList<>();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from invitatii");
            while (rs.next()) {
                Invitatii i = new Invitatii(rs.getString("mesaj"), rs.getInt("id_eveniment"), rs.getInt("id_gazda"), rs.getInt("id_invitat"), rs.getBoolean("raspuns"));
                invitatii.add(i);
            }

            for (Invitatii element : invitatii)
                System.out.println(element.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /// Update invitatii
    public int update(Connection con) {
        int i=0;
        try {
            PreparedStatement updateInvitatii = null;
            String updateString =
                    "update " + "proiect.invitatii " +
                            "set raspuns = ? where id_invitatie = ?";
            con.setAutoCommit(false);
            updateInvitatii = con.prepareStatement(updateString);
            updateInvitatii.setBoolean(1, this.raspuns);
            updateInvitatii.setInt(2, this.id_invitatie);
            i=updateInvitatii.executeUpdate();
            con.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return i;
    }

    ///Insert invitatii
    public int insert (Connection con){
        int i =0;
        try {
            PreparedStatement updateInvitatii = null;
            String updateString = "insert into invitatii(mesaj,id_eveniment, id_gazda, id_invitat) values (?,?,?,?)";
            con.setAutoCommit(false);
            updateInvitatii = con.prepareStatement(updateString);
            updateInvitatii.setString(1, this.mesaj);
            updateInvitatii.setInt(2, this.id_eveniment);
            updateInvitatii.setInt(3, this.id_gazda);
            updateInvitatii.setInt(4, this.id_invitat);
            i = updateInvitatii.executeUpdate();
            con.commit();
        }catch(Exception e){ System.out.println(e);}
        return i;
    }

    ///Delete invitatii
    public void delete(Connection con){
        try{
            PreparedStatement updateInvitatii = null;
            String updateString = "delete from invitatii where id_invitatie = ?";
            con.setAutoCommit(false);
            updateInvitatii = con.prepareStatement(updateString);
            updateInvitatii.setInt(1,10);
            updateInvitatii.executeUpdate();
            con.commit();
        }catch(Exception e){ System.out.println(e);}

    }
}
