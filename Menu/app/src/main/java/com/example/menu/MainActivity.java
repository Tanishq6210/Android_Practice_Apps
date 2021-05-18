package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view){
        TextView text1 = (TextView) findViewById(R.id.menu_item_1);
        Log.i("Menu.java", String.valueOf(text1.getText()));
        TextView text2 = (TextView) findViewById(R.id.menu_item_2);
        Log.i("Menu.java", String.valueOf(text2.getText()));
        TextView text3 = (TextView) findViewById(R.id.menu_item_3);
        Log.i("Menu.java", String.valueOf(text3.getText()));

    }
}