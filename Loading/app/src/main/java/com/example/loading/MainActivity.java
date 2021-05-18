package com.example.loading;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //Initialize Variable
    Button btStart;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign Variable
        btStart = findViewById(R.id.bt_start);

        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize Progress Dialogue
                progressDialog = new ProgressDialog(MainActivity.this);
                // Show Dialog
                progressDialog.show();
                //Set content
                progressDialog.setContentView(R.layout.progress_dialog);
                // Set Transparent Background
                progressDialog.getWindow().setBackgroundDrawableResource(
                        android.R.color.transparent
                );
            }
        });
    }

    void create(int main){
        System.out.println("Is everything going good.");
    }
    @Override
    public void onBackPressed() {
        //Dismiss Progress Dialog
        progressDialog.dismiss();
    }
}