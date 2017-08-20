package com.example.user.mcfm;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.user.mcfm.Fragment.FirstFragment;
import com.example.user.mcfm.Fragment.FourthFragment;
import com.example.user.mcfm.Fragment.SecondFragment;
import com.example.user.mcfm.Fragment.ThirdFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button people, chat, three, four;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInit();
        View view = getWindow().getDecorView();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if(view!=null){
                view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                getWindow().setStatusBarColor(Color.parseColor("#7a9a82"));
            }
        }
    }

    private void setInit() {
        people = (Button) findViewById(R.id.people);
        people.setOnClickListener(this);
        chat = (Button) findViewById(R.id.chat);
        chat.setOnClickListener(this);
        three = (Button) findViewById(R.id.three);
        three.setOnClickListener(this);
        four = (Button) findViewById(R.id.four);
        four.setOnClickListener(this);
        viewPager = (ViewPager)findViewById(R.id.ViewPager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.people:
                viewPager.setCurrentItem(0);
                break;
            case R.id.chat:
                viewPager.setCurrentItem(1);
                break;
            case R.id.three:
                viewPager.setCurrentItem(2);
                break;
            case R.id.four:
                viewPager.setCurrentItem(3);
                break;
        }
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
