package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    ArrayList<Earthquake> earthquakes;
    public EarthquakeAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Earthquake> objects) {
        super(context, resource, objects);
        this.earthquakes = objects;
    }

    @Nullable
    @Override
    public Earthquake getItem(int position) {
        return earthquakes.get(position);
    }

    // To convert into proper date format like March 23, 2016
    private String formatDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyy");
        return dateFormat.format(date);
    }

    // To convert date object into proper time format like 8:55 AM
    private String formatTime(Date date){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(date);
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude){
        int magnitudeColor;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }
        return magnitudeColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        TextView textView;
        Earthquake currentEarthquake = getItem(position);
        //textView= (TextView) convertView.findViewById(R.id.mag);
        //textView.setText(currentEarthquake.getMagnitude());

        // For date and time
        // Date object to convert time in milliseconds to date and time format
        Date date = new Date(currentEarthquake.getTime());
        String formattedDate = formatDate(date);
        String formattedTime = formatTime(date);
        textView = (TextView) convertView.findViewById(R.id.date);
        textView.setText(formattedDate);
        textView = (TextView) convertView.findViewById(R.id.time);
        textView.setText(formattedTime);

        // Splitting place into 2 TextViews by using split function
        String location = currentEarthquake.getPlace();
        String offset = "";
        String primary = "";
        if(location.contains("of")) {
            String parts[] = location.split("of ");
            offset = parts[0] + "of";
            primary = parts[1];
        }else {
            offset = "Near the ";
            primary = location;
        }
        textView = (TextView) convertView.findViewById(R.id.offset);
        textView.setText(offset);
        textView = (TextView) convertView.findViewById(R.id.primary);
        textView.setText(primary);

        // Getting mag as Double
        double magnitude = currentEarthquake.getMagnitude();
        String formattedMag = formatMagnitude(magnitude);
        textView = (TextView) convertView.findViewById(R.id.mag);
        textView.setText(formattedMag);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        TextView magnitudeView = (TextView) convertView.findViewById(R.id.mag);
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);
        return convertView;
    }
}


