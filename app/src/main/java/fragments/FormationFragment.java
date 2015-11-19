package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.profileapp.arafla.profileapp.R;

import java.util.List;

import model.Formation;
import service.FormationService;


/**
 * Created by arafla on 29/10/2015.
 */
public class FormationFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private LinearLayout formationButtons;
    private int mPage;
    FormationService formationService = new FormationService();
    List<Formation> formationList = formationService.getAllFormations();

    public static FormationFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FormationFragment fragment = new FormationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        switch (mPage) {
            case 1:
                return newFormation(inflater, container);
            case 2:
                return listFormaton(inflater, container);
            case 3:
                return myFormations(inflater, container);
        }
        return formationButtons;
    }


    View newFormation(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.nouvelle_formation, container, false);

    }

    View listFormaton(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.mes_formations, container, false);
    }

    View myFormations(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.formation_list, container, false);
    }
}