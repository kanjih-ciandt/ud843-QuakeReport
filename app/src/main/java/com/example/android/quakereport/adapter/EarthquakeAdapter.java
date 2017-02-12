package com.example.android.quakereport.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.quakereport.R;
import com.example.android.quakereport.to.Earthquake;

import android.graphics.drawable.GradientDrawable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

/**
 * Created by kneto on 2/6/17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    SimpleDateFormat monthDateFormat = new SimpleDateFormat("MMM dd, yyyy");
    SimpleDateFormat timDateFormat = new SimpleDateFormat("h:mm a");
    DecimalFormat formatter = new DecimalFormat("0.0");



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
        TextView placeKm = (TextView) convertView.findViewById(R.id.list_place_km);
        TextView place = (TextView) convertView.findViewById(R.id.list_place);
        TextView date = (TextView) convertView.findViewById(R.id.list_date);
        TextView time = (TextView) convertView.findViewById(R.id.list_time);

        mag.setText(formatter.format(earthquake.getMagnitude()));
        String[] placeArray =  earthquake.getPlace().split("of");
        try {
            place.setText(placeArray[1]);
            placeKm.setText(placeArray[0] + "of");
        }catch(RuntimeException ex){
            place.setText(earthquake.getPlace());
        }

        date.setText(monthDateFormat.format(earthquake.getDate()));
        time.setText(timDateFormat.format(earthquake.getDate()));





        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return convertView;
    }

    private int getMagnitudeColor(double magnitude) {
        int colorResourceId;
        int magflood = (int) Math.floor(magnitude);
        switch (magflood){
            case 0:
            case 1:
                colorResourceId = R.color.magnitude1;
                break;
            case 2:
                colorResourceId = R.color.magnitude2;
                break;
            case 3:
                colorResourceId = R.color.magnitude3;
                break;
            case 4:
                colorResourceId = R.color.magnitude4;
                break;
            case 5:
                colorResourceId = R.color.magnitude5;
                break;
            case 6:
                colorResourceId = R.color.magnitude6;
                break;
            case 7:
                colorResourceId = R.color.magnitude7;
                break;
            case 8:
                colorResourceId = R.color.magnitude8;
                break;
            case 9:
                colorResourceId = R.color.magnitude9;
                break;
            default:
                colorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(),colorResourceId);
    }




}
