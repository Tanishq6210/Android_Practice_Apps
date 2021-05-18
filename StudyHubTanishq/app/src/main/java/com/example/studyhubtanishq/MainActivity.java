package com.example.studyhubtanishq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Initialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign value
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){
        //Open drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        //Close Drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //Close drawer layout
        //Check condition
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            //When drawer is open
            //Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        //Recreate activity
        recreate();
    }

    public void ClickCSE(View view){
        //Redirect activity to CSE
        redirectActivity(this, CSE.class);
    }
    public void ClickIT(View view){
        //Redirect activity to IT
        redirectActivity(this, IT.class);
    }

    public void ClickAboutUs(View view){
        //Redirect activity to about us
        redirectActivity(this, AboutUs.class);
    }

    public void ClickInsta(View view) {
        String url = "https://www.instagram.com/vinnovateit/?hl=en";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void ClickGithub(View view) {
        String url = "https://github.com/vinnovateit";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void ClickTwitter(View view) {
        String url = "https://twitter.com/v_innovate_it";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

//    public void ClickLogout(View view){
//        //Close app
//        logout(this);
//    }

//    public static void logout(Activity activity) {
//        //Initialize alert dialogue
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//        //Set title
//        builder.setTitle("Logout");
//        //Set message
//        builder.setMessage("Are you sure you want to logout ?");
//        //Positive yes button
//        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                activity.finishAffinity();
//                //Exit app
//                System.exit(0);
//            }
//        });
//        //Negative no button
//        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                //Dismiss dialog
//                dialog.dismiss();
//            }
//        });
//        //Show dialog
//        builder.show();
//
//    }

    public static void redirectActivity(Activity activity, Class aClass) {
        //Initialize intent
        Intent intent = new Intent(activity,aClass);
        //Set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start Activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        closeDrawer(drawerLayout);
    }


}