package com.example.studyhubtanishq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class AboutUs extends AppCompatActivity {
    //Initialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ArrayList<Contact> list = new ArrayList<>();
//        list.add(new Contact("Priyanka Chowdhury", "Designer Head\n Management Head", R.drawable.contact_photo));
        list.add(new Contact("Tanishq Tyagi", "Fresher", R.drawable.contact_photo));
        list.add(new Contact("Tanishq Tyagi", "Fresher", R.drawable.contact_photo));
        list.add(new Contact("Tanishq Tyagi", "Fresher", R.drawable.contact_photo));
        list.add(new Contact("Tanishq Tyagi", "Fresher", R.drawable.contact_photo));
        list.add(new Contact("Tanishq Tyagi", "Fresher", R.drawable.contact_photo));
        list.add(new Contact("Tanishq Tyagi", "Fresher", R.drawable.contact_photo));
        list.add(new Contact("Tanishq Tyagi", "Fresher", R.drawable.contact_photo));
        list.add(new Contact("Tanishq Tyagi", "Fresher", R.drawable.contact_photo));
        list.add(new Contact("Tanishq Tyagi", "Fresher", R.drawable.contact_photo));
        list.add(new Contact("Tanishq Tyagi", "Fresher", R.drawable.contact_photo));


        ListView gridView = (ListView) findViewById(R.id.View);
        ContactAdapter ad = new ContactAdapter(this, R.layout.contact_item, list);
        gridView.setAdapter(ad);
        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){
        //Open drawer
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        //Close drawer
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        //Redirect activity to home
        MainActivity.redirectActivity(this, MainActivity.class);
    }

    public void ClickCSE(View view){
        //Redirect activity to CSE
        MainActivity.redirectActivity(this, CSE.class);
    }

    public void ClickIT(View view){
        //Redirect activity to IT class
        MainActivity.redirectActivity(this, IT.class);
    }

    public void ClickAboutUs(View view){
        //Recreate activity
        recreate();
    }

//    public void ClickLogout(View view){
//        //Close app
//        MainActivity.logout(this);
//    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        MainActivity.closeDrawer(drawerLayout);
    }
}