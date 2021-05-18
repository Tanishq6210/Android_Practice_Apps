package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    ArrayList<Word> words = new ArrayList<>();
    private int colorId;
    private int musicId;

    public WordAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Word> objects, int colorId) {
        super(context, resource, objects);
        this.words = objects;
        this.colorId = colorId;
    }

    public WordAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Word> objects, int colorId, int musicId) {
        super(context, resource, objects);
        this.words = objects;
        this.colorId = colorId;
        this.musicId = musicId;
    }

    @Nullable
    @Override
    public Word getItem(int position) {
        return words.get(position);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        TextView text = convertView.findViewById(R.id.first_text);
        text.setText(getItem(position).getMiwokTranslation());
        TextView text2 = convertView.findViewById(R.id.second_text);
        text2.setText(getItem(position).getDefaultTranslation());

        LinearLayout view = (LinearLayout) convertView.findViewById(R.id.textContainer);
        //For adding colors for text views
        int color = ContextCompat.getColor(getContext(), colorId);
        view.setBackgroundColor(color);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        if (getItem(position).hasImage()) {
            imageView.setImageResource(getItem(position).getImageResourseId());
            imageView.setVisibility(View.VISIBLE);
        }
        else imageView.setVisibility(View.GONE);
        return convertView;
    }
}
