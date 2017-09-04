package com.example.user.mcfm;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.user.mcfm.Fragment.FirstFragment;
import com.example.user.mcfm.Fragment.FourthFragment;
import com.example.user.mcfm.Fragment.SecondFragment;
import com.example.user.mcfm.Fragment.ThirdFragment;

public class MainActivity extends AppCompatActivity{
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitViewPager();
        InitStatusbar();

    }
    private void InitStatusbar(){
        View view = getWindow().getDecorView();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if(view!=null){
                view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                getWindow().setStatusBarColor(Color.parseColor("#7a9a82"));
            }
        }else getWindow().setStatusBarColor(Color.parseColor("#000"));
    }
    private void InitViewPager() {
        viewPager = (ViewPager)findViewById(R.id.ViewPager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout = (TabLayout)findViewById(R.id.tab);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.people));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.chat));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.people));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.people));
        viewPager.setOffscreenPageLimit(4);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { //없으면 연결이 안됨
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void Init(){

    }
    private class PagerAdapter extends FragmentStatePagerAdapter{
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:return new FirstFragment();
                case 1:return new SecondFragment();
                case 2:return new ThirdFragment();
                case 3:return new FourthFragment();
            }return null;
        }
        @Override
        public int getCount() {
            return 4;
        }
    }
}
