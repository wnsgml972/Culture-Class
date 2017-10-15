package com.example.user.mcfm.ChatActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.mcfm.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Choiwongyun on 2017-10-07.
 */

public class ChatActivity extends AppCompatActivity {
    private Button btn;
    private TextView textView;
    private EditText editText;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

/*  btn = (Button)findViewById(btn);
        textView = (TextView)findViewById(R.id.text111);
        editText = (EditText)findViewById(R.id.edit);
        btn.setOnClickListener(this);*/
 /*databaseReference.child("aaa").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ChatData chatData = dataSnapshot.getValue(ChatData.class);
                textView.setText(chatData.getUsername()+" "+chatData.getMessage());

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
        });*/
   /*switch(view.getId()){
            case btn:
                String chat = String.valueOf(editText.getText());
                ChatData chatData = new ChatData(new Random().nextInt(1000)+"",chat);
                databaseReference.child("aaa").push().setValue(chatData);
                //mConditionRef.setValue(chatData);
                editText.setText("");
                break;
        }*/
    }
}

