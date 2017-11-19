package com.desafiolatam.a4testlatam.view;

import android.app.ProgressDialog;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
                TextView TextView = (TextView) findViewById( R.id.jokeEtx);
                TextView.setText(chuckNorris.getValue());
            }

            progressDialog.dismiss();
        }
    }

}
