package com.bolo1.oschina1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 菠萝 on 2017/11/15.
 */

public class BaseActivity extends AppCompatActivity {
//    @InjectView(R.id.toolbar)
//    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.toolbar);
//        ButterKnife.inject(this);
////        toolbar.setNavigationIcon(R.drawable.);
//        setSupportActionBar(toolbar);
    }
}
