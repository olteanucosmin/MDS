package Clase;

import java.sql.Date;

public class AfisInv {
    private String gazda;
    private Date datainc;
    private String mesaj;
    private int id;

    public AfisInv() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public String getGazda() {
        return gazda;
    }

    public void setGazda(String gazda) {
        this.gazda = gazda;
    }

    public Date getDatainc() {
        return datainc;
    }

    public void setDatainc(Date datainc) {
        this.datainc = datainc;
    }
}
