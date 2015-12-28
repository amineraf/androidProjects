package fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.profileapp.arafla.profileapp.FormationActivity;
import com.profileapp.arafla.profileapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Formation;
import service.FormationService;


/**
 * Created by arafla on 29/10/2015.
 */
public class FormationFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    ArrayList<String> formationList;
    RequestQueue mVolleyRequestQueue;

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
        mVolleyRequestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        switch (mPage) {
            case 1:
                return listFormaton(inflater, container);

            case 2:
                return myFormations(inflater, container);
            case 3:
                return myFormations(inflater, container);
        }
        return null;
    }

    View listFormaton(LayoutInflater inflater, ViewGroup container) {
        SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("MyPrefs", 0);
        String jsonFormations = settings.getString("formationList", null);
        Gson gson = new Gson();
        RelativeLayout v = (RelativeLayout) inflater.inflate(R.layout.formation_list, container, false);
       formationList = gson.fromJson(jsonFormations, ArrayList.class);
        if (formationList != null) {
            ListView formationListView = (ListView) v.findViewById(R.id.allFormation);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                    R.layout.text_view_formation, formationList);
            formationListView.setAdapter(adapter);
            formationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position > 0) {
                        SharedPreferences sharedpreferences = getActivity().getApplicationContext().getSharedPreferences("MyPrefs", 0);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("formationCourante", formationList.get(position));
                        editor.commit();
                        Intent myIntent = new Intent(getActivity(), FormationActivity.class);
                        getActivity().startActivity(myIntent);
                    }
                }
            });
        }
        return v;
    }

    View myFormations(LayoutInflater inflater, ViewGroup container) {
        RelativeLayout v = (RelativeLayout) inflater.inflate(R.layout.mes_formations, container, false);
        ListView mListView = (ListView) v.findViewById(R.id.mesFormations);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                R.layout.text_view_formation, FormationService.getInstance().getMyFormations());
        mListView.setAdapter(adapter);
        return v;
    }
}