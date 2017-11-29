package com.bolo1.oschina1.fragment.newsfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by 菠萝 on 2017/11/29.
 */

public  class BlogFragment extends NewsBaseFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onLoadData() {
        if(NewsBaseFragment.isLoadData=false){
            NewsBaseFragment.isLoadData=true;
            //加载网络

        }
    }




}
