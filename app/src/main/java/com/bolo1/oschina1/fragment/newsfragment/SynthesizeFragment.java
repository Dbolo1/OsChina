package com.bolo1.oschina1.fragment.newsfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bolo1.oschina1.MainActivity;
import com.bolo1.oschina1.R;
import com.bolo1.oschina1.SynthesizeActivity;
import com.bolo1.oschina1.fragment.BaseFragment;
import com.bolo1.oschina1.fragment.DetailsFragment;
import com.bolo1.oschina1.util.LogUtils;
import com.bolo1.oschina1.util.UIUtils;
import com.bolo1.oschina1.view.LoadingPage;
import com.bolo1.oschina1.view.PagerTab;

import butterknife.ButterKnife;

/**
 * Created by 菠萝 on 2017/11/17.
 */

public class SynthesizeFragment extends BaseFragment {

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
        LogUtils.d("这一条没有被调用=======================1111111" + text);
        View inflate = inflater.inflate(R.layout.synthesize_layout, null);
        ViewPager vp_news = (ViewPager)inflate.findViewById(R.id.vp_news);
        PagerTab pt_news = (PagerTab) inflate.findViewById(R.id.pt_news);
        pt_news.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
               //加载Viewpage界面
                NewsBaseFragment fragment=NewsBaseFragment.getNewsFragment(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        vp_news.setAdapter(new NewsAdapter(getFragmentManager()));
        pt_news.setViewPager(vp_news);
        return inflate;
    }

    @Override
    public View onCreateSuccessView() {
        TextView textView = new TextView(UIUtils.getContext());
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setTextColor(Color.YELLOW);
        textView.setTextSize(25);
        LogUtils.d("text=======================1111111" + text);


        return textView;
    }

    @Override
    public LoadingPage.ResultState initData() {
        return LoadingPage.ResultState.STATE_SUCCESS;
    }


    private class NewsAdapter extends FragmentPagerAdapter {

        private final String[] news_tab;

        public NewsAdapter(FragmentManager fm) {
            super(fm);
            //初始化指示器
            news_tab = UIUtils.getStringArray(R.array.news_title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return news_tab[position];
        }

        @Override
        public Fragment getItem(int position) {
//            BaseFragment fragment = FragmentFactory.getFragment(SynthesizeActivity.hashMap.get(position));
//            DetailsFragment fragment  = new DetailsFragment(position);
            NewsBaseFragment fragment=NewsBaseFragment.getNewsFragment(position);
            return fragment;
        }

        @Override
        public int getCount() {
            return news_tab.length;
        }
    }


}
