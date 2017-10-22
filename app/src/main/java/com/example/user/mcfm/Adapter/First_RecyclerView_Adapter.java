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
import com.example.user.mcfm.Dialog.First_Recycler_Item_Click_Dialog;
import com.example.user.mcfm.R;

import java.util.List;

/**
 * Created by User on 2017-10-11.
 */

public class First_RecyclerView_Adapter extends RecyclerView.Adapter<First_RecyclerView_Adapter.ViewHolder> {
    private Context context;
    private List<First_RecyclerView_Item> first_recyclerView_items;

    public First_RecyclerView_Adapter(Context context, List<First_RecyclerView_Item> first_recyclerView_items) {
        this.context = context;
        this.first_recyclerView_items = first_recyclerView_items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(first_recyclerView_items.get(position).getName());
        holder.place.setText(first_recyclerView_items.get(position).getPlace());
    }

    @Override
    public int getItemCount() {
        return first_recyclerView_items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name;
        public TextView place;
        public LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.first_RecyclerView_Item_Name);
            place = (TextView) itemView.findViewById(R.id.first_RecyclerView_Item_Place);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.first_RecyclerView_item_setClick);
            linearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.first_RecyclerView_item_setClick:
                    int position = getAdapterPosition();    //viewHolder 안에 onclick 을 달아줘야 각 position 에 접근가능
                    Log.e("position_item",first_recyclerView_items.get(position).getName()+first_recyclerView_items.get(position).getPlace());
                    Intent intent = new Intent(view.getContext(), First_Recycler_Item_Click_Dialog.class);
                    intent.putExtra("name",first_recyclerView_items.get(position).getName());
                    intent.putExtra("place",first_recyclerView_items.get(position).getPlace());
                    view.getContext().startActivity(intent);
                    break;
            }
        }
    }
}
