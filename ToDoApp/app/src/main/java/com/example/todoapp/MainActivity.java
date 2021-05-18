package com.example.todoapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> list = new ArrayList<>();
    private String newTask = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add("Breakfast");

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.progress);
        Button button = (Button) findViewById(R.id.button);
        
        ListView listView = (ListView) findViewById(R.id.listView);
        CustomAdapter ad = new CustomAdapter(this, R.layout.list_items, list);
        listView.setAdapter(ad);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                list.remove(position);
                ad.notifyDataSetChanged();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicked :)", Toast.LENGTH_SHORT).show();
                EditText editText = relativeLayout.findViewById(R.id.newTask);
                editText.setText("");
                relativeLayout.setVisibility(View.VISIBLE);
            }
        });

        TextView toadd = relativeLayout.findViewById(R.id.add_button);
        TextView tocancel = relativeLayout.findViewById(R.id.cancel_button);
        toadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = relativeLayout.findViewById(R.id.newTask);
                newTask = String.valueOf(editText.getText());
                relativeLayout.setVisibility(View.GONE);
                list.add(newTask);
                hideKeyboard(MainActivity.this);
                ad.notifyDataSetChanged();
            }
        });

        tocancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setVisibility(View.GONE);
            }
        });

    }
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}