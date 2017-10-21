package com.example.user.mcfm.Dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.mcfm.Adapter.Fourth_RecyclerView_Adapter;
import com.example.user.mcfm.Adapter.Fourth_RecyclerView_Dialog_QNA_Adapter;
import com.example.user.mcfm.Adapter_Item.Fourth_RecyclerView_Dialog_QNA_Item;
import com.example.user.mcfm.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by User on 2017-10-11.
 */

public class Fourth_Recycler_Item_QNA_Dialog extends AppCompatActivity {

    private RecyclerView fourth_RecyclerView_Dialog;
    private Fourth_RecyclerView_Dialog_QNA_Adapter fourth_recyclerView_dialog_qna_adapter;
    private List<Fourth_RecyclerView_Dialog_QNA_Item> fourth_recyclerView_items;

    private ImageButton imageButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);   //타이틀바 없애는코드
        setContentView(R.layout.fourth_recycler_item_qna_dialog);
        setFinishOnTouchOutside(false);         //다이얼로그 테마로 다이얼로그를 띄울때 다른곳을 터치할시에 꺼지는것을 방지
        fourth_RecyclerView_Dialog = (RecyclerView)findViewById(R.id.fourth_RecyclerView_Dialog_qna);
        imageButton = (ImageButton)findViewById(R.id.fourth_qna_dialog_exit_btn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fourth_Recycler_Item_QNA_Dialog.this.finish();
            }
        });

        setRecyclerView();

    }

    private void setRecyclerView(){
        fourth_recyclerView_items = new ArrayList<Fourth_RecyclerView_Dialog_QNA_Item>();

        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_QNA_Item("1","단축키가 궁금해요."));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_QNA_Item("2","새소식은 어떤 기능인가요?"));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_QNA_Item("3","다문화 가정이란?"));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_QNA_Item("4","튜터가 되는 법은 무엇인가요?"));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_QNA_Item("5","좋은 튜터의 보고서 작성법"));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_QNA_Item("6","튜티가 되는 법은 무엇인가요?"));

        fourth_recyclerView_dialog_qna_adapter = new Fourth_RecyclerView_Dialog_QNA_Adapter(getApplicationContext(), fourth_recyclerView_items);
        fourth_RecyclerView_Dialog.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        fourth_RecyclerView_Dialog.setAdapter(fourth_recyclerView_dialog_qna_adapter);
    }
}













