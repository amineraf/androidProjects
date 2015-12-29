package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.profileapp.arafla.profileapp.R;

import java.util.ArrayList;

/**
 * Created by arafla on 29/12/2015.
 */
public class FormationListAdapter extends BaseAdapter {
    private final Context mContext;
    private ArrayList<String> mFormationList;

    public FormationListAdapter(Context context, ArrayList<String> formationList) {
        mContext = context;
        mFormationList = formationList;
    }

    @Override
    public int getCount() {
        return mFormationList.size();
    }

    @Override
    public Object getItem(int position) {
        return mFormationList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView desc;
        ImageView participer;
        ImageView consulter;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.formation_element, parent, false);
            desc = (TextView) convertView.findViewById(R.id.descElement);
            participer = (ImageView) convertView.findViewById(R.id.participer);
            consulter = (ImageView) convertView.findViewById(R.id.consulter);
            convertView.setTag(new ViewHolder(desc, participer, consulter));
        } else {
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            desc = viewHolder.mDesc;
        }
        desc.setText(getItem(position).toString());
        return convertView;
    }

    static final class ViewHolder {
        final TextView mDesc;
        final ImageView mParticiper;
        final ImageView mConsulter;

        public ViewHolder(TextView desc, ImageView participer, ImageView consulter) {
            mDesc = desc;
            mParticiper = participer;
            mConsulter = consulter;
        }
    }
}
