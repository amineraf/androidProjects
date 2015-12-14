package data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Formation;

/**
 * Created by arafla on 27/10/2015.
 */
public class FormationDAO {

    public ArrayList<String> getAllFormations() {
        Date du = new Date();
        Date au = new Date();
        Formation formation1 = new Formation(du, au, "Formation Hybris", "Site Rabat");
        Formation formation2 = new Formation(du, au, "Drupal 7 pour developpeur", "Site Rabat");
        Formation formation3 = new Formation(du, au, "Fondamentaux de gestion de projet", "Site Oujda");
        Formation formation4 = new Formation(du, au, "Formation Spring", "Site Rabat");
        Formation formation5 = new Formation(du, au, "Nouveautés hybris 5.3", "Site Rabat");
        Formation formation6 = new Formation(du, au, "Introduction to Adobe Experience Manager", "Site Rabat");
        Formation formation7 = new Formation(du, au, "Hybris synchronization", "Site Oujda");
        Formation formation8 = new Formation(du, au, "Hybris Data Hub.", "Site Rabat");
        Formation formation9 = new Formation(du, au, "Workshop sur le cloud computing", "Site Rabat");
        Formation formation10 = new Formation(du, au, "Formation autour de GitLab", "Site Rabat");
        Formation formation11 = new Formation(du, au, "Fondamentaux de gestion de projet", "Site Oujda");
        Formation formation12 = new Formation(du, au, "ICD Skills / Oj / Session#1", "Site Rabat");
        ArrayList<String> listFormation=new ArrayList();
        listFormation.add(formation1.getDesc());
        listFormation.add(formation2.getDesc());
        listFormation.add(formation3.getDesc());
        listFormation.add(formation4.getDesc());
        listFormation.add(formation5.getDesc());
        listFormation.add(formation6.getDesc());
        listFormation.add(formation7.getDesc());
        listFormation.add(formation8.getDesc());
        listFormation.add(formation9.getDesc());
        listFormation.add(formation10.getDesc());
        listFormation.add(formation11.getDesc());
        listFormation.add(formation12.getDesc());
        return listFormation;
    }

    public List getMyFormations() {
        Date du = new Date();
        Date au = new Date();
        Formation formation1 = new Formation(du, au, "Formation Hybris", "Site Rabat");
        Formation formation2 = new Formation(du, au, "Drupal 7 pour developpeur", "Site Rabat");
        Formation formation3 = new Formation(du, au, "Fondamentaux de gestion de projet", "Site Oujda");
        ArrayList<String> myFormation=new ArrayList();
        myFormation.add(formation1.getDesc());
        myFormation.add(formation2.getDesc());
        myFormation.add(formation3.getDesc());
        return myFormation;
    }

    public Formation addFormation(Formation formation) {
        return null;
    }
}
