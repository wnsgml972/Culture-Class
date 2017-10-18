package com.example.user.mcfm.Firebase_listener;

import android.util.Log;

import com.example.user.mcfm.Adapter_Item.ChatActivity_RecyclerView_Item;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by choi on 2017-10-18.
 */

public class Firebase_listener {
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(); //firebase 접속
    private DatabaseReference databaseReference = firebaseDatabase.getReference();  //firebase json tree 접근
    private DatabaseReference chat = firebaseDatabase.getReference("chat");
    private String name;
    public Firebase_listener(String name){
        this.name = name;
    }
    public String a(){
        databaseReference.child("chat").child(name).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ChatActivity_RecyclerView_Item item = dataSnapshot.getValue(ChatActivity_RecyclerView_Item.class);
                String a = item.getChat_content();
                Log.e("리스너 굳잡 ㅋ ",a);
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

        return "asd";
    }
}
