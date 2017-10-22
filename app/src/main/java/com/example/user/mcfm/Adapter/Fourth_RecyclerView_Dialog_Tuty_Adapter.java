package com.example.user.mcfm.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.mcfm.Adapter_Item.First_RecyclerView_Item;
import com.example.user.mcfm.Adapter_Item.Fourth_RecyclerView_Dialog_Tuty_Item;
import com.example.user.mcfm.Dialog.First_Recycler_Item_Click_Dialog;
import com.example.user.mcfm.R;

import java.util.List;

/**
 * Created by User on 2017-10-11.
 */

public class Fourth_RecyclerView_Dialog_Tuty_Adapter extends RecyclerView.Adapter<Fourth_RecyclerView_Dialog_Tuty_Adapter.ViewHolder> {
    private Context context;
    private List<Fourth_RecyclerView_Dialog_Tuty_Item> fourth_recyclerView_dialog_tuty_items;

    public Fourth_RecyclerView_Dialog_Tuty_Adapter(Context context, List<Fourth_RecyclerView_Dialog_Tuty_Item> fourth_recyclerView_dialog_tuty_items) {
        this.context = context;
        this.fourth_recyclerView_dialog_tuty_items = fourth_recyclerView_dialog_tuty_items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fourth_recyclerview_item_tuty_dialog, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.position.setText(fourth_recyclerView_dialog_tuty_items.get(position).getLocation());
        holder.check.setChecked(fourth_recyclerView_dialog_tuty_items.get(position).getCheck());
    }

    @Override
    public int getItemCount() {
        return fourth_recyclerView_dialog_tuty_items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView position;
        public CheckBox check;
        public LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            position = (TextView) itemView.findViewById(R.id.fourth_RecyclerView_Item_Tuty_Dialog_Location);
            check = (CheckBox) itemView.findViewById(R.id.fourth_RecyclerView_Item_Tuty_Dialog_Check);
        }
    }
}
