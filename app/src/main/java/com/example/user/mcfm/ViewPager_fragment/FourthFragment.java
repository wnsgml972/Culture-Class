package com.example.user.mcfm.ViewPager_fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.mcfm.Adapter.Fourth_RecyclerView_Adapter;
import com.example.user.mcfm.Adapter_Item.Fourth_RecyclerView_Item;
import com.example.user.mcfm.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Choiwongyun on 2017-08-20.
 */

public class FourthFragment extends Fragment {

/*    private ImageView fourth_Myprofile_Image;
    private TextView fourth_Myprofile_Name;*/
    private RecyclerView fourth_RecyclerView;
    private Fourth_RecyclerView_Adapter fourth_recyclerView_adapter;
    private List<Fourth_RecyclerView_Item> fourth_recyclerView_items;
    private ImageView fourth_item_image;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (LinearLayout) inflater.inflate(R.layout.fragment_fourth,container,false);

        fourth_item_image = (ImageView) view.findViewById(R.id.fourth_RecyclerView_Item_Image);
        fourth_RecyclerView = (RecyclerView) view.findViewById(R.id.fourth_RecyclerView);

        setRecyclerView();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void setRecyclerView(){
        fourth_recyclerView_items = new ArrayList<Fourth_RecyclerView_Item>();


        fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("공지사항",R.drawable.fourth_item_speaker));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("튜티 정보",R.drawable.fourth_item_tuty));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("보고서 쓰기",R.drawable.fourth_item_report));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("버전정보",R.drawable.fourth_item_i));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("도움말",R.drawable.fourth_item_qna));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("개발자",R.drawable.fourth_item_developer));

        fourth_recyclerView_adapter = new Fourth_RecyclerView_Adapter(getContext(),fourth_recyclerView_items);
        fourth_RecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        fourth_RecyclerView.setAdapter(fourth_recyclerView_adapter);
    }

}

