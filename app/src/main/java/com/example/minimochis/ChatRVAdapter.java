package com.example.minimochis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatRVAdapter extends RecyclerView.Adapter {
    private ArrayList<ChatModal> chatsArrayList;
    private Context context;

    public ChatRVAdapter(ArrayList<ChatModal> chatsArrayList, Context context) {
        this.chatsArrayList = chatsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_msg,parent, false);
                return new UserViewHolder(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_msg,parent,false);
                return new BotViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    ChatModal chat = chatsArrayList.get(position);
    switch (chat.getSender()) {
        case "user" :
            ((UserViewHolder)holder).userTV.setText(chat.getMessage());
            break;
        case"bot" :
            ((BotViewHolder)holder).BotTV.setText(chat.getMessage());
            break;
    }
}
    @Override
    public int getItemViewType(int position) {
        switch (chatsArrayList.get(position).getSender()) {
            case "user" :
                return 0;
            case "bot":
                return 1;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return chatsArrayList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView userTV;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userTV = itemView.findViewById(R.id.iaTVbot);
        }
    }

    public static class BotViewHolder extends RecyclerView.ViewHolder {
        TextView BotTV;
        public BotViewHolder(@NonNull View itemView) {
            super(itemView);
            BotTV = itemView.findViewById(R.id.iaTVbot);
        }
    }
}

