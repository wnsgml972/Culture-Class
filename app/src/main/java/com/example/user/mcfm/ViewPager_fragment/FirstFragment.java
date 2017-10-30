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
import com.example.user.mcfm.Main.MainActivity;
import com.example.user.mcfm.R;
import com.example.user.mcfm.Util.Contact;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by Choiwongyun on 2017-08-20.
 */

public class FirstFragment extends Fragment {
    private ImageView first_Myprofile_Image;
    private TextView tuti_tutor;
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
        tuti_tutor = (TextView)view.findViewById(R.id.first_tuti_tutor_text);
        first_RecyclerView = (RecyclerView) view.findViewById(R.id.first_RecyclerView);

        if(MainActivity.flag==0){
            tuti_tutor.setText("매칭 가능한 맨티");
        }else{
            tuti_tutor.setText("매칭 가능한 맨토");
        }

        setRecyclerView();


        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Contact.SetProfilePhoto);
        getContext().registerReceiver(receiver, intentFilter);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void setRecyclerView(){
        first_recyclerView_items = new ArrayList<First_RecyclerView_Item>();

        first_recyclerView_items.add(new First_RecyclerView_Item("김영수","강남구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("최영호","강동구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("이영식","강서구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("최정웅","관악구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("김영길","광진구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("이영일","구로구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("김정수","금천구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("이정남","노원구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("정광수","도봉구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("한정수","동대문구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("김영철","동작구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("한성수","마포구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("정성호","서대문구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("이영자","서초구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("김지영","성동구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("최혜진","성북구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("정은주","송파구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("한선영","양천구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("서수빈","영등포구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("김지원","용산구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("정지은","은평구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("신현지","종로구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("김서영","중구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("민지원","중랑구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("김화자","강남구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("도영순","강동구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("조영미","강서구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("한지영","관악구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("조은영","광진구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("한아름","구로구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("추자현","금천구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("정준호","노원구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("조상현","도봉구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("한준영","동대문구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("서준혁","동작구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("도현준","마포구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("송승민","서대문구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("오명자","서초구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("김미영","성동구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("이자현","성북구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("박보람","송파구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("임예진","양천구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("임수진","영등포구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("한미영","용산구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("조경자","은평구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("조영희","종로구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("기현정","중구"));
        first_recyclerView_items.add(new First_RecyclerView_Item("조광수","중랑구"));


        first_recyclerView_adapter = new First_RecyclerView_Adapter(getContext(),first_recyclerView_items);
        first_RecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        first_RecyclerView.setAdapter(first_recyclerView_adapter);
    }
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(Contact.SetProfilePhoto)){
                String photo_intent = intent.getStringExtra("ph");
                Log.e("FIRST_FRAGMENT_DATA",photo_intent);
                Picasso.with(getContext()).load(Uri.fromFile(new File(photo_intent))).transform(new CropCircleTransformation()).into(first_Myprofile_Image);
            }
        }
    };
}
