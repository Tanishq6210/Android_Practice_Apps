package com.example.studyhubtanishq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {
    private ArrayList<Contact> list ;

    public ContactAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Contact> objects) {
        super(context, resource, objects);
        this.list = objects;
    }

    @Nullable
    @Override
    public Contact getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.contact_item, parent, false);
        Contact current = getItem(position);
        ImageView image = (ImageView) convertView.findViewById(R.id.contact__photo);
        image.setImageResource(current.getImageid());
        TextView name = (TextView) convertView.findViewById(R.id.contact_name);
        name.setText(String.format("%s", current.getName()));
        TextView post = (TextView) convertView.findViewById(R.id.contact_post);
        post.setText(String.format("%s", current.getPost()));
        return convertView;
    }
}
