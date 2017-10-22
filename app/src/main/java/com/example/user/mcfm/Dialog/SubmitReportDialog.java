package com.example.user.mcfm.Dialog;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.user.mcfm.R;
import com.example.user.mcfm.Report.TutorReportActivity;

public class SubmitReportDialog extends AppCompatActivity implements View.OnClickListener{

    private TextView yes;
    private TextView no;
    public static boolean submit_check = false;
    private TutorReportActivity tutorReportActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_report_submit_dialog);
        setFinishOnTouchOutside(false);

        yes = (TextView)findViewById(R.id.id_yes);
        no = (TextView)findViewById(R.id.no);

        yes.setOnClickListener(this);
        no.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.id_yes:
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
                        builder.setSmallIcon(R.drawable.chopaa);
                        builder.setContentTitle("전송 성공");
                        builder.setContentText("전송이 성공적으로 되었습니다.");
                        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                        notificationManager.notify(1,builder.build());
                    }
                },2000);
                submit_check = true;
                finish();
                break;
            case R.id.no:
                finish();
                break;
        }
    }

}