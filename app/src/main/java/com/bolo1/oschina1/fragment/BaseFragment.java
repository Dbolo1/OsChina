package com.bolo1.oschina1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bolo1.oschina1.util.UIUtils;
import com.bolo1.oschina1.view.LoadingPage;

/**
 * Created by 菠萝 on 2017/11/17.
 */

public abstract class BaseFragment extends Fragment {

    private LoadingPage loadingPage;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loadingPage = new LoadingPage(UIUtils.getContext()) {
            @Override
            public View onCreateSuccessView() {
                return BaseFragment.this.onCreateSuccessView();
            }

            @Override
            public ResultState onLoad() {
                return BaseFragment.this.initData();
            }
        };

        return loadingPage;
    }

    public abstract View onCreateSuccessView();
    public abstract LoadingPage.ResultState initData();
    public void loadData(){
        if(loadingPage!=null){
            loadingPage.onLoadData();
        }
    }
}
