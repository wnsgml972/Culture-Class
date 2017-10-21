package com.example.user.mcfm.Dialog;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.example.user.mcfm.R;

/**
 * Created by User on 2017-10-11.
 */

public class Fourth_Recycler_Item_I_Dialog extends AppCompatActivity {

    private ImageButton imageButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);   //타이틀바 없애는코드

        setContentView(R.layout.fourth_recycler_item_i_dialog);

        setFinishOnTouchOutside(false); //다이얼로그 테마로 다이얼로그를 띄울때 다른곳을 터치할시에 꺼지는것을 방지

        imageButton = (ImageButton)findViewById(R.id.fourth_i_dialog_exit_btn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fourth_Recycler_Item_I_Dialog.this.finish();
            }
        });
    }
}













