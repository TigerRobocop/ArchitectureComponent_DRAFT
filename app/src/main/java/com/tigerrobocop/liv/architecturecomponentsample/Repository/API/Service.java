package com.tigerrobocop.liv.architecturecomponentsample.Repository.API;

import com.tigerrobocop.liv.architecturecomponentsample.Model.XKCD;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Livia on 02/12/2017.
 */

public interface Service {
    /**
     * @GET the list of star wars films an HTTP GET request
     */
    @GET("info.0.json")
    Call<XKCD> getXKCD();
}
