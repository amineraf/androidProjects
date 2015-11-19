package data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Formation;

/**
 * Created by arafla on 27/10/2015.
 */
public class FormationDAO {

    public List getAllFormations() {
        Date du = new Date();
        Date au = new Date();
        Formation formation1 = new Formation(du, au, "Formation Hybris", "Site Rabat");
        Formation formation2 = new Formation(du, au, "Drupal 7 pour developpeur", "Site Rabat");
        Formation formation3 = new Formation(du, au, "Fondamentaux de gestion de projet", "Site Oujda");
        Formation formation4 = new Formation(du, au, "Formation Spring", "Site Rabat");
        List listFormation=new ArrayList();
        listFormation.add(formation1);
        listFormation.add(formation2);
        listFormation.add(formation3);
        listFormation.add(formation4);
        return listFormation;
    }

    public List getMyFormations() {
        return null;
    }

    public Formation addFormation(Formation formation) {
        return null;
    }
}
