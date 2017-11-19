package com.desafiolatam.a4testlatam.network;

import android.os.AsyncTask;

import com.desafiolatam.a4testlatam.models.ChuckNorris;

import java.io.IOException;

import retrofit2.Response;

/**
 * Created by Samuel on 18-11-2017.
 */

public class GetJokes extends AsyncTask<String,Void,ChuckNorris> {

    @Override
    protected ChuckNorris doInBackground(String... strings) {

        Jokes jokes = new Interceptor().aCommonGetInterceptor();
        retrofit2.Call<ChuckNorris> jokesRamdon = jokes.jokesRamdon();

        try {
            Response<ChuckNorris> response = jokesRamdon.execute();
            if (200 == response.code() && response.isSuccessful()){
                return response.body();
            }else{
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return  null;

        }

    }
}
