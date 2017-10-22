package com.example.user.mcfm.Dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.user.mcfm.R;
import com.example.user.mcfm.Util.Contact;

/**
 * Created by User on 2017-10-11.
 */

public class First_Recycler_Item_Click_Dialog extends AppCompatActivity implements View.OnClickListener {
    private TextView name;
    private TextView ok, cancel;
    private TextView mentoType,mentoplace,mentoIntroduce;
    private String getName,getPlace;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);   //타이틀바 없애는코드
        setContentView(R.layout.first_recycler_item_click_dialog);
        setFinishOnTouchOutside(false);         //다이얼로그 테마로 다이얼로그를 띄울때 다른곳을 터치할시에 꺼지는것을 방지

        setInit();
    }

    private void setInit() {
        name = (TextView) findViewById(R.id.first_RecyclerView_item_Click_dialog_Name);
        ok = (TextView) findViewById(R.id.first_RecyclerView_item_Click_dialog_OK);
        cancel = (TextView) findViewById(R.id.first_RecyclerView_item_Click_dialog_CANCEL);
        mentoType = (TextView)findViewById(R.id.click_dialog_mentoType);
        mentoplace = (TextView)findViewById(R.id.click_dialog_place);
        mentoIntroduce = (TextView)findViewById(R.id.click_dialog_introduce);

        double randdomvalue = Math.random();
        int intValue = (int)(randdomvalue*2)+1;
        if(intValue ==1){
            mentoType.setText(Contact.mento_Type_one);
            mentoIntroduce.setText(Contact.mento_introduce_one);
        }else{
            mentoType.setText(Contact.mento_Type_two);
            mentoIntroduce.setText(Contact.mento_introduce_two);
        }

        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);

        Intent intent = getIntent();
        getName = intent.getStringExtra("name");
        name.setText(getName);
        getPlace = intent.getStringExtra("place");
        mentoplace.setText(getPlace);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.first_RecyclerView_item_Click_dialog_OK:
                finish();
                Intent intent = new Intent(this, First_Recycler_Item_Click_confirm_Dialog.class);
                intent.putExtra("name", getName);
                startActivity(intent);
                break;
            case R.id.first_RecyclerView_item_Click_dialog_CANCEL:
                finish();
                break;
        }
    }
}













