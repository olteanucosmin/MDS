package Clase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Client {
    private String parola;
    private String nume_institutie;
    private String nume_client;
    private String prenume_client;
    private String nr_tel;
    private String mail_inst;
    private String mail_pers;
    private String id_cont;
    private int id_client;

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_client() {
        return id_client;
    }

    public String toString() {
        return nume_institutie + "," + nume_client + "," + prenume_client + "," + nr_tel + "," + mail_inst + "," + mail_pers + "," + id_cont;
    }

    public Client (){}

    public Client(String par, String nume_inst, String nume_c, String prenume_c, String nr_t, String mail_i, String mail_p, String id_c, int id_cl) {
        parola=par;
        nume_institutie=nume_inst;
        nume_client=nume_c;
        prenume_client=prenume_c;
        nr_tel=nr_t;
        mail_inst=mail_i;
        mail_pers=mail_p;
        id_cont=id_c;
        id_client = id_cl;
    }

    public String getParola(){
        return parola;
    }

    public void setParola(String parola){
        this.parola=parola;
    }

    public String getNume_institutie(){
        return nume_institutie;
    }

    public void setNume_institutie(String nume_institutie){
        this.nume_institutie=nume_institutie;
    }

    public String getNume_client(){
        return nume_client;
    }

    public void setNume_client(String nume_client){
        this.nume_client=nume_client;
    }

    public String getPrenume_client(){
        return prenume_client;
    }

    public void setPrenume_client(String prenume_client){
        this.prenume_client=prenume_client;
    }

    public String getNr_tel(){
        return nr_tel;
    }

    public void setNr_tel(String nr_tel){
        this.nr_tel=nr_tel;
    }

    public String getMail_inst(){
        return mail_inst;
    }

    public void setMail_inst(String mail_inst){
        this.mail_inst=mail_inst;
    }

    public String getMail_pers(){
        return mail_pers;
    }

    public void setMail_pers(String mail_pers){
        this.mail_pers=mail_pers;
    }

    public String getId_cont(){
        return id_cont;
    }

    public void setId_cont(String id_cont){
        this.id_cont=id_cont;
    }

    /// Select client
    public ArrayList<Client> select (Connection con){

        try {
            ArrayList<Client> clienti = new ArrayList<>();
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Client");
            while (rs.next()) {
                Client c = new Client(rs.getString("parola"), rs.getString("nume_institutie"), rs.getString("nume_client"), rs.getString("prenume_client"), rs.getString("nr_tel"), rs.getString("mail_inst"), rs.getString("mail_pers"), rs.getString("id_cont"), rs.getInt("id_client"));
                clienti.add(c);
            }
            return clienti;
        }catch(Exception e){ System.out.println(e);}
        return null;
    }

    /// Update client
    public void update (Connection con, int opt1, int opt2, String mod, int modif){
        try {
            PreparedStatement updateClient = null;
            String updateString =
                    "update " + "proiect.Client " +
                            "set nume_institutie = ? where id_client = ?";
            con.setAutoCommit(false);
            updateClient = con.prepareStatement(updateString);
            updateClient.setString(opt1, mod);
            updateClient.setInt(opt2, modif);
            updateClient.executeUpdate();
            con.commit();
            }catch(Exception e){ System.out.println(e);}
    }

    ///Insert client
    public int insert (Connection con){
        int i = 0;
        try {
            PreparedStatement updateClient = null;
            String updateString = "insert into Client( parola, nume_institutie, nume_client, prenume_client, nr_tel, mail_inst, mail_pers,id_cont) values (?,?,?,?,?,?,?,?)";
            con.setAutoCommit(false);
            updateClient = con.prepareStatement(updateString);
            updateClient.setString(1, this.parola);
            updateClient.setString(2, this.nume_institutie);
            updateClient.setString(3, this.nume_client);
            updateClient.setString(4, this.prenume_client);
            updateClient.setString(5, this.nr_tel);
            updateClient.setString(6, this.mail_inst);
            updateClient.setString(7, this.mail_pers);
            updateClient.setString(8, this.id_cont);
            i = updateClient.executeUpdate();
            con.commit();
        }catch(Exception e){ System.out.println(e);}
        return i;
    }

    ///Delete client
    public void delete(Connection con){
        try{
            PreparedStatement updateClient = null;
            String updateString = "delete from client where id_cont = ?";
            con.setAutoCommit(false);
            updateClient = con.prepareStatement(updateString);
            updateClient.setString(1,this.id_cont);
            updateClient.executeUpdate();
            con.commit();
        }catch(Exception e){ System.out.println(e);}

    }

}
