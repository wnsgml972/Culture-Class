package com.example.user.mcfm.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.mcfm.Adapter_Item.Second_RecyclerView_Item;
import com.example.user.mcfm.R;

import java.util.List;

/**
 * Created by User on 2017-10-14.
 */

public class Second_RecyclerView_Adapter extends RecyclerView.Adapter <Second_RecyclerView_Adapter.ViewHolder>{
    private Context context;
    private List<Second_RecyclerView_Item> second_recyclerView_items;
    private RecyclerView second_RecyclerView;
    public Second_RecyclerView_Adapter(Context context, List<Second_RecyclerView_Item> second_recyclerView_items) {
        this.context = context;
        this.second_recyclerView_items = second_recyclerView_items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_recyclerview_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(second_recyclerView_items.get(position).getName());
        holder.place.setText(second_recyclerView_items.get(position).getPlace());
    }

    @Override
    public int getItemCount() {
        return second_recyclerView_items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name;
        public TextView place;
        public ViewHolder(View itemView) {
            super(itemView);
            name= (TextView)itemView.findViewById(R.id.second_RecyclerView_Item_Name);
            place = (TextView)itemView.findViewById(R.id.second_RecyclerView_Item_Place);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
