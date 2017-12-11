package com.tigerrobocop.liv.architecturecomponentsample.Repository.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by Livia on 02/12/2017.
 */

public class ServiceClient {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://xkcd.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Retrofit getBuilderXKCDRetrofit() {
        return retrofit;
    }
}
