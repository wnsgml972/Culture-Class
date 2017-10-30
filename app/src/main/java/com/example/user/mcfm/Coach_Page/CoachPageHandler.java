package com.example.user.mcfm.Coach_Page;


import android.content.Context;
import android.os.Handler;
import android.os.Message;

/**
 * Created by hscom-015 on 2017-10-21.
 */

public class CoachPageHandler extends Handler {

    Context context;

    public CoachPageHandler(Context context) {
        this.context = context;
    }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    //setAnimation(findViewById(R.id.textView));
                    break;

                default:
                    break;
            }
        }
}
