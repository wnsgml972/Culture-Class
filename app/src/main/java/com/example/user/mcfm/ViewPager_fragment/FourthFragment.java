package com.example.user.mcfm.ViewPager_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.user.mcfm.R;

/**
 * Created by Choiwongyun on 2017-08-20.
 */

public class FourthFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (LinearLayout) inflater.inflate(R.layout.fragment_fourth,container,false);

        return view;
    }

}

