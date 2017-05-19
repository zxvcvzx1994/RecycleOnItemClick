package com.example.kh.myapplication.VIew.View_Fragment.View_main;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.kh.myapplication.R;
import com.example.kh.myapplication.VIew.View_Fragment.View_Custom.Custom_View;

public class Main2Activity extends AppCompatActivity {
    private Custom_View custom_view;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        custom_view  = (Custom_View) findViewById(R.id.customView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            NavUtils.navigateUpFromSameTask(this);
        return super.onOptionsItemSelected(item);
    }
    public void Swapcolor(View view){
        if(view.getId()== R.id.btnXuly){
            custom_view.Swap_Color();
        }
    }
}
