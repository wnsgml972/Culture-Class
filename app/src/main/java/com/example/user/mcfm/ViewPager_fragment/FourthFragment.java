package com.example.user.mcfm.ViewPager_fragment;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.user.mcfm.Adapter.Fourth_RecyclerView_Adapter;
import com.example.user.mcfm.Adapter_Item.Fourth_RecyclerView_Item;
import com.example.user.mcfm.R;
import com.example.user.mcfm.Util.Contact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Choiwongyun on 2017-08-20.
 */

public class FourthFragment extends Fragment {

    private RecyclerView fourth_RecyclerView;
    private Fourth_RecyclerView_Adapter fourth_recyclerView_adapter;
    private List<Fourth_RecyclerView_Item> fourth_recyclerView_items;
    private ImageView fourth_item_image;
    private ImageView fourth_fragment_profile_Item_Image;
    private int REQEUST_OK = 102;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View view = (LinearLayout) inflater.inflate(R.layout.fragment_fourth,container,false);
        view = (LinearLayout) inflater.inflate(R.layout.fragment_fourth, container, false);

        fourth_item_image = (ImageView) view.findViewById(R.id.fourth_RecyclerView_Item_Image);
        fourth_RecyclerView = (RecyclerView) view.findViewById(R.id.fourth_RecyclerView);

        fourth_fragment_profile_Item_Image = (ImageView) view.findViewById(R.id.fourth_fragment_profile_Item_Image);
        fourth_fragment_profile_Item_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQEUST_OK);
            }
        });

        setRecyclerView();

        return view;
    }

    private String getPath(Uri uri) {    //이미지의 절대경로 얻는함수
        String result;
        Cursor cursor = getContext().getContentResolver().query(uri, null, null, null, null);

        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = uri.getPath();

        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQEUST_OK) {
            if (resultCode == Activity.RESULT_OK) {
                //String picture_name = getImageNameToUri(data.getData());

                    /*Bitmap image_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                    fourth_fragment_profile_Item_Image.setImageBitmap(image_bitmap);*/
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                try {
                    Bitmap image_bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());

                    Intent photo_intent = new Intent(Contact.SetProfilePhoto);
                    photo_intent.putExtra("ph", getPath(data.getData()));
                    getContext().sendBroadcast(photo_intent);

                    fourth_fragment_profile_Item_Image.setImageBitmap(image_bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //((ImageView)view.findViewById(R.id.fourth_fragment_profile_Item_Image)).setImageBitmap(image_bitmap);

            }
        }
    }

   /* public String getImageNameToUri(Uri data)
    {
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(data, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();

        String imgPath = cursor.getString(column_index);
        String imgName = imgPath.substring(imgPath.lastIndexOf("/")+1);

        return imgName;
    }*/

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void setRecyclerView() {
        fourth_recyclerView_items = new ArrayList<Fourth_RecyclerView_Item>();

        fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("공지사항", R.drawable.fourth_item_speaker));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("관심 지역 정보", R.drawable.fourth_item_tuty));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("보고서 쓰기", R.drawable.fourth_item_report));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("버전정보", R.drawable.fourth_item_i));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("도움말", R.drawable.fourth_item_qna));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("개발자", R.drawable.fourth_item_developer));

        fourth_recyclerView_adapter = new Fourth_RecyclerView_Adapter(getContext(), fourth_recyclerView_items);
        fourth_RecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        fourth_RecyclerView.setAdapter(fourth_recyclerView_adapter);
    }

}

