package com.example.studyhubtanishq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends ArrayAdapter<Course> {
    public ArrayList<Course> courses;
    public CourseAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Course> objects) {
        super(context, resource, objects);
        this.courses = objects;
    }

    @Nullable
    @Override
    public Course getItem(int position) {
        return courses.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.course_item, parent, false);
        Course current = getItem(position);
        TextView name = (TextView) convertView.findViewById(R.id.course_name);
        name.setText(current.getName());
        TextView code = (TextView) convertView.findViewById(R.id.course_code);
        code.setText(String.format("Code : %s", current.getCode()));
        TextView  credits= (TextView) convertView.findViewById(R.id.course_credits);
        credits.setText(String.format("Credits : %s", String.valueOf(current.getCredits())));
        TextView modules = (TextView) convertView.findViewById(R.id.course_modules);
        modules.setText(String.format("Modules : %s", String.valueOf(current.getModules())));
        return convertView;
    }
}
