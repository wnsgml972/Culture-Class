package com.example.user.mcfm.Coach_Page;

import android.util.Log;
import android.view.View;

import com.example.user.mcfm.R;

/**
 * Created by hscom-015 on 2017-10-21.
 */

public class Alpha {

    private View view;
    private int number;
    private int animation;

    public int getNumber() {
        return number;
    }

    public int getAnimation() {
        return animation;
    }

    public View getView() {
        return view;
    }

    public Alpha(View view, int number) {
        this.view = view;
        this.number = number;
        switch (number) {
            case 0:
                animation = R.anim.alpha;
                break;
            case 1:
                animation = R.anim.alpha1;
                break;
            case 2:
                animation = R.anim.alpha2;
                break;
            case 3:
                animation = R.anim.alpha3;
                break;
            case 4:
                animation = R.anim.alpha4;
                break;
            case 5:
                animation = R.anim.alpha5;
                break;
            case 6:
                animation = R.anim.alpha6;
                break;
        }
    }
    public Alpha(View view, int number, int count) {
        this.view = view;
        this.number = number;
        Log.e("button", "" + (number - count));
        switch (number - count) {
            case 0:
                animation = R.anim.btalpha;
                break;
            case 1:
                animation = R.anim.btalpha1;
                break;
            case 2:
                animation = R.anim.btalpha2;
                break;
            case 3:
                animation = R.anim.btalpha3;
                break;
        }
    }

    public void add() {

    }
}
