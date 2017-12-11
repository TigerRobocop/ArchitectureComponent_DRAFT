package com.tigerrobocop.liv.architecturecomponentsample.Repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;



import com.tigerrobocop.liv.architecturecomponentsample.Model.XKCD;
import com.tigerrobocop.liv.architecturecomponentsample.Repository.API.Service;
import com.tigerrobocop.liv.architecturecomponentsample.Repository.API.ServiceClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Livia on 02/12/2017.
 */

public class XKCDRepository {

    private Service webService = ServiceClient.getBuilderXKCDRetrofit().create(Service.class);

    public LiveData<XKCD> getXKCD() {

        final MutableLiveData<XKCD> data = new MutableLiveData<>();

        webService.getXKCD().enqueue(new Callback<XKCD>() {
            @Override
            public void onResponse(Call<XKCD> call, Response<XKCD> response) {
                Log.d(XKCDRepository.class.getSimpleName(), "onResponse:getXKCD");
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<XKCD> call, Throwable t) {
                Log.d(XKCDRepository.class.getSimpleName(), "onFailure:getXKCD");
            }
        });

        return data;
    }

}
