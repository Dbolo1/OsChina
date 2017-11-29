package com.bolo1.oschina1.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 菠萝 on 2017/11/15.
 */

public class TestFragment extends Fragment {

    private String text;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        String text=savedInstanceState.getString("text");
        Bundle bundle = getArguments();
        Log.d("tag","创建了test");
        if(bundle!=null){
            text = bundle.getString("text");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        TextView textView=new TextView(getActivity());
        textView.setText(text);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(22);
        textView.setTextColor(Color.RED);

        return textView;
    }
}
