package com.example.user.mcfm.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.mcfm.Adapter_Item.First_RecyclerView_Item;
import com.example.user.mcfm.Adapter_Item.Fourth_RecyclerView_Dialog_QNA_Item;
import com.example.user.mcfm.R;

import java.util.List;

/**
 * Created by User on 2017-10-11.
 */

public class Fourth_RecyclerView_Dialog_QNA_Adapter extends RecyclerView.Adapter<Fourth_RecyclerView_Dialog_QNA_Adapter.ViewHolder> {
    private Context context;
    private List<Fourth_RecyclerView_Dialog_QNA_Item> fourth_recyclerView_dialog_qna_items;

    public Fourth_RecyclerView_Dialog_QNA_Adapter(Context context, List<Fourth_RecyclerView_Dialog_QNA_Item> fourth_recyclerView_dialog_qna_items) {
        this.context = context;
        this.fourth_recyclerView_dialog_qna_items = fourth_recyclerView_dialog_qna_items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fourth_recyclerview_item_qna_dialog, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.position.setText(fourth_recyclerView_dialog_qna_items.get(position).getPosition());
        holder.content.setText(fourth_recyclerView_dialog_qna_items.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return fourth_recyclerView_dialog_qna_items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView position;
        public TextView content;
        public LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            position = (TextView) itemView.findViewById(R.id.fourth_RecyclerView_Item_QNA_Dialog_position);
            content = (TextView) itemView.findViewById(R.id.fourth_RecyclerView_Item_QNA_Dialog_content);
        }
    }
}
