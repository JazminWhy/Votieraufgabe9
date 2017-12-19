package com.example.jasmin.votieraufgabe9;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jasmin on 19/12/2017.
 */

public class AsyncClass extends AsyncTask<String, Integer, String> {

    String tw_name;
    TextView m_view;
    JSONArray json;
    JSONObject json_o;
    public AsyncClass(TextView view){
      m_view = view;

    }
    protected void onPostExecute(String s) {


        m_view.setText(s);
    }

    protected String doInBackground(String... urls) {
        String jsonString = "";
        for (String urlString : urls) {
            //desto mehr KOmmas beim Aufruf nach ...
            //desto öfter geht er durch die for each schleife
            try {
                URL url = new URL(urlString);
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

                String line = "";

                //jede readLine() fragt an, deswegen muss ich das in Variable sofort auffangen
                int counter = 0;
                int x = 10;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("line=" + line);
                        json  = new JSONArray(line);
                        if (json.length()<x){
                            x = json.length();
                        }
                        for(int i = 0; i < x; i++){
                        try {
                            json_o = json.getJSONObject(i);
                            counter ++;
                            System.out.println("counter + "+ counter);
                            jsonString = "\n" + "\n" + (counter) + ". Tweet:   " + json_o.getString("text") + jsonString;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }

                //.ready() geht hier jetzt nicht mehr
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return jsonString;
    }
}
