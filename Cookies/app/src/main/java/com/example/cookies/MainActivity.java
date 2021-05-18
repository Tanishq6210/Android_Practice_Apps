package com.example.cookies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * @param v
     */
    public void eatCookie(View v){
        displayImage();
        displayText();
    }

    private void displayImage(){
        ImageView image = (ImageView) findViewById(R.id.image_before);
        image.setImageResource(R.drawable.after_cookie);
    }

    private void displayText(){
        TextView textview = (TextView) findViewById(R.id.text);
        textview.setText("I'm so full");
    }
}