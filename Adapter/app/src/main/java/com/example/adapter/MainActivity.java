package com.example.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Text> texts = new ArrayList<>();
        texts.add(new Text("Tanishq" , "Tyagi", R.drawable.ic_launcher_background, R.raw.number_three));
        texts.add(new Text("Priyanka", "Chowdhury", R.drawable.ic_launcher_background, R.raw.number_three));
        texts.add(new Text("Priyanka", "Tyagi", R.drawable.ic_launcher_background));

        ListView rootView = findViewById(R.id.rootView);
        TextAdapter ad = new TextAdapter(this, R.layout.list_items, texts);
        rootView.setAdapter(ad);
    }
}