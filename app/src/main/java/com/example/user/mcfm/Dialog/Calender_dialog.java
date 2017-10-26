package com.example.user.mcfm.Dialog;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.mcfm.DB.DBManager;
import com.example.user.mcfm.R;

/**
 * Created by choi on 2017-10-26.
 */

public class Calender_dialog extends AppCompatActivity implements View.OnClickListener{
    private TextView title;
    private ImageView submit;
    private EditText content;
    private String getTitle;
    private String DB_NAME;
    private DBManager dbManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);   //타이틀바 없애는코드
        setContentView(R.layout.calender_dialog);
        setFinishOnTouchOutside(false);         //다이얼로그 테마로 다이얼로그를 띄울때 다른곳을 터치할시에 꺼지는것을 방지
        init();
    }
    private void init(){
        title = (TextView)findViewById(R.id.calender_dialog_Title);
        submit = (ImageView)findViewById(R.id.calender_dialog_submit);
        submit.setOnClickListener(this);
        content = (EditText)findViewById(R.id.calender_dialog_content);
        Intent intent = getIntent();
        getTitle = intent.getStringExtra("title");
        DB_NAME = intent.getStringExtra("DB_NAME");
        title.setText(getTitle);

        dbManager = new DBManager(getApplicationContext(),"Write",null,1);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.calender_dialog_submit:
                Log.e("CHECK_",DB_NAME);
                try {
                    SQLiteDatabase db = dbManager.getWritableDatabase();
                    db.execSQL("CREATE TABLE if not exists '" + DB_NAME + "' (content TEXT)");
                    Conte
                    db.insert("'"+DB_NAME+"'",null,)
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
                break;
        }
    }
}
