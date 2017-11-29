package com.bolo1.oschina1.fragment.newsfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bolo1.oschina1.util.UIUtils;

import java.util.ArrayList;

/**
 * Created by 菠萝 on 2017/11/29.
 */

public class AdvisoryFragment extends NewsBaseFragment {

    private ArrayList<String> strings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        strings = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            strings.add("这是一条假数据" + i);
        }
        ListView listView = new ListView(UIUtils.getContext());
        listView.setAdapter(new MyAdapter());
        return listView;
    }

    @Override
    public void onLoadData() {

    }


    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return strings.size();
        }

        @Override
        public Object getItem(int position) {
            return strings.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(UIUtils.getContext());
            textView.setText(strings.get(position));
            return textView;
        }
    }
}
