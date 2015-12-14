package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.TextView;

import com.profileapp.arafla.profileapp.R;
import com.profileapp.arafla.profileapp.ResultatRecherche;

import java.util.ArrayList;

/**
 * Created by arafla on 02/12/2015.
 */

public class FormationAdapter extends BaseAdapter implements Filterable {
    private ResultatRecherche activity;
    private FormationFilter formationFilter;
    private ArrayList<String> formationList;
    private ArrayList<String> filteredFormationList;

    public FormationAdapter(ResultatRecherche activity, ArrayList<String> formationList) {
        this.activity = activity;
        this.formationList = formationList;
        this.filteredFormationList = formationList;
        getFilter();
    }

    @Override
    public int getCount() {
        return filteredFormationList.size();
    }


    @Override
    public Object getItem(int i) {
        return filteredFormationList.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.text_view_formation, parent, false);
        TextView resView = (TextView) convertView.findViewById(R.id.textResult);
        resView.setText(getItem(position).toString());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (formationFilter == null) {
            formationFilter = new FormationFilter();
        }

        return formationFilter;
    }

    private class FormationFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                ArrayList tempList = new ArrayList();
                for (String formation : formationList) {
                    if (formation.toLowerCase().contains(constraint.toString().toLowerCase())) {
                        tempList.add(formation);
                    }
                }
                filterResults.count = tempList.size();
                filterResults.values = tempList;
            } else {
                filterResults.count = formationList.size();
                filterResults.values = formationList;
            }

            return filterResults;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredFormationList = (ArrayList<String>) results.values;
            notifyDataSetChanged();
        }
    }
}