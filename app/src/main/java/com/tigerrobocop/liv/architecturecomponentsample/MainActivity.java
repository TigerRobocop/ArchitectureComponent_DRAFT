package com.tigerrobocop.liv.architecturecomponentsample;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.tigerrobocop.liv.architecturecomponentsample.Model.XKCD;
import com.tigerrobocop.liv.architecturecomponentsample.ViewModel.XKCDViewModel;

public class MainActivity extends AppCompatActivity  implements LifecycleOwner, LifecycleObserver {

    LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
    private XKCDViewModel viewModel;
   // private ListView lstFIlms;
    private TextView mTxt;
    private ImageView mImg;

    String img_alt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // mTxt = (TextView)findViewById(R.id.txt_url);
        mImg = (ImageView)findViewById(R.id.img_xkcd);

        viewModel = ViewModelProviders.of(this).get(XKCDViewModel.class);
        viewModel.init();

        subscribeUI(viewModel);
        getLifecycle().addObserver(this);

        mImg.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), img_alt, Toast.LENGTH_LONG);
                toast.show();
                return true;
            }
        });
    }

    private void subscribeUI(XKCDViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getXKCD().observe(this, new Observer<XKCD>() {
            @Override
            public void onChanged(@Nullable XKCD xkcd) {
                if (xkcd != null) {
                  //  mTxt.setText(xkcd.title);
                    Log.d(MainActivity.class.getSimpleName(), xkcd.title);
                    img_alt = xkcd.alt;

                    Picasso.with(getApplicationContext()).load(xkcd.img).into(mImg);

                    Toast toast = Toast.makeText(getApplicationContext(), xkcd.title, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroyLifecycle() {
        Log.d(MainActivity.class.getSimpleName(), "Lifecycle.Event.ON_DESTROY");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreateLifecycle() {
        Log.d(MainActivity.class.getSimpleName(), "Lifecycle.Event.ON_CREATE");
    }

}
