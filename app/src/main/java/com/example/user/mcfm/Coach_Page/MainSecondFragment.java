package com.example.user.mcfm.Coach_Page;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.user.mcfm.R;

import java.util.Vector;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainSecondFragment extends Fragment {

    private Vector<Alpha> alphas = new Vector<Alpha>();
    private int flag = 0;
    private Vector<Animation> animations = new Vector<Animation>();
    private Animation.AnimationListener animationListener;
    int animationCount = 0;
    private Button button1;
    private Button button2;

    public MainSecondFragment() {
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        flag = 0;
        View view =inflater.inflate(R.layout.fragment_main_second, container, false);
        button1 = (Button)view.findViewById(R.id.fm_bt_2_1);
        button2 = (Button)view.findViewById(R.id.fm_bt_2_2);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFragment loginFragment = new LoginFragment();
                Bundle bundle = new Bundle(1);
                bundle.putInt("check",flag);
                loginFragment.setArguments(bundle);

                setFragment(loginFragment);
                button1.setEnabled(false);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignUpFragment());
                button2.setEnabled(false);
            }
        });
        initAnimation();
        alpaAdd(view.findViewById(R.id.fm_tv_2_1));
        alpaAdd(view.findViewById(R.id.fm_tv_2_2));
        alpaButtonAdd(button1);
        alpaButtonAdd(button2);
        startAnimation(flag);
        return view;
    }

    public void initAnimation() {
        flag = 0;
        animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.e("Flag", "" + flag);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                flag++;
                if(flag < alphas.size()) {
                    alphas.get(flag).getView().startAnimation(animations.get(flag));
                }
                else {
                    flag = flag - alphas.size();
                    Log.e("Flag", "init flag = " + flag);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };
    }

    public void startAnimation(int index) {
        alphas.get(index).getView().startAnimation(animations.get(index));
    }

    public void alpaAdd(View view) {
        animationCount++;
        Log.e("animationcount", "animationcount = " + animationCount);
        alphas.add(new Alpha(view, alphas.size()));
        animations.add(AnimationUtils.loadAnimation(getActivity().getApplicationContext(), alphas.get(alphas.size() - 1).getAnimation()));
        animations.get(alphas.size() - 1).setAnimationListener(animationListener);
    }

    public void alpaButtonAdd(View view) {
        alphas.add(new Alpha(view, alphas.size(), animationCount));
        animations.add(AnimationUtils.loadAnimation(getActivity().getApplicationContext(), alphas.get(alphas.size() - 1).getAnimation()));
        animations.get(alphas.size() - 1).setAnimationListener(animationListener);
    }

    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.Fragments, fragment);
        fragmentTransaction.commit();
    }

}
