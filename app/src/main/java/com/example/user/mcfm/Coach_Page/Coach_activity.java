package com.example.user.mcfm.Coach_Page;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.Window;

import com.example.user.mcfm.R;

/**
 * Created by choi on 2017-10-30.
 */

public class Coach_activity extends AppCompatActivity implements SignUpFragment.OnApplySelectedListener{
    private int flag;
    @Override
    public void onCatagoryApplySelected(int flag) {
        this.flag = flag;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_coach);

        setFragment(new MainFirstFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.Fragments, fragment);
        fragmentTransaction.commit();
    }

}
