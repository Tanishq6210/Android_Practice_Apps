package com.example.adapter;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;


public class TextAdapter extends ArrayAdapter<Text> {
    ArrayList<Text> texts = new ArrayList<>();
    private int musicId;

    public TextAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Text> objects) {
        super(context, resource, objects);
        this.texts = objects;
    }

    public TextAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Text> objects, int music) {
        super(context, resource, objects);
        this.texts = objects;
        this.musicId = music;
    }

    @Nullable
    @Override
    public Text getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        TextView text = convertView.findViewById(R.id.textView);
        text.setText(getItem(position).getText1());
        TextView text2 = convertView.findViewById(R.id.textView2);
        text2.setText(getItem(position).getText2());
        ImageView imageView = convertView.findViewById(R.id.imageView);
        imageView.setImageResource(getItem(position).getImageId());
        Text item = getItem(position);
        if(item.hasMusic()) {
            convertView.findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), getItem(position).getMusicId());
                    mediaPlayer.start();
                }
            });
            convertView.findViewById(R.id.play).setVisibility(View.VISIBLE);
        }else {
            convertView.findViewById(R.id.play).setVisibility(View.GONE);
        }
        return convertView;
    }
}
