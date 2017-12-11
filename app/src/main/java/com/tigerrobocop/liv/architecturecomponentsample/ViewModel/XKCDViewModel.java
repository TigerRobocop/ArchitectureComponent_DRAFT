package com.tigerrobocop.liv.architecturecomponentsample.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.tigerrobocop.liv.architecturecomponentsample.Model.XKCD;
import com.tigerrobocop.liv.architecturecomponentsample.Repository.XKCDRepository;

/**
 * Created by Livia on 02/12/2017.
 */

public class XKCDViewModel extends ViewModel {

    private LiveData<XKCD> mXKCD;

    private XKCDRepository repo
            = new XKCDRepository();

    public void init() {

        if(mXKCD != null){
            return;
        }

        mXKCD = repo.getXKCD();
    }

    public LiveData<XKCD> getXKCD() {
        return this.mXKCD;
    }
}
