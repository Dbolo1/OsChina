package com.bolo1.oschina1.fragment;

import com.bolo1.oschina1.fragment.newsfragment.SynthesizeFragment;
import com.bolo1.oschina1.util.LogUtils;

import java.util.HashMap;

/**
 * Created by 菠萝 on 2017/11/17.
 */

public class FragmentFactory {
    private static HashMap<String, BaseFragment> fragmentHashMap = new HashMap<String, BaseFragment>();
    public static  String ALL = "all";
    public static  String TEST = "test";
    public static  String FIND = "find";
    public static  String ME = "me";

    public static BaseFragment getFragment(String pos) {
        //先取出对应的fragment 如果没有则创建
        LogUtils.d("索引=============="+pos);
        BaseFragment fragment = fragmentHashMap.get(pos);
        if (fragment == null) {
            switch (pos) {
                case "all":
                    fragment = new SynthesizeFragment();
                    break;
                case "test":
                    fragment = new DynamicFragment();
                    break;
//                case 2:
//                    break;
                case "find":
                    fragment = new FindFragment();
                    break;
                case "me":
                    fragment = new MeFragment();
                    break;
                default:
                    break;
            }
            fragmentHashMap.put(pos, fragment);
        }
        return fragment;
    }
}
