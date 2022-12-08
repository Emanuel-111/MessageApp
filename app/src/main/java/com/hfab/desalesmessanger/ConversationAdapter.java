package com.hfab.desalesmessanger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.ConversationViewHolder> {

    private FragmentManager fm;
    private ArrayList<Conversation> conversations;

    public ConversationAdapter (FragmentManager fm, ArrayList<Conversation> conversations)
    {
        this.fm = fm;
        this.conversations = conversations;
    }

    @NonNull
    @Override
    public ConversationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.conversation_row_item, parent, false);

        return new ConversationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConversationViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    class ConversationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        private ImageView profilePicture;
        private TextView person1;
        private TextView person2;

        public ConversationViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
