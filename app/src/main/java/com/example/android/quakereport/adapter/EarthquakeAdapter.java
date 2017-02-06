package com.example.android.quakereport.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.quakereport.R;
import com.example.android.quakereport.to.Earthquake;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by kneto on 2/6/17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    SimpleDateFormat month_date = new SimpleDateFormat("MMM dd, yyyy");

    public EarthquakeAdapter(Context context, int resource, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake earthquake = getItem(position);
        TextView mag = (TextView) convertView.findViewById(R.id.list_mag);
        TextView place = (TextView) convertView.findViewById(R.id.list_place);
        TextView time = (TextView) convertView.findViewById(R.id.list_date);

        mag.setText( Double.valueOf(earthquake.getMagnitude()).toString());
        place.setText(earthquake.getPlace());

        time.setText(month_date.format(earthquake.getDate()));


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return convertView;
    }
}
