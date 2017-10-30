package com.example.user.mcfm.Report;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.mcfm.Dialog.SubmitReportDialog;
import com.example.user.mcfm.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class TuteeReportActivity extends AppCompatActivity {
    private TextView date_text;
    private FloatingActionButton submit;
    private ImageButton exitbtn;
    private HashMap<Integer, String> tutorList;
    private Spinner tutorSpinner;
    private String tutorName;
    private EditText review;

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
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tutee_report);

        date_text = (TextView)findViewById(R.id.date_text);
        date_text.setText(getDateString());
        review = (EditText)findViewById(R.id.review);

        submit = (FloatingActionButton)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tutorName.equals("튜터 목록")) {
                    Log.i("yunjae", "submit버튼");
                    Toast.makeText(getApplication(), "튜터를 선택하지 않으셨습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(review.getText().toString().equals("")) {
                    Toast.makeText(getApplication(), "느낀점을 작성하지 않으셨습니다.", Toast.LENGTH_SHORT).show();
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

        tutorSpinner = (Spinner)findViewById(R.id.spinner_tutor_list);
        ArrayAdapter tutorAdapter = ArrayAdapter.createFromResource(this,
                R.array.Tutor_name, android.R.layout.simple_spinner_item);
        tutorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        tutorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("yunjae", "setOnItemSelectedListener()");
                tutorName = tutorSpinner.getSelectedItem().toString();
                Log.i("yunjae", tutorName);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        tutorSpinner.setAdapter(tutorAdapter);

    }

    public String getDateString()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
        String str_date = df.format(new Date());

        return str_date;
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
}


