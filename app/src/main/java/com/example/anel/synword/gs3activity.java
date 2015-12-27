package com.example.anel.synword;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

/**
 * Created by Anel on 14.12.2015.
 */
public class gs3activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gs_r3);
        getSupportActionBar().hide();
    }
    boolean btn1isclicked = false;
    boolean btn2isclicked = false;
    boolean btn3isclicked = false;
    boolean btn4isclicked = false;
    boolean btn5isclicked = false;
    boolean btn6isclicked = false;

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, gamemodeActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    int pressed = 0;

    public void onClick1 (View view){
        view.setBackgroundColor(Color.parseColor("#FF3798D9"));
        if (btn1isclicked == false) {
            pressed++;
            btn1isclicked = true;
        }
        if (pressed == 2) {
            showNextScreen(view);
        }
    }
    public void onClick2 (View view){
        view.setBackgroundColor(Color.parseColor("#FF3798D9"));
        if (btn2isclicked == false) {
            pressed++;
            btn2isclicked = true;
        }
        if (pressed == 2){
            showNextScreen(view);
        }

    }
    public void onClick3 (View view){
        view.setBackgroundColor(Color.parseColor("#FF3798D9"));
        if (btn3isclicked == false) {
            pressed++;
            btn3isclicked = true;
        }
        if (pressed == 2){
            showNextScreen(view);
        }

    }
    public void onClick4 (View view){
        view.setBackgroundColor(Color.parseColor("#FF3798D9"));
        if (btn4isclicked == false) {
            pressed++;
            btn4isclicked = true;
        }
        if (pressed == 2){
            showNextScreen(view);
        }

    }
    public void onClick5 (View view){
        view.setBackgroundColor(Color.parseColor("#FF3798D9"));
        if (btn5isclicked == false) {
            pressed++;
            btn5isclicked = true;
        }
        if (pressed == 2){
            showNextScreen(view);
        }

    }
    public void onClick6 (View view){
        view.setBackgroundColor(Color.parseColor("#FF3798D9"));
        if (btn6isclicked == false) {
            pressed++;
            btn6isclicked = true;
        }
        if (pressed == 2){
            showNextScreen(view);
        }

    }

    public void showNextScreen(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, gs4activity.class);
        startActivity(intent);
    }
}