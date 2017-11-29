package com.bolo1.oschina1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bolo1.oschina1.util.UIUtils;

import org.w3c.dom.Text;

/**
 * Created by 菠萝 on 2017/11/29.
 */

public  class DetailsFragment extends Fragment {

    private  int pos;
    private TextView textView;
    String[] str ={"1111","2222","3333","4444"};
    public DetailsFragment(int pos){
        this.pos = pos;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(UIUtils.getContext());
    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
////        super.onViewCreated(view, savedInstanceState);
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        textView.setText(str[pos]);
        return textView;
    }

}
