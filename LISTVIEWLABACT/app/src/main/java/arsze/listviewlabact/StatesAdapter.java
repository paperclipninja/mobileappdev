package arsze.listviewlabact;

/**
 * Created by Arianna on 4/15/2015.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Arianna on 4/15/2015.
 */

public class StatesAdapter extends ArrayAdapter<State> {
    public StatesAdapter(Context context, ArrayList<State> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        State state = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_state, parent, false);
        }
        // Lookup view for data population
        TextView tvState = (TextView) convertView.findViewById(R.id.tvState);
        TextView tvCapital = (TextView) convertView.findViewById(R.id.tvCapital);
        TextView tvNumber = (TextView) convertView.findViewById(R.id.tvnNumber);
        // Populate the data into the template view using the data object
        tvState.setText(state.stateName);
        tvCapital.setText(state.cityName);
        tvNumber.setText(state.temperature);
        // Return the completed view to render on screen

        return convertView;
    }
}