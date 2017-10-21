package com.example.user.mcfm.ViewPager_fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.mcfm.Adapter.Second_RecyclerView_Adapter;
import com.example.user.mcfm.Adapter_Item.Second_RecyclerView_Item;
import com.example.user.mcfm.Interface.TestCallback;
import com.example.user.mcfm.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Choiwongyun on 2017-08-20.
 */

public class SecondFragment extends Fragment implements View.OnClickListener,TestCallback{
    private Second_RecyclerView_Adapter second_recyclerView_adapter;
    private List<Second_RecyclerView_Item> second_recyclerView_items;
    private RecyclerView second_RecyclerView;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(); //firebase 접속
    private DatabaseReference databaseReference = firebaseDatabase.getReference();  //firebase json tree 접근
    private DatabaseReference chat = firebaseDatabase.getReference("chat");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second,container,false);
        second_RecyclerView = (RecyclerView)view.findViewById(R.id.second_RecyclerView);
        setRecyclerView();


        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("asd");
        getActivity().registerReceiver(broadcastReceiver, intentFilter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    private void setRecyclerView(){
        second_recyclerView_items = new ArrayList<Second_RecyclerView_Item>();
        /*second_recyclerView_items.add(new Second_RecyclerView_Item("홍길동","성북구"));
        second_recyclerView_items.add(new Second_RecyclerView_Item("황진이","성동구"));
        second_recyclerView_items.add(new Second_RecyclerView_Item("어우동","도봉구"));*/

        second_recyclerView_adapter = new Second_RecyclerView_Adapter(getContext(),second_recyclerView_items);
        second_RecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        second_RecyclerView.setAdapter(second_recyclerView_adapter);
    }

    @Override
    public void onClick(View view) {


    }

    @Override
    public void test(String a) {

    }
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("asd")){
                String getName = intent.getStringExtra("name");
                Log.e("잘옴!",getName);

                second_recyclerView_items.add(new Second_RecyclerView_Item(getName,getName));
                second_recyclerView_adapter.notifyDataSetChanged();
            }
        }
    };

}
