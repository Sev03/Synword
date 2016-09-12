package bakkarbeit.SS16.code.loadscreens;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import bakkarbeit.SS16.code.gamescreens.gamescreenActivity;

/**
 * Created by Florian on 22.03.2016.
 */
public class loadscreenActivity extends ActionBarActivity {

    ArrayList<String> results = new ArrayList<String>();
    LoadscreenSub task = new LoadscreenSub();
    private ProgressBar spinner;
    private String sprache = "";


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(bakkarbeit.SS16.code.synword.R.layout.loadscreen);
        getSupportActionBar().hide();
        task.execute();
        Intent intent = getIntent();
        sprache = intent.getExtras().getString("sprache");
        spinner = (ProgressBar)findViewById(bakkarbeit.SS16.code.synword.R.id.progressBar1);
        spinner.setVisibility(View.VISIBLE);
    }

    public void goToNextScreenWhenFinished(){
        Intent intent = new Intent(this, gamescreenActivity.class);
        intent.putStringArrayListExtra("words", results);
        startActivity(intent);

    }

    public class LoadscreenSub extends AsyncTask<String, Void, String> {
        InputStream is;

        JSONObject json_data;
        String result = "";
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

        Exception exception;

        @Override
        protected String doInBackground(String... strings) {

            try{
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("");
                if (sprache.contains("DE")){
                    httppost = new HttpPost("http://synword.felf.io/words_de.php");
                }
                else if (sprache.contains("EN")) {
                    httppost = new HttpPost("http://synword.felf.io/words_en.php");
                }
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                is = entity.getContent();
            }catch(Exception e){
                Log.e("log_tag", "Fehler bei der http Verbindung " + e.toString());
            }

                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "n");
                    }
                    is.close();
                    result = sb.toString();
                } catch (Exception e) {
                    Log.e("log_tag", "Error converting result " + e.toString());
                }

            return result;
        }
        protected void onPostExecute(String result) {

            try{
                JSONArray jArray = new JSONArray(result);
                for(int i=0;i<jArray.length();i++){
                    json_data = jArray.getJSONObject(i);

                    // Hier werden Ankerword, Syn1, Syn2, NoSyn1, NoSyn2, NoSyn3, NoSyn4 in die ArrayList
                    // gespeichert
                    results.add((String) json_data.get("Ankerword") + " " + json_data.get("Syn1")
                            + " " + json_data.get("Syn2") + " " + json_data.get("NoSyn1")
                            + " " + json_data.get("NoSyn2") + " " + json_data.get("NoSyn3")
                            + " " + json_data.get("NoSyn4"));
                }
                goToNextScreenWhenFinished();

            }
            catch(JSONException e){
                Log.e("log_tag", "Error parsing data "+e.toString());
            }
        spinner.setVisibility(View.GONE);

        }
    }
}
