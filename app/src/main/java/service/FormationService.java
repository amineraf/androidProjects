package service;

import java.util.List;

import data.FormationDAO;
import model.Formation;

/**
 * Created by arafla on 27/10/2015.
 */
public class FormationService {
    FormationDAO formationDAO=new FormationDAO();
    public List getAllFormations() {
        return formationDAO.getAllFormations();
    }

    public List getMyFormations() {
        return formationDAO.getMyFormations();
    }

    public Formation addFormation(Formation formation) {
        return null;
    }
}
