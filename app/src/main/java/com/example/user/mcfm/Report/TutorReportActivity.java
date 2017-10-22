package com.example.user.mcfm.Report;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.mcfm.Dialog.SubmitReportDialog;
import com.example.user.mcfm.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

//import android.support.annotation.RequiresApi;

public class TutorReportActivity extends AppCompatActivity {

    private TextView date_text;
    private ImageView imageView;
    int REQEUST_OK = 101;
    private FloatingActionButton submit;
    private ImageButton exitbtn;
    private EditText week;
    private EditText tutor;
    private EditText group;
    private EditText tutee;
    private EditText active;


    @Override
    protected void onResume() {
        super.onResume();
        if(SubmitReportDialog.submit_check == true) {
            SubmitReportDialog.submit_check = false;
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);   //타이틀바 없애는코드
        setContentView(R.layout.activity_tutor_report);
        Calendar calendar = Calendar.getInstance();
        String timestr = calendar.getTime().toString();



        date_text = (TextView)findViewById(R.id.date_text);
        date_text.setText(getDateString());

        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQEUST_OK);
            }
        });

        week = (EditText)findViewById(R.id.week);
        tutor = (EditText)findViewById(R.id.tutor);
        group = (EditText)findViewById(R.id.group);
        tutee = (EditText)findViewById(R.id.tutee);
        active = (EditText)findViewById(R.id.active);


        submit = (FloatingActionButton)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(week.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "주차를 작성하지 않으셨습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(tutor.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "튜터를 작성하지 않으셨습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(group.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "소속을 작성하지 않으셨습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(tutee.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "튜티를 작성하지 않으셨습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(active.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "활동내용을 작성하지 않으셨습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), SubmitReportDialog.class);
                startActivity(intent);
            }
        });

        exitbtn = (ImageButton)findViewById(R.id.report_exit_btn);
        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initStatusbar();
    }
    private void initStatusbar(){
        View view = getWindow().getDecorView();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if(view!=null){
                view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                getWindow().setStatusBarColor(Color.parseColor("#ffc0cb"));
            }
        }else getWindow().setStatusBarColor(Color.parseColor("#000"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQEUST_OK) {
            if(resultCode== Activity.RESULT_OK) {
                try {
                    String picture_name = getImageNameToUri(data.getData());

                    Bitmap image_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                    imageView.setImageBitmap(image_bitmap);


                }catch(FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getImageNameToUri(Uri data)
    {
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(data, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();

        String imgPath = cursor.getString(column_index);
        String imgName = imgPath.substring(imgPath.lastIndexOf("/")+1);

        return imgName;
    }

    public String getDateString()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
        String str_date = df.format(new Date());

        return str_date;
    }

}