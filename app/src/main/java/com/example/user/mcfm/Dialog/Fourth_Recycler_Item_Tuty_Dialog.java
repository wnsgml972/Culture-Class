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
import com.example.user.mcfm.Adapter.Fourth_RecyclerView_Dialog_Tuty_Adapter;
import com.example.user.mcfm.Adapter_Item.Fourth_RecyclerView_Dialog_Speaker_Item;
import com.example.user.mcfm.Adapter_Item.Fourth_RecyclerView_Dialog_Tuty_Item;
import com.example.user.mcfm.Adapter_Item.Fourth_RecyclerView_Item;
import com.example.user.mcfm.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by User on 2017-10-11.
 */

public class Fourth_Recycler_Item_Tuty_Dialog extends AppCompatActivity {

    private RecyclerView fourth_RecyclerView_Dialog;
    private Fourth_RecyclerView_Dialog_Tuty_Adapter fourth_recyclerView_dialog_tuty_adapter;
    private List<Fourth_RecyclerView_Dialog_Tuty_Item> fourth_recyclerView_items;

    private ImageButton imageButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);   //타이틀바 없애는코드
        setContentView(R.layout.fourth_recycler_item_tuty_dialog);
        setFinishOnTouchOutside(false);         //다이얼로그 테마로 다이얼로그를 띄울때 다른곳을 터치할시에 꺼지는것을 방지
        fourth_RecyclerView_Dialog = (RecyclerView)findViewById(R.id.fourth_RecyclerView_Dialog_Tuty);
        imageButton = (ImageButton)findViewById(R.id.fourth_tuty_dialog_exit_btn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fourth_Recycler_Item_Tuty_Dialog.this.finish();
            }
        });

        setRecyclerView();

    }

    private void setRecyclerView(){
        fourth_recyclerView_items = new ArrayList<Fourth_RecyclerView_Dialog_Tuty_Item>();

        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("도봉구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("노원구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("강서구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("김포구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("종로구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("성동구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("동대문구",false));


        fourth_recyclerView_dialog_tuty_adapter = new Fourth_RecyclerView_Dialog_Tuty_Adapter(getApplicationContext(),fourth_recyclerView_items);
        fourth_RecyclerView_Dialog.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        fourth_RecyclerView_Dialog.setAdapter(fourth_recyclerView_dialog_tuty_adapter);
    }
}













