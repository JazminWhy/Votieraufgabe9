package com.example.jasmin.votieraufgabe9;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.net.URL;

public class Ausgabe extends AppCompatActivity {
Intent intent;
String url;
String tw_name;
TextView ausgabe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ausgabe);
        intent = getIntent();
        url = intent.getStringExtra("URL");
        ausgabe = findViewById(R.id.textView);
        AsyncClass cloud = new AsyncClass(ausgabe);
        cloud.execute(url);
    }


    public void clickReturn(View aView){

        startActivity(new Intent(this, screen_name.class));
    }
}
