package model;

import java.util.Date;

/**
 * Created by arafla on 27/10/2015.
 */
public class Formation {
    public String getDesc() {
        return desc;
    }

    private Date fromationDu;
    private Date fromationAu;
    private String action;
    private String desc;
    private String lieu;
    private String type;

    public String getLieu() {
        return lieu;
    }

    public int getNombreParticipant() {
        return nombreParticipant;
    }

    public String getStatut() {
        return statut;
    }

    public Date getFromationDu() {
        return fromationDu;
    }

    public Date getFromationAu() {
        return fromationAu;
    }

    public String getAction() {
        return action;
    }

    private int nombreParticipant;
    private String statut;

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setNombreParticipant(int nombreParticipant) {
        this.nombreParticipant = nombreParticipant;
    }

    public Formation(Date fromationDu, Date fromationAu, String desc, String lieu) {
        this.fromationDu = fromationDu;
        this.fromationAu = fromationAu;
        this.desc = desc;
        this.lieu = lieu;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setFromationDu(Date fromationDu) {
        this.fromationDu = fromationDu;
    }

    public void setFromationAu(Date fromationAu) {
        this.fromationAu = fromationAu;
    }

    public void setAction(String action) {
        this.action = action;
    }


}
