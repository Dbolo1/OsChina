package com.bolo1.oschina1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.bolo1.oschina1.fragment.BaseFragment;
import com.bolo1.oschina1.fragment.DynamicFragment;
import com.bolo1.oschina1.fragment.FindFragment;
import com.bolo1.oschina1.fragment.FragmentFactory;
import com.bolo1.oschina1.fragment.MeFragment;
import com.bolo1.oschina1.fragment.newsfragment.SynthesizeFragment;
import com.bolo1.oschina1.util.LogUtils;

import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 菠萝 on 2017/11/15.
 */

public class SynthesizeActivity extends BaseActivity {

    private FrameLayout fl_synthesize;
    private FragmentTabHost fth_tab_host;
    public static String ALL = "all";
    public static String TEST = "test";
    public static String FIND = "find";
    public static String ME = "me";
   public static HashMap<Integer,String> hashMap = new HashMap<Integer,String>();

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.im_tab_icon)
    ImageView im_tab_icon;
    @InjectView(R.id.tv_im_tab_name)
    TextView tv_im_tab_name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.synthesize_activity);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_drawer);

        hashMap.put(0,ALL);
        hashMap.put(1,TEST);
        hashMap.put(2,FIND);
        hashMap.put(3,ME);

        initView();
        initData();
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);//加载menu文件到布局
        return true;
    }

    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //Toolbar 必须在onCreate()之后设置标题文本，否则默认标签将覆盖我们的设置
        if (toolbar != null) {
            toolbar.setTitle("开源中国");
        }
    }

    private void initView() {
        fl_synthesize = (FrameLayout) findViewById(R.id.fl_synthesize);
        fth_tab_host = (FragmentTabHost) findViewById(R.id.fth_tab_host);

    }



    private void initData() {
        //将tab_host与fragment绑定
        fth_tab_host.setup(this, getSupportFragmentManager(), R.id.fl_synthesize);
        //创建tabspce
        final TabHost.TabSpec tabSpe = fth_tab_host.newTabSpec(ALL);
        //设置指示文字
        tabSpe.setIndicator(composeLayout("综合", R.drawable.bg_tab_news));//封装这一步
        Bundle bundle = new Bundle();
        bundle.putString("text", "综合界面");
        fth_tab_host.addTab(tabSpe, SynthesizeFragment.class, bundle);
//        LogUtils.d(" FragmentFactory.getFragment(1).getClass()"+ FragmentFactory.getFragment(1).getClass());
        TabHost.TabSpec tabSpe1 = fth_tab_host.newTabSpec(TEST);
        tabSpe1.setIndicator(composeLayout("动弹", R.drawable.bg_tab_tweet));
        Bundle bundle1 = new Bundle();
        bundle1.putString("text", "动弹界面");
        fth_tab_host.addTab(tabSpe1, DynamicFragment.class, bundle1);

        //功能
//        //这个弹出窗口
//        TabHost.TabSpec tabSpe2 = fth_tab_host.newTabSpec("me");
//        tabSpe2.setIndicator(composeLayout("我",R.mipmap.widget_bar_me_over));
//        Bundle bundle2 = new Bundle();
//        bundle2.putString("text", "我");
//        fth_tab_host.addTab(tabSpe2, FragmentFactory.getFragment(2).getClass(), bundle2);

        //发现
        TabHost.TabSpec tabSpe3 = fth_tab_host.newTabSpec(FIND);
        tabSpe3.setIndicator(composeLayout("发现", R.drawable.bg_tab_explore));
        Bundle bundle3 = new Bundle();
        bundle3.putString("text", "发现界面");
        fth_tab_host.addTab(tabSpe3, FindFragment.class, bundle3);
        //我

        TabHost.TabSpec tabSpe4 = fth_tab_host.newTabSpec(ME);
        tabSpe4.setIndicator(composeLayout("我", R.drawable.bg_tab_me));
        Bundle bundle4 = new Bundle();
        bundle4.putString("text", "我");
        fth_tab_host.addTab(tabSpe4, MeFragment.class, bundle4);
        fth_tab_host.getTabWidget().setDividerDrawable(android.R.color.transparent);


        //替换fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        int count = fth_tab_host.getChildCount();
        LogUtils.d("子控件总数..............." + count);

        for (int i = 0; i < hashMap.size(); i++) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fl_synthesize, FragmentFactory.getFragment(hashMap.get(i)))
                    .commitAllowingStateLoss();//防止崩溃
        }

        fth_tab_host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                LogUtils.d("当前的id是:" + tabId);
                fth_tab_host.getCurrentTab();

                BaseFragment fragment = FragmentFactory.getFragment(tabId);
                fragment.loadData();
            }
        });

        fth_tab_host.setCurrentTab(0);
    }

    public View composeLayout(String text, int id) {
        LinearLayout linearLayout = new LinearLayout(this);
//        linearLayout.setLayoutParams(new LinearLayoutCompat.LayoutParams
//                (LinearLayoutCompat.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        //创建图片的布局
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(id);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int Left = (linearLayout.getMeasuredWidth() - imageView.getMeasuredWidth()) / 2;
        int Top = (linearLayout.getMeasuredHeight() - imageView.getMeasuredHeight()) / 2;
        LogUtils.d("Left>>" + Left + "Top" + Top);
        params.setMargins(Left, Top, Left, Top);
        linearLayout.addView(imageView, params);
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(16);
        linearLayout.addView(textView, new LinearLayoutCompat.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        return linearLayout;
    }

    public FragmentManager getFragment() {
        return getSupportFragmentManager();
    }

}
