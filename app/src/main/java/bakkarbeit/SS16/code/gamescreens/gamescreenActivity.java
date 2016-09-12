package bakkarbeit.SS16.code.gamescreens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import bakkarbeit.SS16.code.Points;
import bakkarbeit.SS16.code.gamemodeActivity;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Anel on 14.12.2015.
 */

public class gamescreenActivity extends ActionBarActivity {
    public int points;
    public int round;
    // Default Werte für die Buttons
    public String ankerword = "Angriff";
    public String syn1 = "offensive";
    public String syn2 = "attacke";
    public String nosyn1 = "attentat";
    public String nosyn2 = "unfall";
    public String nosyn3 = "schuss";
    public String nosyn4 = "hieb";
    ArrayList<String> wordlist = new ArrayList<String>();

    public Button b1;
    public Button b2;
    public Button b3;
    public Button b4;
    public Button b5;
    public Button b6;

    boolean btn1isclicked = false;
    boolean btn2isclicked = false;
    boolean btn3isclicked = false;
    boolean btn4isclicked = false;
    boolean btn5isclicked = false;
    boolean btn6isclicked = false;
    Points pointcounter = new Points();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(bakkarbeit.SS16.code.synword.R.layout.gamescreen);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        wordlist = intent.getStringArrayListExtra("words");
        fillInWords(wordlist);

        b1 = (Button) findViewById(bakkarbeit.SS16.code.synword.R.id.btnWord1);
        b2 = (Button) findViewById(bakkarbeit.SS16.code.synword.R.id.btnWord2);
        b3 = (Button) findViewById(bakkarbeit.SS16.code.synword.R.id.btnWord3);
        b4 = (Button) findViewById(bakkarbeit.SS16.code.synword.R.id.btnWord4);
        b5 = (Button) findViewById(bakkarbeit.SS16.code.synword.R.id.btnWord5);
        b6 = (Button) findViewById(bakkarbeit.SS16.code.synword.R.id.btnWord6);

        //stringarray mit den synonymen und nichtsynonymen
        String[] arr = {syn1, syn2, nosyn1, nosyn2, nosyn3, nosyn4};

        TextView test = (TextView) this.findViewById(bakkarbeit.SS16.code.synword.R.id.txtWord);
        test.setText(ankerword);
        //array für positionen
        int[] array = {0,1,2,3,4,5};
        //aufruf shufflefunktion
        ShuffleArray(array);
        b1.setText(arr[array[0]]);
        b2.setText(arr[array[1]]);
        b3.setText(arr[array[2]]);
        b4.setText(arr[array[3]]);
        b5.setText(arr[array[4]]);
        b6.setText(arr[array[5]]);
    }

    private void   fillInWords(ArrayList<String> results) {
        String firstrow = results.get(0);
        String[] wordsplit = firstrow.split("\\s+");
        
        this.ankerword = wordsplit[0];
        this.syn1 = wordsplit[1];
        this.syn2 = wordsplit[2];
        this.nosyn1 = wordsplit[3];
        this.nosyn2 = wordsplit[4];
        this.nosyn3 = wordsplit[5];
        this.nosyn4 = wordsplit[6];

    }

    private void ShuffleArray(int[] array)
    {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            if (index != i)
            {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == bakkarbeit.SS16.code.synword.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    int pressed = 0;

    public void onClick1 (View view){
        view.setBackgroundResource(bakkarbeit.SS16.code.synword.R.drawable.buttongreen);
        if (btn1isclicked == false) {
            pressed++;
            btn1isclicked = true;
        }
        if(b1.getText().toString()==syn1 || b1.getText().toString()==syn2) {
            pointcounter.setPointcounter(this.pointcounter.getPointcounter() + 5);
        }

            if (pressed == 2) {
            showNextScreen(view);
        }


    }
    public void onClick2 (View view){
        view.setBackgroundResource(bakkarbeit.SS16.code.synword.R.drawable.buttongreen);
        if (btn2isclicked == false) {
            pressed++;
            btn2isclicked = true;
        }

        if(b2.getText().toString()==syn1 || b2.getText().toString()==syn2) {
            pointcounter.setPointcounter(this.pointcounter.getPointcounter() + 5);
        }


            if (pressed == 2){
            showNextScreen(view);
        }



    }
    public void onClick3 (View view){
        view.setBackgroundResource(bakkarbeit.SS16.code.synword.R.drawable.buttongreen);
        if (btn3isclicked == false) {
            pressed++;
            btn3isclicked = true;

        }

        if(b3.getText().toString()==syn1 || b3.getText().toString()==syn2) {
            pointcounter.setPointcounter(this.pointcounter.getPointcounter() + 5);
        }

        if (pressed == 2){
            showNextScreen(view);
        }




    }
    public void onClick4 (View view){
        view.setBackgroundResource(bakkarbeit.SS16.code.synword.R.drawable.buttongreen);
        if (btn4isclicked == false) {
            pressed++;
            btn4isclicked = true;

        }

        if(b4.getText().toString()==syn1 || b4.getText().toString()==syn2) {
            pointcounter.setPointcounter(this.pointcounter.getPointcounter() + 5);
        }


            if (pressed == 2){
            showNextScreen(view);
        }




    }
    public void onClick5 (View view){
        view.setBackgroundResource(bakkarbeit.SS16.code.synword.R.drawable.buttongreen);
        if (btn5isclicked == false) {
            pressed++;
            btn5isclicked = true;

        }

        if(b5.getText().toString()==syn1 || b5.getText().toString()==syn2) {
            pointcounter.setPointcounter(this.pointcounter.getPointcounter() + 5);
        }


            if (pressed == 2){
            showNextScreen(view);
        }



    }
    public void onClick6 (View view){
        view.setBackgroundResource(bakkarbeit.SS16.code.synword.R.drawable.buttongreen);
        if (btn6isclicked == false) {
            pressed++;
            btn6isclicked = true;

        }

        if(b6.getText().toString()==syn1 || b6.getText().toString()==syn2) {
            pointcounter.setPointcounter(this.pointcounter.getPointcounter() + 5);
        }


            if (pressed == 2){
            showNextScreen(view);
        }
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, gamemodeActivity.class);
        startActivity(intent);
    }


    public void showNextScreen(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, gs2activity.class);
        intent.putExtra("message", pointcounter);
        intent.putStringArrayListExtra("words", wordlist);
        pointcounter.setRound(1);
        startActivity(intent);
        finish();
    }

}
