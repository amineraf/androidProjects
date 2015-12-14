package service;

import java.util.ArrayList;
import java.util.List;

import data.FormationDAO;
import model.Formation;

/**
 * Created by arafla on 27/10/2015.
 */
public class FormationService {
    FormationDAO formationDAO = new FormationDAO();

    public ArrayList<String> getAllFormations() {
        return formationDAO.getAllFormations();
    }

    public String ajoutFormation(Formation formation) {
        boolean statut = true;
        if (statut)
            return "ajout avec succes";
        else return "ajout avec succes";
    }

    public List getMyFormations() {
        return formationDAO.getMyFormations();
    }

    public Formation addFormation(Formation formation) {

        return null;
    }
}
