package com.example.user.mcfm.Main;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.mcfm.R;
import com.example.user.mcfm.Util.Contact;
import com.example.user.mcfm.ViewPager_fragment.FirstFragment;
import com.example.user.mcfm.ViewPager_fragment.FourthFragment;
import com.example.user.mcfm.ViewPager_fragment.SecondFragment;
import com.example.user.mcfm.ViewPager_fragment.ThirdFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private TabLayout tabLayout;
    private TextView main_activity_setTitle;
    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;
    public static int flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permissionCheck();
        init();
        initViewPager();
        initStatusbar();
    }
    private void permissionCheck() {
        int permissionCheck_writeStorage = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheck_writeStorage == PackageManager.PERMISSION_DENIED ) { //권한 없음
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
    }
    private void init() {
        main_activity_setTitle = (TextView) findViewById(R.id.main_activity_setTitle);
        Intent intent = getIntent();
        flag = intent.getIntExtra("getFlag",1);
        Log.e("flag_check----",flag+"");
    }

    private void initStatusbar() {
        View view = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (view != null) {
                view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                getWindow().setStatusBarColor(Color.parseColor("#ffc0cb"));
            }
        } else getWindow().setStatusBarColor(Color.parseColor("#000"));
    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.ViewPager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.people));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_chat));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_calendar));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_settings_work_tool));
        viewPager.setOffscreenPageLimit(4);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        main_activity_setTitle.setText("매칭");
                        break;
                    case 1:
                        main_activity_setTitle.setText("채팅");
                        break;
                    case 2:
                        main_activity_setTitle.setText("달력");
                        break;
                    case 3:
                        main_activity_setTitle.setText("설정");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { //없으면 연결이 안됨
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                tab.getIcon().setColorFilter(getColor(R.color.color_Main), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getColor(R.color.color_Gray), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private class PagerAdapter extends FragmentStatePagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FirstFragment();
                case 1:
                    return new SecondFragment();
                case 2:
                    return new ThirdFragment();
                case 3:
                    return new FourthFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        Contact.mento_list.clear();

    }

    @Override
    public void onBackPressed() {


        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;
        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime) {
            super.onBackPressed();
        } else {
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(), "종료하시려면 한번더 눌러주세요", Toast.LENGTH_SHORT).show();
        }


    }
}
