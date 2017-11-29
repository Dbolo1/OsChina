package com.bolo1.oschina1;

import android.content.Context;

/**
 * Created by 菠萝 on 2017/11/27.
 */

public   enum MainTab {
    //五个指示栏的枚举


    ;
    private  int idx;
    private  int ResIcon;
    private  Class<?> clz;
    private int ResName;

    public int getResIcon() {
        return ResIcon;
    }

    public void setResIcon(int resIcon) {
        ResIcon = resIcon;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }

    public int getResName() {
        return ResName;
    }

    public void setResName(int resName) {
        ResName = resName;
    }

    private MainTab(int idx,int ResName, int ResIcon, Class<?> clz) {
        this.idx = idx;
        this.ResName = ResName;
        this.ResIcon = ResIcon;
        this.clz = clz;
    }


}
