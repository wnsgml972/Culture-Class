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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

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


                break;
        }

    }
}
