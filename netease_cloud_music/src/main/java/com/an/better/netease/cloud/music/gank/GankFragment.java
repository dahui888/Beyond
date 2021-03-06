package com.an.better.netease.cloud.music.gank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.an.better.netease.cloud.music.R;
import com.an.better.netease.cloud.music.gank.child.EverydayFragment;
import com.an.better.netease.cloud.music.gank.child.MusicHomeFragment;
import com.an.better.netease.cloud.music.gank.child.WelfareFragment;
import com.anbetter.beyond.adapter.FragmentAdapter;
import com.anbetter.log.MLog;

import java.util.ArrayList;

/**
 * Created by android_ls on 2018/1/26.
 */

public class GankFragment extends Fragment {

    private ArrayList<String> mTitleList;
    private ArrayList<Fragment> mFragments;

    private TabLayout tab_gank;
    private ViewPager vp_gank;
    FragmentAdapter myAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MLog.i("GankFragment--->onCreate");

        mTitleList = new ArrayList<>();
        mFragments = new ArrayList<>();

        mTitleList.add("百度音乐");
        mTitleList.add("Gank.io");
        mTitleList.add("Gank妹子");

        mFragments.add(new MusicHomeFragment());
        mFragments.add(new EverydayFragment());
        mFragments.add(new WelfareFragment());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gank, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MLog.i("GankFragment--->onViewCreated");

        tab_gank = view.findViewById(R.id.tab_gank);
        vp_gank = view.findViewById(R.id.vp_gank);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MLog.i("GankFragment--->onActivityCreated");

        // 注意使用的是：getChildFragmentManager
        myAdapter = new FragmentAdapter(getChildFragmentManager(), mFragments, mTitleList);
        vp_gank.setAdapter(myAdapter);
        vp_gank.setOffscreenPageLimit(2);

        tab_gank.setTabMode(TabLayout.MODE_FIXED);
        tab_gank.setupWithViewPager(vp_gank);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MLog.i("GankFragment--->onDestroyView");

    }

    @Override
    public void onDestroy() {
        if(mTitleList != null) {
            mTitleList.clear();
            mTitleList = null;
        }

        if(mFragments != null) {
            mFragments.clear();
            mFragments = null;
        }

        super.onDestroy();
        MLog.i("GankFragment--->onDestroy");
    }


}
