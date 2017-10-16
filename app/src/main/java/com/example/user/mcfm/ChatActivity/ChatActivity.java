package com.example.user.mcfm.ChatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.mcfm.Adapter.ChatActivity_RecyclerView_Adapter;
import com.example.user.mcfm.Adapter_Item.ChatActivity_RecyclerView_Item;
import com.example.user.mcfm.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Choiwongyun on 2017-10-07.
 */

public class ChatActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText editText;
    private Button button;
    private String getName;
    private RecyclerView chatActivity_recyclerView;
    private ChatActivity_RecyclerView_Adapter chatActivity_recyclerView_adapter;
    private List<ChatActivity_RecyclerView_Item> chatActivity_recyclerView_items;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(); //firebase 접속
    private DatabaseReference databaseReference = firebaseDatabase.getReference();  //firebase json tree 접근
    private DatabaseReference chat = firebaseDatabase.getReference("chat");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        InitStatusbar_and_Actionbar();
        init();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn:
                ChatActivity_RecyclerView_Item item = new ChatActivity_RecyclerView_Item(getName,editText.getText().toString());
                databaseReference.child("chat").child(getName).push().setValue(item);
                editText.setText("");
                break;
        }
    }


    private void init(){
        chatActivity_recyclerView_items = new ArrayList<ChatActivity_RecyclerView_Item>();
        chatActivity_recyclerView  = (RecyclerView)findViewById(R.id.chat_activity_RecyclerView);
        chatActivity_recyclerView_adapter = new ChatActivity_RecyclerView_Adapter(getApplicationContext(),chatActivity_recyclerView_items);
        chatActivity_recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        chatActivity_recyclerView.setAdapter(chatActivity_recyclerView_adapter);

        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.btn);
        button.setOnClickListener((View.OnClickListener) this);
        //Log.e("asd",databaseReference.);
        chat.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Log.e("asd",snapshot.child("chat").getChildren().iterator().toString());
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        databaseReference.child("chat").child(getName).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ChatActivity_RecyclerView_Item item = dataSnapshot.getValue(ChatActivity_RecyclerView_Item.class);
                chatActivity_recyclerView_items.add(item);
                chatActivity_recyclerView_adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



    private void InitStatusbar_and_Actionbar() {
        Intent intent = getIntent();
        getName = intent.getStringExtra("name");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getName);
        actionBar.setBackgroundDrawable(getDrawable(R.color.color_Main));
        actionBar.show();

        View view = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (view != null) {
                view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                getWindow().setStatusBarColor(getResources().getColor(R.color.color_Main));
            }
        } else getWindow().setStatusBarColor(Color.parseColor("#000"));
    }


}

