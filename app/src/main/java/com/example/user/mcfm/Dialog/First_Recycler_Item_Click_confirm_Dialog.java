package com.example.user.mcfm.Dialog;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.user.mcfm.R;

/**
 * Created by User on 2017-10-11.
 */

public class First_Recycler_Item_Click_confirm_Dialog extends AppCompatActivity implements View.OnClickListener {
    private TextView matching,cancel;
    private String getName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);   //타이틀바 없애는코드
        setContentView(R.layout.first_recycler_item_click_comfirm_dialog);
        setFinishOnTouchOutside(false);         //다이얼로그 테마로 다이얼로그를 띄울때 다른곳을 터치할시에 꺼지는것을 방지

        Intent intent = getIntent();
        getName = intent.getStringExtra("name");

        matching = (TextView)findViewById(R.id.confirm_Matching);
        cancel = (TextView)findViewById(R.id.confirm_Cancel);
        matching.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.confirm_Matching:
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
                        builder.setSmallIcon(R.drawable.logo);
                        builder.setContentTitle("매칭 성공");
                        builder.setContentText("상대방이 매칭에 수락했습니다.");

                        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                        notificationManager.notify(1,builder.build());
                        Intent intent = new Intent("asd");
                        intent.putExtra("name",getName);
                        sendBroadcast(intent);
                    }
                },2000);
                finish();
                break;
            case R.id.confirm_Cancel:
                finish();
                break;
        }
    }
}