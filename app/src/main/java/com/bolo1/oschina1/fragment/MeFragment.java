package com.bolo1.oschina1.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bolo1.oschina1.util.UIUtils;
import com.bolo1.oschina1.view.LoadingPage;

/**
 * Created by 菠萝 on 2017/11/17.
 */

public class MeFragment extends BaseFragment {

    private String text;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        Log.d("tag", "创建了test");
        if (bundle != null) {
            text = bundle.getString("text");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(UIUtils.getContext());
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setTextColor(Color.YELLOW);
        textView.setTextSize(25);
        return textView;
    }


    @Override
    public View onCreateSuccessView() {
        return null;
    }

    @Override
    public LoadingPage.ResultState initData() {
        return LoadingPage.ResultState.STATE_ERROR;
    }
}
