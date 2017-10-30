package com.example.user.mcfm.ViewPager_fragment;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.CursorLoader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.user.mcfm.Adapter.Fourth_RecyclerView_Adapter;
import com.example.user.mcfm.Adapter_Item.Fourth_RecyclerView_Item;
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


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQEUST_OK) {
            if (resultCode == Activity.RESULT_OK) {
                Intent photo_intent = new Intent(Contact.SetProfilePhoto);


                Log.e("FOURTH_FRAGMENT_DATA",getImageNameToUri(data.getData()));
                String real = getImageNameToUri(data.getData());
                photo_intent.putExtra("ph", real);
                getContext().sendBroadcast(photo_intent);
                //File file = new File(real);
                //Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());

                Picasso.with(getContext()).load(Uri.fromFile(new File(real))).transform(new CropCircleTransformation()).into(fourth_fragment_profile_Item_Image);

                //Bitmap photo = (Bitmap) data.getExtras().get("data");
                /*try {
                   Bitmap image_bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());


                    fourth_fragment_profile_Item_Image.setImageBitmap(image_bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }*/

            }
        }
    }

     public String getImageNameToUri(Uri data)
    {
        String[] proj = { MediaStore.Images.Media.DATA };
        CursorLoader cursorLoader = new CursorLoader(getContext(),data,proj,null,null,null);
        Cursor cursor = cursorLoader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();

        /*String imgPath = cursor.getString(column_index);
        String imgName = imgPath.substring(imgPath.lastIndexOf("/")+1);*/

        return cursor.getString(column_index);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void setRecyclerView() {
        fourth_recyclerView_items = new ArrayList<Fourth_RecyclerView_Item>();

        fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("공지사항", R.drawable.fourth_item_speaker));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("관심 지역 정보", R.drawable.fourth_item_tuty));
        if(MainActivity.flag == 0)
            fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("보고서 쓰기", R.drawable.fourth_item_report));
        else if(MainActivity.flag == 1){
            fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("후기 작성", R.drawable.fourth_item_report));
        }
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("버전정보", R.drawable.fourth_item_i));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("도움말", R.drawable.fourth_item_qna));
        fourth_recyclerView_items.add(new Fourth_RecyclerView_Item("개발자", R.drawable.fourth_item_developer));

        fourth_recyclerView_adapter = new Fourth_RecyclerView_Adapter(getContext(), fourth_recyclerView_items);
        fourth_RecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        fourth_RecyclerView.setAdapter(fourth_recyclerView_adapter);
    }

}

