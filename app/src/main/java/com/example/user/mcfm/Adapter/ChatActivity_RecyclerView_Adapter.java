package com.example.user.mcfm.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.mcfm.Adapter_Item.ChatActivity_RecyclerView_Item;
import com.example.user.mcfm.R;

import java.util.List;

/**
 * Created by User on 2017-10-15.
 */

public class ChatActivity_RecyclerView_Adapter extends RecyclerView.Adapter<ChatActivity_RecyclerView_Adapter.ViewHolder> {
    private Context context;
    private List<ChatActivity_RecyclerView_Item> list;

    public ChatActivity_RecyclerView_Adapter(Context context, List<ChatActivity_RecyclerView_Item> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.chat_name.setText(list.get(position).getChat_name());
        holder.chat_content.setText(list.get(position).getChat_content());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView chat_name;
        public TextView chat_content;

        public ViewHolder(View itemView) {
            super(itemView);
            chat_name = (TextView)itemView.findViewById(R.id.chat_item_name);
            chat_content = (TextView)itemView.findViewById(R.id.chat_item_content);
        }
    }
}






















