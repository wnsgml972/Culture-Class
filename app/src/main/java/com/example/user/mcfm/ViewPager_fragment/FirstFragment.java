package com.example.user.mcfm.ViewPager_fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.mcfm.Adapter.First_RecyclerView_Adapter;
import com.example.user.mcfm.Adapter_Item.First_RecyclerView_Item;
import com.example.user.mcfm.R;
import com.example.user.mcfm.Util.Contact;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Choiwongyun on 2017-08-20.
 */

public class FirstFragment extends Fragment {
    private Context context;
    private ImageView first_Myprofile_Image;
    private TextView first_Myprofile_Name;
    private RecyclerView first_RecyclerView;
    private First_RecyclerView_Adapter first_recyclerView_adapter;
    private List<First_RecyclerView_Item> first_recyclerView_items;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        first_Myprofile_Image = (ImageView) view.findViewById(R.id.first_Myprofile_Image);
        first_Myprofile_Name = (TextView) view.findViewById(R.id.first_Myprofile_Name);
        first_RecyclerView = (RecyclerView) view.findViewById(R.id.first_RecyclerView);
        setRecyclerView();


        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Contact.SetProfilePhoto);
        getActivity().registerReceiver(receiver, intentFilter);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void setRecyclerView(){
        first_recyclerView_items = new ArrayList<First_RecyclerView_Item>();

        first_recyclerView_items.add(new First_RecyclerView_Item("홍길동","성북구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("황진이","성동구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("어우동","도봉구"));

        first_recyclerView_adapter = new First_RecyclerView_Adapter(getContext(),first_recyclerView_items);
        first_RecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        first_RecyclerView.setAdapter(first_recyclerView_adapter);
    }
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(Contact.SetProfilePhoto)){
                String photo_intent = intent.getStringExtra("ph");
                Log.e("photo-----",photo_intent);
                Uri photo_uri = Uri.parse(photo_intent);
                Picasso.with(getContext()).load(photo_uri).fit().into(first_Myprofile_Image);
            }
        }
    };
}
