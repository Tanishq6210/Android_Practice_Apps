package com.example.practiceset2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int raspberryPrice = 5;
        display("1 box: $" + raspberryPrice);
        display("2 boxes: $" + (raspberryPrice * 2));
        //display("3 boxes: $" + (raspberryPrice * 3));
    }

    public void display (String i) {
        TextView t = (TextView) findViewById(R.id.display_text_view);
        t.setText(""+i);
    }
}