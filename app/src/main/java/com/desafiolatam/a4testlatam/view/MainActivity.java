package com.desafiolatam.a4testlatam.view;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.desafiolatam.a4testlatam.R;
import com.desafiolatam.a4testlatam.models.ChuckNorris;
import com.desafiolatam.a4testlatam.network.GetJokes;

public class MainActivity extends AppCompatActivity {

    private Typeface weastText;
    private Typeface weastText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String fuente1 = "font/Clintwood.otf";
        this.weastText= Typeface.createFromAsset(getAssets(),fuente1);

       // String fuente2 = "font/WEST.ttf";
        //this.weastText2 = Typeface.createFromAsset(getAssets(),fuente2);

        TextView text2 = findViewById(R.id.categoriTxt);

        text2.setTypeface(weastText);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new BackgroundJokes().execute("category, icon_url, value, id, url");

            }
        });
    }

    private class BackgroundJokes extends GetJokes{

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {

            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.show();

        }

        @Override
        protected void onPostExecute(ChuckNorris chuckNorris) {
            if (chuckNorris != null){
                TextView Text1 = (TextView) findViewById( R.id.jokeEtx);
                Text1.setTypeface(weastText);
                Text1.setText(chuckNorris.getValue());
            }

            progressDialog.dismiss();
        }
    }

}
