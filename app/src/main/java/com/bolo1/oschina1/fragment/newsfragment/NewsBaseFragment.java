package com.bolo1.oschina1.fragment.newsfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bolo1.oschina1.fragment.BaseFragment;
import com.bolo1.oschina1.view.LoadingPage;

import java.util.HashMap;

/**
 * Created by 菠萝 on 2017/11/29.
 */

public abstract class NewsBaseFragment extends Fragment {
    private static int LOAD_SATE_ERROR = 0;
    private static int LOAD_SATE_SUCCEED = 1;
    private static int LOAD_SATE_EMPTY = 2;


    public static HashMap<Integer, NewsBaseFragment> hashMap = new HashMap<Integer, NewsBaseFragment>();
    private static NewsBaseFragment fragment;

    public static NewsBaseFragment getNewsFragment(int pos) {
        fragment = hashMap.get(pos);
        if (fragment == null) {
            switch (pos) {
                case 0:
                    fragment = new AdvisoryFragment();
                    break;
                case 1:
                    fragment = new HotSpotFragment();
                    break;
                case 2:
                    fragment = new BlogFragment();
                    break;
                case 3:
                    fragment = new RecommendFragment();
                    break;
            }
        }

        hashMap.put(pos, fragment);
        return fragment;
    }
    //子类初始化布局和请求网络


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (isLoadData) {
            onLoadData();
        }
    }

    //钩子
    public static boolean isLoadData = false;

    //加载数据
    public abstract void onLoadData();

    enum LoadRate {
        SUCCEED(LOAD_SATE_SUCCEED), ERROR(LOAD_SATE_ERROR), EMPTY(LOAD_SATE_EMPTY);

        private int load_state;

        LoadRate(int loadSateSucceed) {
            this.load_state = loadSateSucceed;
        }

        public int getLoadstate() {
            return load_state;
        }
    }

}
