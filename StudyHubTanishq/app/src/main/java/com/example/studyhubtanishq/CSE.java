package com.example.studyhubtanishq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;

public class CSE extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_s_e);

        ArrayList<Course> list = new ArrayList<>();
        list.add(new Course("Data Structures And Algorithms", "ITE1004", 4, 8));
        list.add(new Course("Web\nTechnologies", "ITE1002", 3, 8));
        list.add(new Course("Network And Information Security", "ITE4001", 4, 8));
        list.add(new Course("Applied Linear Algebra", "MAT3004", 4, 8));
        list.add(new Course("Data Communication And Computer Networks", "ITE3001", 4, 8));
        list.add(new Course("Java\nProgramming", "CSE1007", 4, 8));
        list.add(new Course("Database\nManagement Systems", "ITE1003", 4, 8));
        list.add(new Course("Theory Of Computation", "ITE1006", 3, 8));
        list.add(new Course("Computer\nArchitecture And Organisation", "ITE2001", 3, 8));
        list.add(new Course("Digital Logic And Microprocessor", "ITE1001", 4, 8));
        list.add(new Course("Applications Of Differential And Difference Equations", "MAT2002", 4, 8));
        list.add(new Course("Software Engineering-principles And Practices", "ITE1005", 3, 8));
        list.add(new Course("Operating Systems", "ITE2002", 4, 8));
        list.add(new Course("Discrete Mathematics And Graph Theory", "ITE1004", 4, 8));

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
        GridView gridView = (GridView) findViewById(R.id.gridView);
        CourseAdapter ad = new CourseAdapter(this, R.layout.course_item, list);
        gridView.setAdapter(ad);
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
        //Recreate activity
        recreate();
    }

    public void ClickIT(View view){
        //Recreate activity
        MainActivity.redirectActivity(this, IT.class);
    }

    public void ClickAboutUs(View view){
        //Redirect activity to about us
        MainActivity.redirectActivity(this, AboutUs.class);
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