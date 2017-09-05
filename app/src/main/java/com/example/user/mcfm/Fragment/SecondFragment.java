package com.example.user.mcfm.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.user.mcfm.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Iterator;

import static android.R.id.list;

/**
 * Created by User on 2017-08-20.
 */

public class SecondFragment extends Fragment implements View.OnClickListener{

    private ListView listView;
    private EditText editText;
    private ImageButton imageButton;
    private ArrayAdapter arrayAdapter;
    private String name = "Guest";
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("message");
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.second,container,false);
        listView = (ListView) layout.findViewById(R.id.list);
        editText = (EditText)layout.findViewById(R.id.chatinput);
        imageButton = (ImageButton)layout.findViewById(R.id.chatinputBtn);
        imageButton.setOnClickListener((View.OnClickListener) getActivity().getApplicationContext());
        arrayAdapter = new ArrayAdapter<String>(layout.getContext(),android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        return layout;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.chatinputBtn:
                HashMap<String,Object> map = new HashMap<String,Object>();

                String key = reference.push().getKey();
                reference.updateChildren(map);

                DatabaseReference root = reference.child(key);

                HashMap<String,Object> objectHashMap = new HashMap<String,Object>();

                objectHashMap.put("name",name);
                objectHashMap.put("text",editText.getText().toString());

                root.updateChildren(objectHashMap);
                editText.setText("");
                reference.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) { //아이탬을 검색하거나 추가가있을때
                        chatConversation(dataSnapshot);
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) { //아이탬의 변화가 있을때 수신
                        chatConversation(dataSnapshot);
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
                break;
        }

    }
    private void chatConversation(DataSnapshot dataSnapshot){
        String chat_name,chat_msg;
        Iterator i = dataSnapshot.getChildren().iterator();

        while(i.hasNext()){
            chat_name = (String)((DataSnapshot)i.next()).getValue();
            chat_msg = (String)((DataSnapshot)i.next()).getValue();
            arrayAdapter.add(chat_name+" : "+chat_msg);
        }
        arrayAdapter.notifyDataSetChanged();
    }
}
