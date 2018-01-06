package com.example.jasmin.votieraufgabe9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

public class screen_name extends AppCompatActivity {

    EditText screenName;
    String tw_name;
    Intent intent;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = new Intent(this, Ausgabe.class);
        setContentView(R.layout.activity_screen_name);
        screenName = findViewById(R.id.editText);




    }

    public void click(View aView){
        tw_name = screenName.getText().toString();
        try {
            tw_name = URLEncoder.encode(tw_name,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("Encoded" + tw_name);
        url = "http://webtechlecture.appspot.com/timeline?screenname=" + tw_name;

        intent.putExtra("URL", url);
        startActivity(intent);

    }
}
