package com.example.user.mcfm.Dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.example.user.mcfm.Adapter.Fourth_RecyclerView_Dialog_Tuty_Adapter;
import com.example.user.mcfm.Adapter_Item.Fourth_RecyclerView_Dialog_Tuty_Item;
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


    private HashMap<String, String> tuty_data = new HashMap<String, String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);   //타이틀바 없애는코드
        setContentView(R.layout.fourth_recycler_item_tuty_dialog);
        setFinishOnTouchOutside(false);         //다이얼로그 테마로 다이얼로그를 띄울때 다른곳을 터치할시에 꺼지는것을 방지
        fourth_RecyclerView_Dialog = (RecyclerView)findViewById(R.id.fourth_RecyclerView_Dialog_Tuty);

        //set X Btn
        imageButton = (ImageButton)findViewById(R.id.fourth_tuty_dialog_exit_btn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //set Check Box Event
                tuty_data = Fourth_RecyclerView_Dialog_Tuty_Adapter.getHash();
                for(int i=0; i< fourth_recyclerView_items.size(); i++){
                    if(tuty_data.get(Integer.toString(i)) == null)
                        tuty_data.put(Integer.toString(i),"false");
                }
                for(int i=0; i< fourth_recyclerView_items.size(); i++){
                    Log.i("kkk",tuty_data.get(Integer.toString(i)));
                }


                //Finish
                Fourth_Recycler_Item_Tuty_Dialog.this.finish();
            }
        });


        setRecyclerView();


    }

    private void setRecyclerView(){
        fourth_recyclerView_items = new ArrayList<Fourth_RecyclerView_Dialog_Tuty_Item>();

        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("강남구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("강동구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("강북구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("강서구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("관악구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("광진구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("구로구",false));

        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("금천구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("노원구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("도봉구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("동대문구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("동작구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("마포구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("서대문구",false));

        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("서대문구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("서초구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("성동구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("성북구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("송파구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("양천구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("영등포구",false));

        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("용산구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("은평구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("종로구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("중구",false));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Dialog_Tuty_Item("중랑구",false));


        fourth_recyclerView_dialog_tuty_adapter = new Fourth_RecyclerView_Dialog_Tuty_Adapter(getApplicationContext(),fourth_recyclerView_items);
        fourth_RecyclerView_Dialog.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        fourth_RecyclerView_Dialog.setAdapter(fourth_recyclerView_dialog_tuty_adapter);
    }
}












