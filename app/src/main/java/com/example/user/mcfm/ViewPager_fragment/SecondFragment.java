package com.example.user.mcfm.ViewPager_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.mcfm.Chat_item.ChatData;
import com.example.user.mcfm.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

/**
 * Created by User on 2017-08-20.
 */

public class SecondFragment extends Fragment implements View.OnClickListener{
    private Button btn;
    private TextView textView;
    private EditText editText;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference mConditionRef = mDatabase.child("test").child("aaa");
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (LinearLayout)inflater.inflate(R.layout.fragment_second,container,false);
        btn = (Button)view.findViewById(R.id.btn);
        textView = (TextView)view.findViewById(R.id.text111);
        editText = (EditText)view.findViewById(R.id.edit);
        btn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mConditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //String name = dataSnapshot.getValue(String.class);
                ChatData chatData = dataSnapshot.getValue(ChatData.class);
                textView.setText(chatData.getUsername()+" "+chatData.getMessage());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn:

                //Toast.makeText(getContext(),,Toast.LENGTH_SHORT).show();
                String chat = String.valueOf(editText.getText());
                ChatData chatData = new ChatData(new Random().nextInt(1000)+"",chat);
                mConditionRef.setValue(chatData);
                editText.setText("");
                break;
        }

    }
}
