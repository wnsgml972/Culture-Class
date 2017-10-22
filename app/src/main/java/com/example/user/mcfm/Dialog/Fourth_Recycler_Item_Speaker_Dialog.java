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
import com.example.user.mcfm.Adapter.Fourth_RecyclerView_Dialog_Speaker_Adapter;
import com.example.user.mcfm.Adapter_Item.Fourth_RecyclerView_Dialog_Speaker_Item;
import com.example.user.mcfm.Adapter_Item.Fourth_RecyclerView_Item;
import com.example.user.mcfm.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by User on 2017-10-11.
 */

public class Fourth_Recycler_Item_Speaker_Dialog extends AppCompatActivity {

    private RecyclerView fourth_RecyclerView_Dialog;
    private Fourth_RecyclerView_Dialog_Speaker_Adapter fourth_recyclerView_dialog_speaker_adapter;
    private List<Fourth_RecyclerView_Dialog_Speaker_Item> fourth_recyclerView_items;

    private ImageButton imageButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);   //타이틀바 없애는코드
        setContentView(R.layout.fourth_recycler_item_speaker_dialog);
        setFinishOnTouchOutside(false);         //다이얼로그 테마로 다이얼로그를 띄울때 다른곳을 터치할시에 꺼지는것을 방지
        fourth_RecyclerView_Dialog = (RecyclerView)findViewById(R.id.fourth_RecyclerView_Dialog_speaker);
        imageButton = (ImageButton)findViewById(R.id.fourth_speaker_dialog_exit_btn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fourth_Recycler_Item_Speaker_Dialog.this.finish();
            }
        });

        setRecyclerView();

    }

    private void setRecyclerView(){
        fourth_recyclerView_items = new ArrayList<Fourth_RecyclerView_Dialog_Speaker_Item>();

        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Speaker_Item("1","새로 출시된 다문화 어플 1.0.0 버전 업데이트"));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Speaker_Item("2","키워드 알림이 추가된 1.0.1 버전 업데이트"));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Speaker_Item("3","새 옷을 입은 1.0.1 버전"));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Speaker_Item("4","보기 편해진 채팅목록, 1.0.1 버전"));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Speaker_Item("5","보안 정책 강화 및 1.0.1 버전 업데이트"));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Speaker_Item("6","이모티콘 관리가 더욱 쉬워진 1.0.2 버전 준비중"));

        fourth_recyclerView_dialog_speaker_adapter = new Fourth_RecyclerView_Dialog_Speaker_Adapter(getApplicationContext(),fourth_recyclerView_items);
        fourth_RecyclerView_Dialog.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        fourth_RecyclerView_Dialog.setAdapter(fourth_recyclerView_dialog_speaker_adapter);
    }
}













