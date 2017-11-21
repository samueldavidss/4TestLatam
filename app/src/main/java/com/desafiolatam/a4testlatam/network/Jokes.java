package com.desafiolatam.a4testlatam.network;

import com.desafiolatam.a4testlatam.models.ChuckNorris;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Samuel on 18-11-2017.
 */

public interface Jokes {

    @GET("random")
    Call<ChuckNorris> jokesRamdon();
}
